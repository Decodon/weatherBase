package utils;

import models.Reading;

import java.util.HashMap;
import java.util.List;

public class StationAnalytics {

    public static Double getlatestConditionTemperatureC(List<Reading> readings) {
        Double latestConditionTemperatureC = null;
        if (readings.size() > 0) {
            latestConditionTemperatureC = readings.get(readings.size() - 1).temperature;
        } else {
            latestConditionTemperatureC = 0.00;
        }

        return latestConditionTemperatureC;
    }

    public static Double getlatestConditionTemperatureF(List<Reading> readings) {
        Double latestConditionTemperatureF = null;
        if (readings.size() > 0) {
            latestConditionTemperatureF = (((readings.get(readings.size() - 1).temperature) * (9) / 5) + 32);
        } else {
            latestConditionTemperatureF = 0.00;
        }

        return latestConditionTemperatureF;
    }

    public static Integer getlatestConditionCode(List<Reading> readings) {
        Integer latestConditionCode = null;
        if (readings.size() > 0) {
            latestConditionCode = readings.get(readings.size() - 1).code;
        } else {
            latestConditionCode = 0;
        }
        return latestConditionCode;
    }

    public static Double getlatestConditionWindSpeed(List<Reading> readings) {
        Double latestConditionWindSpeed = null;
        if (readings.size() > 0) {
            latestConditionWindSpeed = readings.get(readings.size() - 1).windSpeed;
        } else {
            latestConditionWindSpeed = 0.00;
        }
        return latestConditionWindSpeed;
    }


    public static Double getlatestConditionPressure(List<Reading> readings) {
        Double latestConditionPressure = null;
        if (readings.size() > 0) {
            latestConditionPressure = readings.get(readings.size() - 1).pressure;
        } else {
            latestConditionPressure = 0.00;
        }
        return latestConditionPressure;
    }

    public static Double getlatestConditionWindDirection(List<Reading> readings) {
        Double latestConditionWindDirection = null;
        if (readings.size() > 0) {
            latestConditionWindDirection = readings.get(readings.size() - 1).windDirection;
        } else {
            latestConditionWindDirection = 0.00;
        }
        return latestConditionWindDirection;
    }

    public static Double getWindChill(List<Reading> readings) {
        Double windChill = null;
        if (readings.size() > 0) {
            windChill = (13.12) + ((0.6212) * (readings.get(readings.size() - 1).temperature) - (11.37) * Math.pow((readings.get(readings.size() - 1).windSpeed), 0.16) + (0.3965) * (readings.get(readings.size() - 1).temperature) * (Math.pow((readings.get(readings.size() - 1).windSpeed), 0.16)));
        } else {
            windChill = 0.00;
        }
        return toTwoDecimalPlaces(windChill);
    }

    public static double toTwoDecimalPlaces(double num) {
        return (int) (num * 100) / 100.0;
    }
/*
    public static String weatherCode(int code) {
        switch (code) {
            case 100:
                return "Clear";
            case 200:
                return "Partial Clouds";
            case 300:
                return "Cloudy";
            case 400:
                return "Light Showers";
            case 500:
                return "Heavy Showers";
            case 600:
                return "Rain";
            case 700:
                return "Snow";
            case 800:
                return "Thunder";
            default:
                return "Please delete last reading and re-enter in terms of 100's (100-800)";
        }
    }
*/
    public static String weatherIcon(int code) {
        switch (code) {
            case 100:
                return "sun icon";
            case 200:
                return "cloud icon";
            case 300:
                return "cloud meatball icon";
            case 400:
                return "cloud sun rain icon";
            case 500:
                return "cloud showers heavy icon";
            case 600:
                return "cloud rain icon";
            case 700:
                return "snowflake icon";
            case 800:
                return "bolt icon";
            default:
                return "Please delete last reading and re-enter in terms of 100's (100-800)";
        }
    }

    public static String weatherCode(int code) {
        HashMap<Integer, String> weatherCodes = new HashMap<Integer, String>();
        weatherCodes.put(100, "Clear");
        weatherCodes.put(200, "Partial Clouds");
        weatherCodes.put(300, "Cloudy");
        weatherCodes.put(400, "Light Showers");
        weatherCodes.put(500, "Heavy Showers");
        weatherCodes.put(600, "Rain");
        weatherCodes.put(700, "Snow");
        weatherCodes.put(800, "Thunder");
        return weatherCodes.get(code);
    }


