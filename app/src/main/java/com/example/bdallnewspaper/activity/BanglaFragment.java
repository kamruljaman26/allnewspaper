package com.example.bdallnewspaper.activity;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bdallnewspaper.admob.AdService;
import com.example.bdallnewspaper.model.Newspaper;
import com.example.bdallnewspaper.R;
import com.example.bdallnewspaper.adapter.NewspaperAdapter;
import com.example.bdallnewspaper.helper.DataPass;
import com.example.bdallnewspaper.helper.NewsPaperDao;
import com.example.bdallnewspaper.helper.NewsPaperDaoImplimentation;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BanglaFragment extends Fragment implements View.OnClickListener, DataPass {

    private List<Newspaper> fierstnewspaper;

    public BanglaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       //  Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_bangla, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_id);

        //NewsPaper DAO
        NewsPaperDao banglaNewspaper = new NewsPaperDaoImplimentation();
        fierstnewspaper = banglaNewspaper.banglaNewspaper();

        NewspaperAdapter newspaperAdapter = new NewspaperAdapter(getContext(),fierstnewspaper);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newspaperAdapter.setOnItemSelected(this);
        recyclerView.setAdapter(newspaperAdapter);

       return view;
    }

    @Override
    public void onClick(View v) {
         Intent intent = new Intent(getContext(), WebActivity.class);
         intent.putExtra("Url","prothomAlo");
         startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void url(String URL) {
        //Show Ads
        AdService.adService.showInterstitialAd();

        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("Url",fierstnewspaper.get(Integer.parseInt(URL)).getUrl());
        startActivity(intent);
    }
}
