package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller {
    public static void index() {
        Logger.info("Rendering Dashboard");
        List<Station> stations = Station.findAll();
        Collections.sort(stations, Comparator.comparing(Station::getName));
        render("dashboard.html", "/latestconditions.html" ,stations);
    }

    public static void deleteStation(Long id) {
        Station station = Station.findById(id);
        Logger.info("Removing" + station.name);
        station.delete();
        redirect("/dashboard");
    }



    public static void addStation(String name, double lat, double lng) {
        Station station = new Station(name, lat, lng);
        Logger.info("Adding a new station called " + name + lat + lng);
        station.save();
        redirect("/dashboard");
    }
}