    public static String getBeaufortScale(List<Reading> readings) {
        if (readings.size() > 0) {
            String beaufortScale = null;
            if (readings.get(readings.size() - 1).windSpeed == 1) {
                beaufortScale = "0bft - Calm";
            } else if (readings.get(readings.size() - 1).windSpeed > 1 && readings.get(readings.size() - 1).windSpeed <= 5) {
                beaufortScale = "1bft - Light Air ";
            } else if (readings.get(readings.size() - 1).windSpeed > 5 && readings.get(readings.size() - 1).windSpeed <= 11) {
                beaufortScale = "2bft - Light Breeze";
            } else if (readings.get(readings.size() - 1).windSpeed > 12 && readings.get(readings.size() - 1).windSpeed <= 19) {
                beaufortScale = "3bft - Gentle Breeze";
            } else if (readings.get(readings.size() - 1).windSpeed > 19 && readings.get(readings.size() - 1).windSpeed <= 28) {
                beaufortScale = "4bft- Moderate Breeze";
            } else if (readings.get(readings.size() - 1).windSpeed > 28 && readings.get(readings.size() - 1).windSpeed <= 38) {
                beaufortScale = "5bft - Fresh Breeze";
            } else if (readings.get(readings.size() - 1).windSpeed > 38 && readings.get(readings.size() - 1).windSpeed <= 49) {
                beaufortScale = "6bft - Strong Breeze";
            } else if (readings.get(readings.size() - 1).windSpeed > 49 && readings.get(readings.size() - 1).windSpeed <= 61) {
                beaufortScale = "7bft - Near Gale";
            } else if (readings.get(readings.size() - 1).windSpeed > 61 && readings.get(readings.size() - 1).windSpeed <= 74) {
                beaufortScale = "8bft - Gale";
            } else if (readings.get(readings.size() - 1).windSpeed > 74 && readings.get(readings.size() - 1).windSpeed <= 88) {
                beaufortScale = "9bft - Severe Gale";
            } else if (readings.get(readings.size() - 1).windSpeed > 88 && readings.get(readings.size() - 1).windSpeed <= 102) {
                beaufortScale = "10bft - Strong Storm";
            } else if (readings.get(readings.size() - 1).windSpeed > 102 && readings.get(readings.size() - 1).windSpeed <= 117) {
                beaufortScale = "11bft - Violent Storm";
            } else if (readings.get(readings.size() - 1).windSpeed > 117) {
                beaufortScale = "Off the Charts";
            }
            return beaufortScale;
        }
        return null;
    }

    public static String getCompassDirection(List<Reading> readings) {
        if (readings.size() > 0) {
            String compassDirection = null;
            if (readings.get(readings.size() - 1).windDirection > 348.75 && readings.get(readings.size() - 1).windDirection <= 360) {
                compassDirection = "N";
            } else if (readings.get(readings.size() - 1).windDirection >= 0 && readings.get(readings.size() - 1).windDirection <= 11.25) {
                compassDirection = "N";
            } else if (readings.get(readings.size() - 1).windDirection > 11.25 && readings.get(readings.size() - 1).windDirection <= 33.75) {
                compassDirection = "NNE";
            } else if (readings.get(readings.size() - 1).windDirection > 33.75 && readings.get(readings.size() - 1).windDirection <= 56.25) {
                compassDirection = "NE";
            } else if (readings.get(readings.size() - 1).windDirection > 56.25 && readings.get(readings.size() - 1).windDirection <= 78.75) {
                compassDirection = "ENE";
            } else if (readings.get(readings.size() - 1).windDirection > 78.5 && readings.get(readings.size() - 1).windDirection <= 101.25) {
                compassDirection = "E";
            } else if (readings.get(readings.size() - 1).windDirection > 101.25 && readings.get(readings.size() - 1).windDirection <= 123.75) {
                compassDirection = "ESE";
            } else if (readings.get(readings.size() - 1).windDirection > 123.75 && readings.get(readings.size() - 1).windDirection <= 146.25) {
                compassDirection = "SE";
            } else if (readings.get(readings.size() - 1).windDirection > 146.25 && readings.get(readings.size() - 1).windDirection <= 168.75) {
                compassDirection = "SSE";
            } else if (readings.get(readings.size() - 1).windDirection > 168.75 && readings.get(readings.size() - 1).windDirection <= 191.25) {
                compassDirection = "S";
            } else if (readings.get(readings.size() - 1).windDirection > 191.25 && readings.get(readings.size() - 1).windDirection <= 213.75) {
                compassDirection = "SSW";
            } else if (readings.get(readings.size() - 1).windDirection > 213.75 && readings.get(readings.size() - 1).windDirection <= 236.25) {
                compassDirection = "SW";
            } else if (readings.get(readings.size() - 1).windDirection > 236.25 && readings.get(readings.size() - 1).windDirection <= 258.75) {
                compassDirection = "WSW";
            } else if (readings.get(readings.size() - 1).windDirection > 258.75 && readings.get(readings.size() - 1).windDirection <= 281.25) {
                compassDirection = "W";
            } else if (readings.get(readings.size() - 1).windDirection > 281.25 && readings.get(readings.size() - 1).windDirection <= 303.75) {
                compassDirection = "WNW";
            } else if (readings.get(readings.size() - 1).windDirection > 303.75 && readings.get(readings.size() - 1).windDirection <= 326.25) {
                compassDirection = "NW";
            } else if (readings.get(readings.size() - 1).windDirection > 326.25 && readings.get(readings.size() - 1).windDirection <= 348.75) {
                compassDirection = "NNW";
            } else if (readings.get(readings.size() - 1).windDirection > 360.0) {
                compassDirection = "Degrees 0-360 please";
            }
            return compassDirection;
        }
        return null;
    }
}






