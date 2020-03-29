package com.example.bdallnewspaper.activity;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bdallnewspaper.R;
import com.example.bdallnewspaper.adapter.NewspaperAdapter;
import com.example.bdallnewspaper.admob.AdService;
import com.example.bdallnewspaper.helper.DataPass;
import com.example.bdallnewspaper.helper.NewsPaperDao;
import com.example.bdallnewspaper.helper.NewsPaperDaoImplimentation;
import com.example.bdallnewspaper.model.Newspaper;

import java.util.List;

public class TopPortalFragment extends Fragment implements DataPass {

    private RecyclerView recyclerView;
    private List<Newspaper> fierstnewspaper;


    public TopPortalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_portal, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_id);

        NewspaperAdapter newspaperAdapter = new NewspaperAdapter(getContext(),fierstnewspaper);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newspaperAdapter.setOnItemSelected(this);
        recyclerView.setAdapter(newspaperAdapter);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NewsPaperDao banglaNewspaper = new NewsPaperDaoImplimentation();
        fierstnewspaper = banglaNewspaper.topNewspaper();
    }

    @Override
    public void url(String url) {

        //Show Ads
        AdService.adService.showInterstitialAd();

        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("Url",fierstnewspaper.get(Integer.parseInt(url)).getUrl());
        startActivity(intent);
    }
}
