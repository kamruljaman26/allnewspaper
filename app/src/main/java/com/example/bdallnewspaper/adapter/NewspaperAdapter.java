package com.example.bdallnewspaper.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdallnewspaper.model.Newspaper;
import com.example.bdallnewspaper.R;
import com.example.bdallnewspaper.helper.DataPass;

import java.util.List;


public class NewspaperAdapter extends RecyclerView.Adapter<NewspaperAdapter.MyViewHolder> {

    Context context ;
    List<Newspaper> mData;
    Dialog mydialog;
    DataPass dataPass;



    private Object Log;

    public NewspaperAdapter(Context context, List<Newspaper> mData) {
        this.context = context;
        this.mData = mData;
    }

    /**
     * Interface Method
     */
    public void setOnItemSelected(DataPass dataPass){
        this.dataPass = dataPass;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        view = LayoutInflater.from(context).inflate(R.layout.item_bangla_fragment,parent,false);


       // MyViewHolder viewHolder = new MyViewHolder(view);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.imageView.setImageResource(mData.get(position).getPhoto());
        // on item click
        holder.imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // get position
                dataPass.url(position+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview_id);
        }
    }



}



