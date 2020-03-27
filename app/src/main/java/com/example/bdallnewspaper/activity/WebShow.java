package com.example.bdallnewspaper.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.bdallnewspaper.R;

public class WebShow extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;
    private WebSettings webSettings;
    private WebViewClient webViewClient;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_show);

        webView=findViewById(R.id.webView_id);
        swipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipwrefresh_id);
        webSettings = webView.getSettings();
        
        webSettings.setJavaScriptEnabled(true);
        webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);



        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
             String papername = bundle.getString("Url");
             setUrl(papername);
        }

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(webView, url);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                swipeRefreshLayout.setRefreshing(true);

            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
            }
        });

    }

    public void setUrl(String url){
        webView.loadUrl(url);
    }




}
