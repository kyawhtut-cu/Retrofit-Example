package com.kyawhtut.retrofitexample.util.network.service;

/**
 * Created by KyawHtut on 4/8/2018.
 */

public interface DataAgent {

    public void getAllData();

    public void getDataWithPage(
            int page
    );

    void getDataWithPageAndQuery(
            int page,
            String query
    );
}
