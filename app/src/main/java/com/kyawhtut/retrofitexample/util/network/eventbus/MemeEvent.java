package com.kyawhtut.retrofitexample.util.network.eventbus;

import com.kyawhtut.retrofitexample.util.data.MemeResponse;

public class MemeEvent {

    public String message;
    public MemeResponse mResponse;

    public MemeEvent(String message, MemeResponse mResponse) {
        this.message = message;
        this.mResponse = mResponse;
    }

    public MemeEvent(String message) {
        this.message = message;
    }
}
