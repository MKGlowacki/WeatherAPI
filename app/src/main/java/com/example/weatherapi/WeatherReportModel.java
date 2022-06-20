package com.example.weatherapi;

public class WeatherReportModel {
//            "maxtemp_c": 26.9,
//            "mintemp_c": 10.9,
//            "avgtemp_c": 19.5,
//            "maxwind_kph": 23.4,
//            "totalprecip_mm": 0.7,
//            "avgvis_km": 10,
//            "avghumidity": 70,
//            "daily_will_it_rain": 1,
//            "daily_chance_of_rain": 86,
//            "daily_will_it_snow": 0,
//            "daily_chance_of_snow": 0,
//            "condition": {
        //        "text": "Patchy rain possible",
        //                "icon": "//cdn.weatherapi.com/weather/64x64/day/176.png",
        //                "code": 1063
        //    },
//            "uv": 7

    private float maxtemp_c;
    private float mintemp_c;
    private float avgtemp_c;
    private float maxwind_kph;
    private float totalprecip_mm;
    private int avgvis_km;
    private int avghumidity;
    private int daily_will_it_rain;
    private int daily_chance_of_rain;
    private  int daily_will_it_snow;
    private int daily_chance_of_snow;
    private String city_name;
    private String city_country;
    private String date;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_country() {
        return city_country;
    }

    public void setCity_country(String city_country) {
        this.city_country = city_country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherReportModel() {

    }

    public WeatherReportModel(float maxtemp_c, float mintemp_c, float avgtemp_c, float maxwind_kph, float totalprecip_mm, int avgvis_km, int avghumidity, int daily_will_it_rain, int daily_chance_of_rain, int daily_will_it_snow, int daily_chance_of_snow, String city_name, String city_country, String date) {
        this.maxtemp_c = maxtemp_c;
        this.mintemp_c = mintemp_c;
        this.avgtemp_c = avgtemp_c;
        this.maxwind_kph = maxwind_kph;
        this.totalprecip_mm = totalprecip_mm;
        this.avgvis_km = avgvis_km;
        this.avghumidity = avghumidity;
        this.daily_will_it_rain = daily_will_it_rain;
        this.daily_chance_of_rain = daily_chance_of_rain;
        this.daily_will_it_snow = daily_will_it_snow;
        this.daily_chance_of_snow = daily_chance_of_snow;
        this.city_name = city_name;
        this.city_country = city_country;
        this.date = date;
    }

    @Override
    public String toString() {
        return
                date + "\n" +
                city_name + ", "
                + city_country +


                "\nMax temperature: " + maxtemp_c +
                ", Total precipitation: " + totalprecip_mm;
    }


    public float getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(float maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public float getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(float mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public float getAvgtemp_c() {
        return avgtemp_c;
    }

    public void setAvgtemp_c(float avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    public float getMaxwind_kph() {
        return maxwind_kph;
    }

    public void setMaxwind_kph(float maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

    public float getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public void setTotalprecip_mm(float totalprecip_mm) {
        this.totalprecip_mm = totalprecip_mm;
    }

    public int getAvgvis_km() {
        return avgvis_km;
    }

    public void setAvgvis_km(int avgvis_km) {
        this.avgvis_km = avgvis_km;
    }

    public int getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(int avghumidity) {
        this.avghumidity = avghumidity;
    }

    public double getDaily_will_it_rain() {
        return daily_will_it_rain;
    }

    public void setDaily_will_it_rain(int daily_will_it_rain) {
        this.daily_will_it_rain = daily_will_it_rain;
    }

    public int getDaily_chance_of_rain() {
        return daily_chance_of_rain;
    }

    public void setDaily_chance_of_rain(int daily_chance_of_rain) {
        this.daily_chance_of_rain = daily_chance_of_rain;
    }

    public double getDaily_will_it_snow() {
        return daily_will_it_snow;
    }

    public void setDaily_will_it_snow(int daily_will_it_snow) {
        this.daily_will_it_snow = daily_will_it_snow;
    }

    public int getDaily_chance_of_snow() {
        return daily_chance_of_snow;
    }

    public void setDaily_chance_of_snow(int daily_chance_of_snow) {
        this.daily_chance_of_snow = daily_chance_of_snow;
    }


}
