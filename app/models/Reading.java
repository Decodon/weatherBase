package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public String weatherCode;
    public int code;
    public Double temperature;
    public Double windSpeed;
    public Double pressure;
    public Double windDirection;


    public Reading(int code, Double temperature, Double windSpeed, Double pressure, Double windDirection) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }

}
