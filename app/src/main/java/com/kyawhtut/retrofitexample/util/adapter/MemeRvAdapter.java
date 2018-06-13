package com.kyawhtut.retrofitexample.util.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.kyawhtut.retrofitexample.R;
import com.kyawhtut.retrofitexample.util.adapter.view.BaseView;
import com.kyawhtut.retrofitexample.util.adapter.view.ItemView;
import com.kyawhtut.retrofitexample.util.data.response.MeMeResponseList;

public class MemeRvAdapter extends BaseRvAdapter<ItemView, MeMeResponseList> {

    private BaseView.MemeItemClickListener<MeMeResponseList> itemClickListener;

    public MemeRvAdapter(Context ctx) {
        super(ctx);
    }

    public MemeRvAdapter(Context ctx, BaseView.MemeItemClickListener<MeMeResponseList> itemClickListener) {
        super(ctx);
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.meme_item, parent, false);
        return new ItemView(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemView holder, int position) {
        holder.bind(getDataWithIndex(position));
    }
}
