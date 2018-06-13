package com.kyawhtut.retrofitexample.util.adapter.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kyawhtut.retrofitexample.R;
import com.kyawhtut.retrofitexample.util.data.response.MeMeResponseList;

import butterknife.BindView;

public class ItemView extends BaseView<MeMeResponseList> {

    private MemeItemClickListener<MeMeResponseList> itemClickListener;

    @BindView(R.id.meme_img)
    ImageView memeImg;

    @BindView(R.id.meme_size)
    TextView memeSize;

    @BindView(R.id.load_img)
    ImageView mLoadImg;

    public ItemView(View itemView) {
        super(itemView);
        itemView.setOnClickListener(v -> {
            itemClickListener.onClicked(data, getAdapterPosition());
        });
    }

    public ItemView(View itemView, MemeItemClickListener<MeMeResponseList> itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void bind(MeMeResponseList data) {
        super.data = data;
        memeSize.setText(data.imgInfoList.size);
//        mLoadImg.setOnClickListener(v -> {
            Glide.with(itemView.getContext())
                    .load(data.imgLoc)
                    .thumbnail(0.1f)
                    .skipMemoryCache(false)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(memeImg);
//        });
    }
}
