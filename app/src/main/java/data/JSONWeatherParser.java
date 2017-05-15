package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Util.Utils;
import model.Place;
import model.Weather;

/**
 * Created by kamina on 20.04.2017.
 */

public class JSONWeatherParser {
    public static Weather getWeather(String data){
        Weather weather = new Weather();

        try {
            JSONObject jsonObject = new JSONObject(data);

            Place place = new Place();

            //coord
            JSONObject coorObj = Utils.getObject("coord", jsonObject);
            place.setLat(Utils.getFloat("lat" , coorObj));
            place.setLon(Utils.getFloat("lon" , coorObj));
            //sys
            JSONObject sysObj = Utils.getObject("sys" , jsonObject);
            place.setCountry(sysObj.getString("country"));
            place.setLastupdate(Utils.getInt("dt" , jsonObject));
            place.setSunrise(Utils.getInt("sunrise" , sysObj));
            place.setSunset(Utils.getInt("sunset" , sysObj));
            place.setCity(Utils.getString("city" , jsonObject));
            weather.place = place;
 //GSON WIKI
            //Weather
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject weatherObj = jsonArray.getJSONObject(0);
            weather.currentCundition.setWeatherId(Utils.getInt("id" , weatherObj));
            weather.currentCundition.setDiscription(Utils.getString("description",weatherObj));
            weather.currentCundition.setCondition(Utils.getString("main",weatherObj));
            weather.currentCundition.setIcon(Utils.getString("icon",weatherObj));

            //wind
            JSONObject windObj = Utils.getObject("wind",jsonObject);
            weather.wind.setSpeed(Utils.getFloat("speed",windObj));
            weather.wind.setDeg(Utils.getFloat("deg",windObj));

            //Clouds
            JSONObject cloudsOdj = Utils.getObject("clouds",jsonObject);
            weather.clouds.setPrecipitation(Utils.getInt("all",cloudsOdj));

            return weather;








        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
