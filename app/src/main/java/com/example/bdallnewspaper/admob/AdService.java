package com.example.bdallnewspaper.admob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class AdService {

    @SuppressLint("StaticFieldLeak")
    public static AdService adService;

    //Ads Counter
    private final int totalAdClick = 2;
    private static volatile int adCounter = 0;
    private Context context;

    //Banner & Ad mInterstitialAd;
    private InterstitialAd mInterstitialAd;

    //AdMob IDS
    private static class AdUnitId{
        final static String GOOGLE_ADMOB_BANNER_UNIT_ID = "ca-app-pub-3940256099942544/6300978111";
        final static String GOOGLE_ADMOB_INTERSTITIAL_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";
    }

    public AdService(Context context) {
        this.context = context;
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(AdUnitId.GOOGLE_ADMOB_INTERSTITIAL_UNIT_ID);
        loadInterstitialAd();
    }

    /**
     * Will add Banner Ads On Activity
     * @param adContainer
     */
    public void addBannerAd(LinearLayout adContainer) {
        AdView adView = new AdView(context);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(AdUnitId.GOOGLE_ADMOB_BANNER_UNIT_ID);

        // Initiate a generic request to load it with an ad
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adContainer.addView(adView);
    }

    /**
     * Load InterstitialAd
     */
    private void loadInterstitialAd(){
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    adCounter = 1;
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            });
    }


    /**
     * Show InterstitialAd
     */
    public synchronized void showInterstitialAd(){
        if(adCounter >= totalAdClick){
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("ERROR", "The interstitial wasn't loaded yet.");
            }
        }else{
            adCounter += 1;
        }
    }

}
