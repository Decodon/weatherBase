package controllers;

import play.Logger;
import play.mvc.Controller;
import models.Station;
import models.Reading;
import utils.StationAnalytics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StationCtrl extends Controller {


    public static void index(Long id) {
        Station station = Station.findById(id);
        Logger.info("Station id = " + id);
        //Reading maxTemperature = StationAnalytics.getMaxTemperature(station.readings);
       // Reading minTemperature = StationAnalytics.getMinTemperature(station.readings);
        station.latestConditionTemperatureC = StationAnalytics.getlatestConditionTemperatureC(station.readings);
        station.latestConditionTemperatureF = StationAnalytics.getlatestConditionTemperatureF(station.readings);
        station.latestConditionCode = StationAnalytics.getlatestConditionCode(station.readings);
        station.latestConditionWindSpeed = StationAnalytics.getlatestConditionWindSpeed(station.readings);
        station.latestConditionPressure = StationAnalytics.getlatestConditionPressure(station.readings);
        station.latestConditionWindDirection = StationAnalytics.getlatestConditionWindDirection(station.readings);
        station.windChill = StationAnalytics.getWindChill(station.readings);
        station.minTemperature = StationAnalytics.getMinTemperature(station.readings);
        station.maxTemperature = StationAnalytics.getMaxTemperature(station.readings);


        if (station.latestConditionCode == 100) {
            station.weatherCode = "Clear";
        } else if (station.latestConditionCode == 200) {
            station.weatherCode = "Partial Clouds";
        } else if (station.latestConditionCode == 300) {
            station.weatherCode = "Cloudy";
        } else if (station.latestConditionCode == 400) {
            station.weatherCode = "Light Showers";
        } else if (station.latestConditionCode == 500) {
            station.weatherCode = "Heavy Showers";
        } else if (station.latestConditionCode == 600) {
            station.weatherCode = "Rain";
        } else if (station.latestConditionCode == 700) {
            station.weatherCode = "Snow";
        } else if (station.latestConditionCode == 800) {
            station.weatherCode = "Thunder";
        } else station.weatherCode = "Please enter in terms of hundreds";

        if (station.latestConditionCode == 100) {
            station.weatherIcon = "sun";
        } else if (station.latestConditionCode == 200) {
            station.weatherIcon = "cloud";
        } else if (station.latestConditionCode == 300) {
            station.weatherIcon = "cloud meatball";
        } else if (station.latestConditionCode == 400) {
            station.weatherIcon = "cloud sun rain";
        } else if (station.latestConditionCode == 500) {
            station.weatherIcon = "cloud showers heavy";
        } else if (station.latestConditionCode == 600) {
            station.weatherIcon = "cloud rain";
        } else if (station.latestConditionCode == 700) {
            station.weatherIcon = "snowflake";
        } else if (station.latestConditionCode == 800) {
            station.weatherIcon = "bolt";
        } else station.weatherIcon = "Please enter in terms of hundreds";

        if (station.latestConditionWindSpeed == 1) {
            station.beaufort = "0bft - Calm";
        } else if (station.latestConditionWindSpeed > 1 && station.latestConditionWindSpeed <= 5) {
            station.beaufort = "1bft - Light Air ";
        } else if (station.latestConditionWindSpeed > 5 && station.latestConditionWindSpeed <= 11) {
            station.beaufort = "2bft - Light Breeze";
        } else if (station.latestConditionWindSpeed > 12 && station.latestConditionWindSpeed <= 19) {
            station.beaufort = "3bft - Gentle Breeze";
        } else if (station.latestConditionWindSpeed > 19 && station.latestConditionWindSpeed <= 28) {
            station.beaufort = "4bft- Moderate Breeze";
        } else if (station.latestConditionWindSpeed > 28 && station.latestConditionWindSpeed <= 38) {
            station.beaufort = "5bft - Fresh Breeze";
        } else if (station.latestConditionWindSpeed > 38 && station.latestConditionWindSpeed <= 49) {
            station.beaufort = "6bft - Strong Breeze";
        } else if (station.latestConditionWindSpeed > 49 && station.latestConditionWindSpeed <= 61) {
            station.beaufort = "7bft - Near Gale";
        } else if (station.latestConditionWindSpeed > 61 && station.latestConditionWindSpeed <= 74) {
            station.beaufort = "8bft - Gale";
        } else if (station.latestConditionWindSpeed > 74 && station.latestConditionWindSpeed <= 88) {
            station.beaufort = "9bft - Severe Gale";
        } else if (station.latestConditionWindSpeed > 88 && station.latestConditionWindSpeed <= 102) {
            station.beaufort = "10bft - Strong Storm";
        } else if (station.latestConditionWindSpeed > 102 && station.latestConditionWindSpeed <= 117) {
            station.beaufort = "11bft - Violent Storm";
        } else if (station.latestConditionWindSpeed > 117) {
            station.beaufort = "Off the Charts";
        }

        if (station.latestConditionWindDirection > 348.75 && station.latestConditionWindDirection <= 360) {
            station.compass = "N";
        } else if (station.latestConditionWindDirection>= 0 && station.latestConditionWindDirection<= 11.25) {
            station.compass = "N";
        } else if (station.latestConditionWindDirection > 11.25 && station.latestConditionWindDirection <= 33.75) {
            station.compass = "NNE";
        } else if (station.latestConditionWindDirection > 33.75 && station.latestConditionWindDirection <= 56.25) {
            station.compass = "NE";
        } else if (station.latestConditionWindDirection > 56.25 && station.latestConditionWindDirection <= 78.75) {
            station.compass = "ENE";
        } else if (station.latestConditionWindDirection > 78.5 && station.latestConditionWindDirection <= 101.25) {
            station.compass = "E";
        } else if (station.latestConditionWindDirection > 101.25 && station.latestConditionWindDirection <= 123.75) {
            station.compass = "ESE";
        } else if (station.latestConditionWindDirection> 123.75 && station.latestConditionWindDirection <= 146.25) {
            station.compass = "SE";
        } else if (station.latestConditionWindDirection > 146.25 && station.latestConditionWindDirection <= 168.75) {
            station.compass = "SSE";
        } else if (station.latestConditionWindDirection > 168.75 && station.latestConditionWindDirection <= 191.25) {
            station.compass = "S";
        } else if (station.latestConditionWindDirection > 191.25 && station.latestConditionWindDirection <= 213.75) {
            station.compass = "SSW";
        } else if (station.latestConditionWindDirection > 213.75 && station.latestConditionWindDirection <= 236.25) {
            station.compass = "SW";
        } else if (station.latestConditionWindDirection > 236.25 && station.latestConditionWindDirection <= 258.75) {
            station.compass = "WSW";
        } else if (station.latestConditionWindDirection > 258.75 && station.latestConditionWindDirection <= 281.25) {
            station.compass = "W";
        } else if (station.latestConditionWindDirection > 281.25 && station.latestConditionWindDirection <= 303.75) {
            station.compass = "WNW";
        } else if (station.latestConditionWindDirection > 303.75 && station.latestConditionWindDirection <= 326.25) {
            station.compass = "NW";
        } else if (station.latestConditionWindDirection > 326.25 && station.latestConditionWindDirection <= 348.75) {
            station.compass = "NNW";
        } else if (station.latestConditionWindDirection > 360.0) {
            station.compass = "Degrees 0-360 please";
        }


        //Reading latestConditions = StationAnalytics.getlatestConditions(station);

        render("station.html", "tags/latestconditions.html", station);
                //maxTemperature, minTemperature);
    }

    public static void deleteReading(Long id, Long readingid) {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info("Removing " + reading.code);
        station.readings.remove(reading);
        //Reading maxTemperature = StationAnalytics.getMaxTemperature(station.readings);
        //Reading minTemperature = StationAnalytics.getMinTemperature(station.readings);
        Double latestCondition = StationAnalytics.getlatestConditionTemperatureC(station.readings);
        station.latestConditionTemperatureC = StationAnalytics.getlatestConditionTemperatureC(station.readings);
        station.latestConditionTemperatureF = StationAnalytics.getlatestConditionTemperatureF(station.readings);
        station.latestConditionCode = StationAnalytics.getlatestConditionCode(station.readings);
        station.latestConditionWindSpeed = StationAnalytics.getlatestConditionWindSpeed(station.readings);
        station.latestConditionPressure = StationAnalytics.getlatestConditionPressure(station.readings);
        station.latestConditionWindDirection = StationAnalytics.getlatestConditionWindDirection(station.readings);
        station.windChill = StationAnalytics.getWindChill(station.readings);
        if (station.latestConditionCode == 100) {
            station.weatherCode = "Clear";
        } else if (station.latestConditionCode == 200) {
            station.weatherCode = "Partial Clouds";
        } else if (station.latestConditionCode == 300) {
            station.weatherCode = "Cloudy";
        } else if (station.latestConditionCode == 400) {
            station.weatherCode = "Light Showers";
        } else if (station.latestConditionCode == 500) {
            station.weatherCode = "Heavy Showers";
        } else if (station.latestConditionCode == 600) {
            station.weatherCode = "Rain";
        } else if (station.latestConditionCode == 700) {
            station.weatherCode = "Snow";
        } else if (station.latestConditionCode == 800) {
            station.weatherCode = "Thunder";
        } else station.weatherCode = "Please enter in terms of hundreds";

        if (station.latestConditionCode == 100) {
            station.weatherIcon = "sun";
        } else if (station.latestConditionCode == 200) {
            station.weatherIcon = "cloud";
        } else if (station.latestConditionCode == 300) {
            station.weatherIcon = "cloud meatball";
        } else if (station.latestConditionCode == 400) {
            station.weatherIcon = "cloud sun rain";
        } else if (station.latestConditionCode == 500) {
            station.weatherIcon = "cloud showers heavy";
        } else if (station.latestConditionCode == 600) {
            station.weatherIcon = "cloud rain";
        } else if (station.latestConditionCode == 700) {
            station.weatherIcon = "snowflake";
        } else if (station.latestConditionCode == 800) {
            station.weatherIcon = "bolt";
        } else station.weatherIcon = "Please enter in terms of hundreds";

        if (station.latestConditionWindSpeed == 1) {
            station.beaufort = "0bft - Calm";
        } else if (station.latestConditionWindSpeed > 1 && station.latestConditionWindSpeed <= 5) {
            station.beaufort = "1bft - Light Air ";
        } else if (station.latestConditionWindSpeed > 5 && station.latestConditionWindSpeed <= 11) {
            station.beaufort = "2bft - Light Breeze";
        } else if (station.latestConditionWindSpeed > 12 && station.latestConditionWindSpeed <= 19) {
            station.beaufort = "3bft - Gentle Breeze";
        } else if (station.latestConditionWindSpeed > 19 && station.latestConditionWindSpeed <= 28) {
            station.beaufort = "4bft- Moderate Breeze";
        } else if (station.latestConditionWindSpeed > 28 && station.latestConditionWindSpeed <= 38) {
            station.beaufort = "5bft - Fresh Breeze";
        } else if (station.latestConditionWindSpeed > 38 && station.latestConditionWindSpeed <= 49) {
            station.beaufort = "6bft - Strong Breeze";
        } else if (station.latestConditionWindSpeed > 49 && station.latestConditionWindSpeed <= 61) {
            station.beaufort = "7bft - Near Gale";
        } else if (station.latestConditionWindSpeed > 61 && station.latestConditionWindSpeed <= 74) {
            station.beaufort = "8bft - Gale";
        } else if (station.latestConditionWindSpeed > 74 && station.latestConditionWindSpeed <= 88) {
            station.beaufort = "9bft - Severe Gale";
        } else if (station.latestConditionWindSpeed > 88 && station.latestConditionWindSpeed <= 102) {
            station.beaufort = "10bft - Strong Storm";
        } else if (station.latestConditionWindSpeed > 102 && station.latestConditionWindSpeed <= 117) {
            station.beaufort = "11bft - Violent Storm";
        } else if (station.latestConditionWindSpeed > 117) {
            station.beaufort = "Off the Charts";
        }

        if (station.latestConditionWindDirection > 348.75 && station.latestConditionWindDirection <= 360) {
            station.compass = "N";
        } else if (station.latestConditionWindDirection>= 0 && station.latestConditionWindDirection<= 11.25) {
            station.compass = "N";
        } else if (station.latestConditionWindDirection > 11.25 && station.latestConditionWindDirection <= 33.75) {
            station.compass = "NNE";
        } else if (station.latestConditionWindDirection > 33.75 && station.latestConditionWindDirection <= 56.25) {
            station.compass = "NE";
        } else if (station.latestConditionWindDirection > 56.25 && station.latestConditionWindDirection <= 78.75) {
            station.compass = "ENE";
        } else if (station.latestConditionWindDirection > 78.5 && station.latestConditionWindDirection <= 101.25) {
            station.compass = "E";
        } else if (station.latestConditionWindDirection > 101.25 && station.latestConditionWindDirection <= 123.75) {
            station.compass = "ESE";
        } else if (station.latestConditionWindDirection> 123.75 && station.latestConditionWindDirection <= 146.25) {
            station.compass = "SE";
        } else if (station.latestConditionWindDirection > 146.25 && station.latestConditionWindDirection <= 168.75) {
            station.compass = "SSE";
        } else if (station.latestConditionWindDirection > 168.75 && station.latestConditionWindDirection <= 191.25) {
            station.compass = "S";
        } else if (station.latestConditionWindDirection > 191.25 && station.latestConditionWindDirection <= 213.75) {
            station.compass = "SSW";
        } else if (station.latestConditionWindDirection > 213.75 && station.latestConditionWindDirection <= 236.25) {
            station.compass = "SW";
        } else if (station.latestConditionWindDirection > 236.25 && station.latestConditionWindDirection <= 258.75) {
            station.compass = "WSW";
        } else if (station.latestConditionWindDirection > 258.75 && station.latestConditionWindDirection <= 281.25) {
            station.compass = "W";
        } else if (station.latestConditionWindDirection > 281.25 && station.latestConditionWindDirection <= 303.75) {
            station.compass = "WNW";
        } else if (station.latestConditionWindDirection > 303.75 && station.latestConditionWindDirection <= 326.25) {
            station.compass = "NW";
        } else if (station.latestConditionWindDirection > 326.25 && station.latestConditionWindDirection <= 348.75) {
            station.compass = "NNW";
        } else if (station.latestConditionWindDirection > 360.0) {
            station.compass = "Degrees 0-360 please";
        }

        station.save();
        reading.delete();

        render("station.html", "latestconditions.html", station,  latestCondition);
    }

    public static void addReading(Long id, int code, double temperature, double windSpeed, double pressure, double windDirection) {
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        station.latestConditionTemperatureC = StationAnalytics.getlatestConditionTemperatureC(station.readings);
        station.latestConditionTemperatureF = StationAnalytics.getlatestConditionTemperatureF(station.readings);
        station.latestConditionCode = StationAnalytics.getlatestConditionCode(station.readings);
        station.latestConditionWindSpeed = StationAnalytics.getlatestConditionWindSpeed(station.readings);
        station.latestConditionPressure = StationAnalytics.getlatestConditionPressure(station.readings);
        station.latestConditionWindDirection = StationAnalytics.getlatestConditionWindDirection(station.readings);
        station.windChill = StationAnalytics.getWindChill(station.readings);

        redirect("/stations/" + id);
        render("station.html", station);
    }


}