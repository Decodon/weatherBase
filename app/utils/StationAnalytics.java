package utils;

import models.Reading;

import java.util.List;

public class StationAnalytics {


    private String weatherT;


    public static Reading getMaxTemperature(List<Reading> readings) {
        Reading maxTemperature = null;
        if (readings.size() > 0) {
            maxTemperature = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature > maxTemperature.temperature) {
                    maxTemperature = reading;
                }
            }
        }
        return maxTemperature;
    }

    public static Reading getMinTemperature(List<Reading> readings) {
        Reading minTemperature = null;
        if (readings.size() > 0) {
            minTemperature = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature < minTemperature.temperature) {
                    minTemperature = reading;
                }
            }
        }
        return minTemperature;
    }





    public static Double getlatestConditionTemperatureC(List<Reading> readings) {
        Double latestConditionTemperatureC = null;
        if (readings.size() > 0) {
            latestConditionTemperatureC = readings.get(readings.size() - 1).temperature;
        }
        return latestConditionTemperatureC;
    }

    public static Double getlatestConditionTemperatureF(List<Reading> readings) {
        Double latestConditionTemperatureF = null;
        if (readings.size() > 0) {
            latestConditionTemperatureF = (((readings.get(readings.size() - 1).temperature) * (9) / 5) + 32);
        }
        return latestConditionTemperatureF;
    }

    public static Integer getlatestConditionCode(List<Reading> readings) {
        Integer latestConditionCode = null;
        if (readings.size() > 0) {
            latestConditionCode = readings.get(readings.size() - 1).code;
        }
        return latestConditionCode;
    }

    public static Double getlatestConditionWindSpeed(List<Reading> readings) {
        Double latestConditionWindSpeed = null;
        if (readings.size() > 0) {
            latestConditionWindSpeed = readings.get(readings.size() - 1).windSpeed;
        }
        return latestConditionWindSpeed;
    }


    public static Double getlatestConditionPressure(List<Reading> readings) {
        Double latestConditionPressure = null;
        if (readings.size() > 0) {
            latestConditionPressure = readings.get(readings.size() - 1).pressure;
        }
        return latestConditionPressure;
    }

    public static Double getlatestConditionWindDirection(List<Reading> readings) {
        Double latestConditionWindDirection = null;
        if (readings.size() > 0) {
            latestConditionWindDirection = readings.get(readings.size() - 1).windDirection;
        }
        return latestConditionWindDirection;
    }

    public static Double getWindChill(List<Reading> readings) {
        Double windChill = null;
        if (readings.size() > 0) {
            windChill = (13.12)+((0.6212)*(readings.get(readings.size() - 1).temperature) - ((11.37)*Math.pow((readings.get(readings.size() - 1).windSpeed),.016) + (0.3969)*(readings.get(readings.size() - 1).temperature)*(Math.pow((readings.get(readings.size() - 1).windSpeed),.016))));
        }
        return toTwoDecimalPlaces(windChill);
    }

    private static double toTwoDecimalPlaces(double num){
        return (int) (num *100 ) /100.0;
    }

    /*
    public static String getWeatherT(int getlatestConditionCode){
        String weatherT = null;
        if (StationAnalytics.getlatestConditionCode(station.readings) == 100) {
            weatherT =  "Clear";
            return weatherT;
        } else if (station.latestConditionCode == 200) {
            weatherT = "Partial Clouds";
        } else if (station.latestConditionCode == 300) {
            weatherT = "Cloudy";
        } else if (station.latestConditionCode == 400) {
            weatherT = "Light Showers";
        } else if (station.latestConditionCode == 500) {
            weatherT = "Heavy Showers";
        } else if (station.latestConditionCode == 600) {
            weatherT = "Rain";
        } else if (station.latestConditionCode == 700) {
            weatherT = "Snow";
        } else if (station.latestConditionCode == 800) {
            weatherT = "Thunder";
        } else weatherT = "Please enter in terms of hundreds";

        return weatherT;
    }
*/

}
/*
    HashMap<Integer,String> weatherCodes = new HashMap<Integer, String>();

    private void fillWeatherCodes(){
        this.weatherCodes.put(100, "Clear");
        this.weatherCodes.put(200, "Partial Clouds");
        this.weatherCodes.put(300, "Cloudy");
        this.weatherCodes.put(400, "Light Showers");
        this.weatherCodes.put(500, "Heavy Showers");
        this.weatherCodes.put(600, "Rain");
        this.weatherCodes.put(700, "Snow");
        this.weatherCodes.put(800, "Thunder");
    }
*/




