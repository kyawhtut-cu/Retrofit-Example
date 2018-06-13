package com.kyawhtut.retrofitexample.util.data.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MeMeResponseList implements Serializable {

    @SerializedName("id")
    public int id;

    @SerializedName("imgLoc")
    public String imgLoc;

    @SerializedName("imageInfo")
    public ImageInfoResponse imgInfoList;
}
