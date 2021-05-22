package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

import utils.StationAnalytics;

@Entity
public class Station extends Model {
    public String name;
    public double lat;
    public double lng;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public double latestConditionTemperatureC;
    public double latestConditionTemperatureF;
    public int latestConditionCode;
    public double latestConditionWindSpeed;
    public double latestConditionWindDirection;
    public double latestConditionPressure;
    public String weatherCode;
    public String beaufort;
    public String compass;
    public double windChill;
    public String weatherIcon;
    public double minTemperature;
    public double maxTemperature;
    public double minWindSpeed;
    public double maxWindSpeed;
    public double minPressure;
    public double maxPressure;
    public String temperatureTrends;
    public String windSpeedTrends;
    public String pressureTrends;

    public Station(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }
}
