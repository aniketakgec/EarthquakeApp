package com.example.android.quakereport;

import java.util.Date;

public class EarthquakeData {
    private double mMagnitude;

    private String mPlace;

private String murl;
    private long mTimeInMilliseconds;


       public EarthquakeData( double magnitude,String place, long timeInMilliseconds,String url)
    {
        mTimeInMilliseconds=timeInMilliseconds;
        mPlace = place;
        mMagnitude = magnitude;
        murl=url;
    }


    public double getMagnitude() {
        return mMagnitude;
    }


    public String getPlace() {
        return mPlace;
    }
    public String getUrl() {
        return murl;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

}
