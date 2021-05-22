package utils;

import models.Reading;

import java.util.List;

public class MaxMin {
    public static Double getMinTemperature(List<Reading> readings) {
        Double minTemperature = null;
        if (readings.size() > 0) {
            minTemperature = readings.get(0).temperature;
            for (Reading reading : readings) {
                if (reading.temperature < minTemperature) {
                    minTemperature = reading.temperature;
                }
            }
        } else {
            minTemperature = 0.00;
        }
        return minTemperature;
    }

    public static Double getMaxTemperature(List<Reading> readings) {
        Double maxTemperature = null;
        if (readings.size() > 0) {
            maxTemperature = readings.get(0).temperature;
            for (Reading reading : readings) {
                if (reading.temperature > maxTemperature) {
                    maxTemperature = reading.temperature;
                }
            }
        } else {
            maxTemperature = 0.00;
        }
        return maxTemperature;
    }

    public static Double getMinWindSpeed(List<Reading> readings) {
        Double minWindSpeed = null;
        if (readings.size() > 0) {
            minWindSpeed = readings.get(0).windSpeed;
            for (Reading reading : readings) {
                if (reading.windSpeed < minWindSpeed) {
                    minWindSpeed = reading.windSpeed;
                }
            }
        } else {
            minWindSpeed = 0.00;
        }
        return minWindSpeed;
    }

    public static Double getMaxWindSpeed(List<Reading> readings) {
        Double maxWindSpeed = null;
        if (readings.size() > 0) {
            maxWindSpeed = readings.get(0).windSpeed;
            for (Reading reading : readings) {
                if (reading.windSpeed > maxWindSpeed) {
                    maxWindSpeed = reading.windSpeed;
                }
            }
        } else {
            maxWindSpeed = 0.00;
        }
        return maxWindSpeed;
    }

    public static Double getMinPressure(List<Reading> readings) {
        Double minPressure = null;
        if (readings.size() > 0) {
            minPressure = readings.get(0).pressure;
            for (Reading reading : readings) {
                if (reading.pressure < minPressure) {
                    minPressure = reading.pressure;
                }
            }
        } else {
            minPressure = 0.00;
        }
        return minPressure;
    }

    public static Double getMaxPressure(List<Reading> readings) {
        Double maxPressure = null;
        if (readings.size() > 0) {
            maxPressure = readings.get(0).pressure;
            for (Reading reading : readings) {
                if (reading.pressure > maxPressure) {
                    maxPressure = reading.pressure;
                }
            }
        } else {
            maxPressure = 0.00;
        }
        return maxPressure;
    }
}
