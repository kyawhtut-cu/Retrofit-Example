package com.kyawhtut.retrofitexample.util.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import com.kyawhtut.retrofitexample.util.adapter.view.BaseView;
import com.kyawhtut.retrofitexample.util.data.response.MeMeResponseList;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRvAdapter<V extends BaseView, D> extends RecyclerView.Adapter<V> {

    protected LayoutInflater mLayoutInflater;
    protected List<D> mData;

    public BaseRvAdapter(Context ctx) {
        mLayoutInflater = LayoutInflater.from(ctx);
        mData = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return (mData.size() == 0) ? 0 : mData.size();
    }

    public void clearData() {
        mData = new ArrayList<>();
        notifyDataSetChanged();
    }

    public void addData(D data) {
        mData.add(data);
        notifyDataSetChanged();
    }

    public void swipeData(List<D> data) {
        Log.i("Data change : ", data.size() + "");
        mData = data;
        notifyDataSetChanged();
    }

    public D getDataWithIndex(int index) {
        return mData.get(index);
    }
}
