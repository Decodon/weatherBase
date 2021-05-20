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

public class Dashboard extends Controller {
    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Station> stations = member.stations;
        //List<Station> stations = Station.findAll();
        Collections.sort(stations, Comparator.comparing(Station::getName, String.CASE_INSENSITIVE_ORDER));
        render("dashboard.html", "/latestconditions.html" ,stations);
    }

    public static void deleteStation(Long id) {
        Logger.info("Deleting a Playlist");
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
