package com.kyawhtut.retrofitexample.util.data.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImageInfoResponse implements Serializable {

    @SerializedName("width")
    public int width;

    @SerializedName("height")
    public int height;

    @SerializedName("baseUrl")
    public String baseUrl;

    @SerializedName("imageName")
    public String imageName;

    @SerializedName("extension")
    public String extension;

    @SerializedName("size")
    public String size;

    @SerializedName("type")
    public String type;
}
