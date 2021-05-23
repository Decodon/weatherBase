package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.MaxMin;
import utils.StationAnalytics;
import utils.Trends;

public class Dashboard extends Controller {
    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Station> stations = member.stations;
        Collections.sort(stations, Comparator.comparing(Station::getName, String.CASE_INSENSITIVE_ORDER));
        for (Station station: stations) {
            station.latestConditionTemperatureC= StationAnalytics.getlatestConditionTemperatureC(station.readings);
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
        }

        render("dashboard.html", member ,stations, "/tags/latestconditions.html");
    }

    public static void deleteStation(Long id) {
        Logger.info("Deleting a Station");
        Member member = Accounts.getLoggedInMember();
        Station station = Station.findById(id);
        member.stations.remove(station);
        member.save();
        Logger.info("Removing" + station.name);
        station.delete();
        redirect("/dashboard");
    }



    public static void addStation(String name, double lat, double lng) {
        Logger.info("Adding a Station");
        Member member = Accounts.getLoggedInMember();
        Station station = new Station(name, lat, lng);
        member.stations.add(station);
        Logger.info("Adding a new station called " + name + lat + lng);
        member.save();
        redirect("/dashboard");
    }
}
