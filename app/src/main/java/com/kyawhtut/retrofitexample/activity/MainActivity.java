package com.kyawhtut.retrofitexample.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kyawhtut.retrofitexample.R;
import com.kyawhtut.retrofitexample.util.adapter.MemeRvAdapter;
import com.kyawhtut.retrofitexample.util.data.response.MeMeResponseList;
import com.kyawhtut.retrofitexample.util.network.ApiRetrofit;
import com.kyawhtut.retrofitexample.util.network.eventbus.MemeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    private MeMeResponseList mData;
    private MemeRvAdapter memeRvAdapter;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        memeRvAdapter = new MemeRvAdapter(this, (data, index) -> {
            showImageInfo(data);
        });
        mRvList.setHasFixedSize(true);
        mRvList.setLayoutManager(new GridLayoutManager(this, 3));
        mRvList.setAdapter(memeRvAdapter);

        ApiRetrofit.getINSTANCE().getAllData();

        mFab.setOnClickListener(view -> {
            loadDataWithPage(view);
            page += page;
        });
    }

    private void loadDataWithPage(View view) {
        Snackbar.make(view, "Getting another data with page : " + page, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        ApiRetrofit.getINSTANCE().getDataWithPage(page);
    }

    private void showImageInfo(MeMeResponseList data) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Image Info")
                .setMessage("Name : "+data.imgInfoList.imageName+"\nSize : "+data.imgInfoList.size);
        alert.show();
    }

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }

    @Subscribe
    public void finishLoadData(MemeEvent event) {
        Snackbar.make(mFab, "Loading " + event.message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        if (event.message.equals("success")) {
            memeRvAdapter.swipeData(event.mResponse.mList);
        }
    }
}
