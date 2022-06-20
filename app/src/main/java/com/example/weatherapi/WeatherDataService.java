package com.example.weatherapi;

import android.app.DownloadManager;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String QUERY_FOR_CITYCOUNTRY = "http://api.weatherapi.com/v1/current.json?key=19a09e15bb1348ad8e8132418221806&q=";
    public static final String QUERY_FOR_FORECASTWEATHERBYNAME = "https://api.weatherapi.com/v1/forecast.json?key=19a09e15bb1348ad8e8132418221806&q=";

    Context context;
    String cityCountry;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(String cityCountry);
    }

    public void getCityCountry(String cityName, VolleyResponseListener volleyResponseListener){
        String url = QUERY_FOR_CITYCOUNTRY +cityName+"&aqi=no";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                cityCountry = "";
                try {
                    JSONObject cityInfo = response.getJSONObject("location");
                    cityCountry = cityInfo.getString("country");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                volleyResponseListener.onResponse(cityCountry);

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Something wrong");
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);


    }

    public interface ForecastByNameVolleyResponseListener{
        void onError(String message);

        void onResponse(List<WeatherReportModel> weatherReportModels);
    }


    public void getCityForecastByName(String cityName, ForecastByNameVolleyResponseListener forecastByNameVolleyResponseListener){
        List<WeatherReportModel> weatherReportModels = new ArrayList<>();

        String url = QUERY_FOR_FORECASTWEATHERBYNAME + cityName + "&days=3&aqi=no&alerts=no";

        //get the json object
       JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                Toast.makeText(context, response.toString(),Toast.LENGTH_SHORT).show();

                try {
                    JSONObject city_country = response.getJSONObject("location");
                    JSONArray forecastday = (response.getJSONObject("forecast")).getJSONArray("forecastday");




                    for(int i = 0; i < forecastday.length(); i++){
                        WeatherReportModel one_day = new WeatherReportModel();
                        JSONObject one_day_weather_api = ( (JSONObject) forecastday.get(i)).getJSONObject("day");
                        one_day.setMaxtemp_c((float) one_day_weather_api.getDouble("maxtemp_c"));
                        one_day.setMintemp_c((float) one_day_weather_api.getDouble("mintemp_c"));
                        one_day.setAvgtemp_c((float) one_day_weather_api.getDouble("avgtemp_c"));
                        one_day.setMaxwind_kph((float) one_day_weather_api.getDouble("maxwind_kph"));
                        one_day.setTotalprecip_mm((float) one_day_weather_api.getDouble("totalprecip_mm"));
                        one_day.setAvgvis_km(one_day_weather_api.getInt("avgvis_km"));
                        one_day.setAvghumidity(one_day_weather_api.getInt("avghumidity"));
                        one_day.setDaily_will_it_rain(one_day_weather_api.getInt("daily_will_it_rain"));
                        one_day.setDaily_chance_of_rain(one_day_weather_api.getInt("daily_chance_of_rain"));
                        one_day.setDaily_will_it_snow(one_day_weather_api.getInt("daily_will_it_snow"));
                        one_day.setDaily_chance_of_snow(one_day_weather_api.getInt("daily_chance_of_snow"));
                        one_day.setCity_country(city_country.getString("country"));
                        one_day.setCity_name(city_country.getString("name"));
                        one_day.setDate((String) ((JSONObject) forecastday.get(i)).get("date"));

                        weatherReportModels.add(one_day);

                    }




                    forecastByNameVolleyResponseListener.onResponse(weatherReportModels);



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);

        //get the propety forecast - object

        //get the property forecastday - arry

        //get each item in the array and assgin it to a new WeatherReportModel object
    }
}
