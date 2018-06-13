package com.kyawhtut.retrofitexample.util.data;

import com.google.gson.annotations.SerializedName;
import com.kyawhtut.retrofitexample.util.data.response.MeMeResponseList;

import java.io.Serializable;
import java.util.List;

public class MemeResponse implements Serializable{

    @SerializedName("memes")
    public List<MeMeResponseList> mList;

    @SerializedName("totalcount")
    public int totalcount;
}
