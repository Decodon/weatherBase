package utils;

import models.Reading;

import java.util.List;

public class Trends {

    /* If there are more than 2 readings, the last 3 readings are used
    All 3 have to be going upwards or downwards to get the equivalent
    arrows. If one reading is up and next down, or vice versa, they get
    a straight line. Straight line also if less than 3 readings
     */
    public static String getTemperatureTrends(List<Reading> readings) {
        String temperatureTrends = null;
        if (readings.size() > 2) {
            if ((readings.get(readings.size() - 1).temperature > readings.get(readings.size() - 2).temperature) && (readings.get(readings.size() - 2).temperature > readings.get(readings.size() - 3).temperature)) {
                temperatureTrends = "arrow up icon";
            } else if ((readings.get(readings.size() - 1).temperature < readings.get(readings.size() - 2).temperature) && (readings.get(readings.size() - 2).temperature < readings.get(readings.size() - 3).temperature)) {
                temperatureTrends = "arrow down icon";
            } else {
                temperatureTrends = "calender minus icon";
            }
        } else {
            temperatureTrends = "calender minus icon";

        }
        return temperatureTrends;
    }

    public static String getWindSpeedTrends(List<Reading> readings) {
        String windSpeedTrends = null;
        if (readings.size() > 2) {
            if ((readings.get(readings.size() - 1).windSpeed> readings.get(readings.size() - 2).windSpeed) && (readings.get(readings.size() - 2).windSpeed > readings.get(readings.size() - 3).windSpeed)) {
                windSpeedTrends = "arrow up icon";
            } else if ((readings.get(readings.size() - 1).windSpeed < readings.get(readings.size() - 2).windSpeed) && (readings.get(readings.size() - 2).windSpeed < readings.get(readings.size() - 3).windSpeed)) {
                windSpeedTrends = "arrow down icon";
            } else {
                windSpeedTrends = "calender minus icon";
            }
        } else {
            windSpeedTrends = "calender minus icon";

        }
        return windSpeedTrends;
    }

    public static String getPressureTrends(List<Reading> readings) {
        String pressureTrends = null;
        if (readings.size() > 2) {
            if ((readings.get(readings.size() - 1).pressure > readings.get(readings.size() - 2).pressure) && (readings.get(readings.size() - 2).pressure > readings.get(readings.size() - 3).pressure)) {
                pressureTrends = "arrow up icon";
            } else if ((readings.get(readings.size() - 1).pressure < readings.get(readings.size() - 2).pressure) && (readings.get(readings.size() - 2).pressure < readings.get(readings.size() - 3).pressure)) {
                pressureTrends = "arrow down icon";
            } else {
                pressureTrends = "calender minus icon";
            }
        } else {
            pressureTrends = "calender minus icon";

        }
        return pressureTrends;
    }

}

