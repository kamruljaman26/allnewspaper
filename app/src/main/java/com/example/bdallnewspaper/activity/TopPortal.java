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
import com.example.bdallnewspaper.adapter.RecyelerView_Addpter;
import com.example.bdallnewspaper.helper.DataPass;
import com.example.bdallnewspaper.helper.NewsPaperDao;
import com.example.bdallnewspaper.helper.NewsPaperDaoImplimentation;
import com.example.bdallnewspaper.model.Newspaper;

import java.util.List;

public class TopPortal extends Fragment implements DataPass {

    BanglaFragment banglaFragment ;
    private RecyclerView recyclerView;
    private List<Newspaper> fierstnewspaper;


    public TopPortal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_portal, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_id);

        RecyelerView_Addpter recyelerView_addpter = new RecyelerView_Addpter(getContext(),fierstnewspaper);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyelerView_addpter.setOnItemSelected(this);
        recyclerView.setAdapter(recyelerView_addpter);

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
        Intent intent = new Intent(getContext(), WebShow.class);
        intent.putExtra("Url",fierstnewspaper.get(Integer.parseInt(url)).getUrl());
        startActivity(intent);
    }
}
