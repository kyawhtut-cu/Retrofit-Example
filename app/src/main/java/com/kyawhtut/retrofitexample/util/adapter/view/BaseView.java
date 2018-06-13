package com.kyawhtut.retrofitexample.util.adapter.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseView<D> extends RecyclerView.ViewHolder implements View.OnClickListener{

    protected D data;

    public BaseView(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    }

    public abstract void bind(D data);

    public interface MemeItemClickListener<D>{
        void onClicked(D data,int positon);
    }
}
