package com.anugrah.myviewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private static String API_KEY = "6393040e75c38e2deaf018f4ead33680.";
    private MutableLiveData<ArrayList<WeathersItems>> listWeathers = new MutableLiveData<>();

    void setWeather(final String cities) {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<WeathersItems> listItems = new ArrayList<>();
        String url = "https://api.openweathermap.org/data/2.5/group?id=" + cities + "&units=metric&appid=" +
                API_KEY;
        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("list");
                    for (int i = 0; i < list.length(); i++) {
                        JSONObject weather = list.getJSONObject(i);
                        WeathersItems weathersItems = new WeathersItems();
                        weathersItems.setId(weather.getInt("id"));
                        weathersItems.setName(weather.getString("name"));
                        weathersItems.setCurrentWeather(weather.getJSONArray("weather").getJSONObject(0).getString("main"));
                        weathersItems.setDesc(weather.getJSONArray("weather").getJSONObject(0).getString("description"));
                        double tempInCelcius = weather.getJSONObject("main").getDouble("temp");
                        weathersItems.setTemp(new DecimalFormat("##.##").format(tempInCelcius));
                        listItems.add(weathersItems);
                    }
                    listWeathers.postValue(listItems);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    LiveData<ArrayList<WeathersItems>> getWeathers() {
        return listWeathers;
    }
}