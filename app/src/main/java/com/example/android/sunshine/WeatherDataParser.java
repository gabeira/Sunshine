package com.example.android.sunshine;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by gabriel.b on 02-Dec-14.
 */
public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        JSONObject jsonObject = new JSONObject(weatherJsonStr);
        JSONArray jsonList = jsonObject.getJSONArray("list");

        for (int i = 0; i < jsonList.length(); i++) {
            JSONObject jo = jsonList.getJSONObject(i);
            JSONObject jsonTemp = jo.getJSONObject("temp");
            DateFormat dateFormat = DateFormat.getDateInstance();
            Log.i("GETMAX", "Max:" + jsonTemp.getDouble("max")+" date: "+dateFormat.format(jo.getLong("dt")));
        }


        return -1;
    }

}