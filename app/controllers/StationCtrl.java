package controllers;

import play.Logger;
import play.mvc.Controller;
import models.Station;
import models.Reading;
import utils.MaxMin;
import utils.StationAnalytics;
import utils.Trends;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class StationCtrl extends Controller {


    public static void index(Long id) {
        Station station = Station.findById(id);
        Logger.info("Station id = " + id);

        station.latestConditionTemperatureC = StationAnalytics.getlatestConditionTemperatureC(station.readings);
        station.latestConditionTemperatureF = StationAnalytics.getlatestConditionTemperatureF(station.readings);
        station.latestConditionCode = StationAnalytics.getlatestConditionCode(station.readings);
        station.latestConditionWindSpeed = StationAnalytics.getlatestConditionWindSpeed(station.readings);
        station.latestConditionPressure = StationAnalytics.getlatestConditionPressure(station.readings);
        station.latestConditionWindDirection = StationAnalytics.getlatestConditionWindDirection(station.readings);

        station.minTemperature = MaxMin.getMinTemperature(station.readings);
        station.maxTemperature = MaxMin.getMaxTemperature(station.readings);
        station.minWindSpeed = MaxMin.getMinWindSpeed(station.readings);
        station.maxWindSpeed = MaxMin.getMaxWindSpeed(station.readings);
        station.minPressure = MaxMin.getMinPressure(station.readings);
        station.maxPressure = MaxMin.getMaxPressure(station.readings);

        station.temperatureTrends = Trends.getTemperatureTrends(station.readings);
        station.windSpeedTrends = Trends.getWindSpeedTrends(station.readings);
        station.pressureTrends = Trends.getPressureTrends(station.readings);

        station.weatherCode = StationAnalytics.weatherCode(station.latestConditionCode);
        station.weatherIcon = StationAnalytics.weatherIcon(station.latestConditionCode);
        station.beaufort = StationAnalytics.getBeaufortScale(station.readings);
        station.compass = StationAnalytics.getCompassDirection(station.readings);
        station.windChill = StationAnalytics.getWindChill(station.readings);

        //Reading latestConditions = StationAnalytics.getlatestConditions(station);

        render("station.html", "tags/latestconditions.html", station);
        //maxTemperature, minTemperature);
    }

    public static void deleteReading(Long id, Long readingid) {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info("Removing " + reading.code);
        station.readings.remove(reading);
        station.save();
        reading.delete();

        station.latestConditionTemperatureC = StationAnalytics.getlatestConditionTemperatureC(station.readings);
        station.latestConditionTemperatureF = StationAnalytics.getlatestConditionTemperatureF(station.readings);
        station.latestConditionCode = StationAnalytics.getlatestConditionCode(station.readings);
        station.latestConditionWindSpeed = StationAnalytics.getlatestConditionWindSpeed(station.readings);
        station.latestConditionPressure = StationAnalytics.getlatestConditionPressure(station.readings);
        station.latestConditionWindDirection = StationAnalytics.getlatestConditionWindDirection(station.readings);

        station.minTemperature = MaxMin.getMinTemperature(station.readings);
        station.maxTemperature = MaxMin.getMaxTemperature(station.readings);
        station.minWindSpeed = MaxMin.getMinWindSpeed(station.readings);
        station.maxWindSpeed = MaxMin.getMaxWindSpeed(station.readings);
        station.minPressure = MaxMin.getMinPressure(station.readings);
        station.maxPressure = MaxMin.getMaxPressure(station.readings);

        station.temperatureTrends = Trends.getTemperatureTrends(station.readings);
        station.windSpeedTrends = Trends.getWindSpeedTrends(station.readings);
        station.pressureTrends = Trends.getPressureTrends(station.readings);

        station.weatherCode = StationAnalytics.weatherCode(station.latestConditionCode);
        station.weatherIcon = StationAnalytics.weatherIcon(station.latestConditionCode);
        station.beaufort = StationAnalytics.getBeaufortScale(station.readings);
        station.compass = StationAnalytics.getCompassDirection(station.readings);
        station.windChill = StationAnalytics.getWindChill(station.readings);

        render("station.html", "latestconditions.html", station);
    }

    public static void addReading(Long id, int code, double temperature, double windSpeed, double pressure, double windDirection) {
        String date = new Date().toString();
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection, date);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();

        station.latestConditionTemperatureC = StationAnalytics.getlatestConditionTemperatureC(station.readings);
        station.latestConditionTemperatureF = StationAnalytics.getlatestConditionTemperatureF(station.readings);
        station.latestConditionCode = StationAnalytics.getlatestConditionCode(station.readings);
        station.latestConditionWindSpeed = StationAnalytics.getlatestConditionWindSpeed(station.readings);
        station.latestConditionPressure = StationAnalytics.getlatestConditionPressure(station.readings);
        station.latestConditionWindDirection = StationAnalytics.getlatestConditionWindDirection(station.readings);

        station.minTemperature = MaxMin.getMinTemperature(station.readings);
        station.maxTemperature = MaxMin.getMaxTemperature(station.readings);
        station.minWindSpeed = MaxMin.getMinWindSpeed(station.readings);
        station.maxWindSpeed = MaxMin.getMaxWindSpeed(station.readings);
        station.minPressure = MaxMin.getMinPressure(station.readings);
        station.maxPressure = MaxMin.getMaxPressure(station.readings);

        station.temperatureTrends = Trends.getTemperatureTrends(station.readings);
        station.windSpeedTrends = Trends.getWindSpeedTrends(station.readings);
        station.pressureTrends = Trends.getPressureTrends(station.readings);

        station.weatherCode = StationAnalytics.weatherCode(station.latestConditionCode);
        station.weatherIcon = StationAnalytics.weatherIcon(station.latestConditionCode);
        station.beaufort = StationAnalytics.getBeaufortScale(station.readings);
        station.compass = StationAnalytics.getCompassDirection(station.readings);
        station.windChill = StationAnalytics.getWindChill(station.readings);

        redirect("/stations/" + id);
        render("station.html", station);
    }


}