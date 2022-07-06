package com.cambrian.jav1001_midterm;

import android.util.Log;

import java.text.DecimalFormat;

/**
 * Converter Class holds all the business logic of actual conversion
 * @author: Aman Thakur
 */
public class Converter {

    /**
     * Provides actual converted value to show to the user with help of conversion type and switch cases
     * @params: conversionType - Conversion type to segregate Metric enum cases, fromType - Selected 'From' enum value from spinner, toType - Selected 'To' enum value from other spinner, value - Actual value user has entered in 'From Edit Text View'
     * @return: String value of converted input
     */
    public String getConvertedValue(ConversionType conversionType, MetricType fromType, MetricType toType, String value) {
        double dValue = Double.valueOf(value);
        double convertedValue;
        switch (conversionType) {
            case Length:
                convertedValue = getConvertedDistance(fromType, toType, dValue);
                break;
            case Volume:
                convertedValue = getConvertedVolume(fromType, toType, dValue);
                break;
            case Weight:
                convertedValue = getConvertedWeight(fromType, toType, dValue);
                break;
            case Temperature:
                convertedValue = getConvertedTemperature(fromType, toType, dValue);
                break;
            default:
                convertedValue = 0;
                break;
        }
        return new DecimalFormat("0.########").format(convertedValue);
    }

    /**
     * Provides converted value for only distance type conversion
     * @params: fromType - Selected 'From' enum value from spinner, toType - Selected 'To' enum value from other spinner, value - Actual value user has entered in 'From Edit Text View'
     * @return: Double value of converted input
     */
    private double getConvertedDistance(MetricType fromType, MetricType toType, double value) {
        if (fromType == MetricType.Meter && toType == MetricType.Meter) {
            return value;
        } else if (fromType == MetricType.Meter && toType == MetricType.Centimeter) {
            return value * 100;
        } else if (fromType == MetricType.Meter && toType == MetricType.Millimeter) {
            return value * 1000;
        } else if (fromType == MetricType.Meter && toType == MetricType.Mile) {
            return value * 0.00062;
        } else if (fromType == MetricType.Meter && toType == MetricType.Foot) {
            return value * 3.28;
        } else if (fromType == MetricType.Meter && toType == MetricType.Inch) {
            return value * 39.37;
        } else if (fromType == MetricType.Meter && toType == MetricType.Kilometer) {
            return value * 0.001;
        } else if (fromType == MetricType.Centimeter && toType == MetricType.Centimeter) {
            return value;
        } else if (fromType == MetricType.Centimeter && toType == MetricType.Meter) {
            return value * 0.01;
        } else if (fromType == MetricType.Centimeter && toType == MetricType.Millimeter) {
            return value * 10;
        } else if (fromType == MetricType.Centimeter && toType == MetricType.Mile) {
            return value * 0.0000062;
        } else if (fromType == MetricType.Centimeter && toType == MetricType.Foot) {
            return value * 0.0328;
        } else if (fromType == MetricType.Centimeter && toType == MetricType.Inch) {
            return value * 0.3937;
        } else if (fromType == MetricType.Centimeter && toType == MetricType.Kilometer) {
            return value * 0.00001;
        } else if (fromType == MetricType.Kilometer && toType == MetricType.Kilometer) {
            return value;
        } else if (fromType == MetricType.Kilometer && toType == MetricType.Meter) {
            return value * 1000;
        } else if (fromType == MetricType.Kilometer && toType == MetricType.Millimeter) {
            return value * 1000000;
        } else if (fromType == MetricType.Kilometer && toType == MetricType.Mile) {
            return value * 0.62;
        } else if (fromType == MetricType.Kilometer && toType == MetricType.Foot) {
            return value * 3280.839;
        } else if (fromType == MetricType.Kilometer && toType == MetricType.Inch) {
            return value * 39370.08;
        } else if (fromType == MetricType.Kilometer && toType == MetricType.Centimeter) {
            return value * 100000;
        } else if (fromType == MetricType.Millimeter && toType == MetricType.Millimeter) {
            return value;
        } else if (fromType == MetricType.Millimeter && toType == MetricType.Meter) {
            return value * 0.001;
        } else if (fromType == MetricType.Millimeter && toType == MetricType.Kilometer) {
            return value * 0.000001;
        } else if (fromType == MetricType.Millimeter && toType == MetricType.Mile) {
            return value * 6.213688756E-7;
        } else if (fromType == MetricType.Millimeter && toType == MetricType.Foot) {
            return value * 0.00328;
        } else if (fromType == MetricType.Millimeter && toType == MetricType.Inch) {
            return value * 0.0394;
        } else if (fromType == MetricType.Millimeter && toType == MetricType.Centimeter) {
            return value * 0.1;
        } else if (fromType == MetricType.Mile && toType == MetricType.Mile) {
            return value;
        } else if (fromType == MetricType.Mile && toType == MetricType.Meter) {
            return value * 1609.35;
        } else if (fromType == MetricType.Mile && toType == MetricType.Kilometer) {
            return value * 1.60935;
        } else if (fromType == MetricType.Mile && toType == MetricType.Millimeter) {
            return value * 1609350;
        } else if (fromType == MetricType.Mile && toType == MetricType.Foot) {
            return value * 5280.02;
        } else if (fromType == MetricType.Mile && toType == MetricType.Inch) {
            return value * 63360.24;
        } else if (fromType == MetricType.Mile && toType == MetricType.Centimeter) {
            return value * 160935;
        } else if (fromType == MetricType.Foot && toType == MetricType.Foot) {
            return value;
        } else if (fromType == MetricType.Foot && toType == MetricType.Meter) {
            return value * 0.3048;
        } else if (fromType == MetricType.Foot && toType == MetricType.Kilometer) {
            return value * 0.0003048;
        } else if (fromType == MetricType.Foot && toType == MetricType.Millimeter) {
            return value * 304.8;
        } else if (fromType == MetricType.Foot && toType == MetricType.Mile) {
            return value * 0.000189;
        } else if (fromType == MetricType.Foot && toType == MetricType.Inch) {
            return value * 12;
        } else if (fromType == MetricType.Foot && toType == MetricType.Centimeter) {
            return value * 30.48;
        } else if (fromType == MetricType.Inch && toType == MetricType.Inch) {
            return value;
        } else if (fromType == MetricType.Inch && toType == MetricType.Meter) {
            return value * 0.0254;
        } else if (fromType == MetricType.Inch && toType == MetricType.Kilometer) {
            return value * 0.0000254;
        } else if (fromType == MetricType.Inch && toType == MetricType.Millimeter) {
            return value * 25.4;
        } else if (fromType == MetricType.Inch && toType == MetricType.Mile) {
            return value * 0.0000157828;
        } else if (fromType == MetricType.Inch && toType == MetricType.Foot) {
            return value * 0.083;
        } else if (fromType == MetricType.Inch && toType == MetricType.Centimeter) {
            return value * 2.54;
        }
        return 0;
    }

    /**
     * Provides converted value for only Temperature type conversion
     * @params: fromType - Selected 'From' enum value from spinner, toType - Selected 'To' enum value from other spinner, value - Actual value user has entered in 'From Edit Text View'
     * @return: Double value of converted input
     */
    private double getConvertedTemperature(MetricType fromType, MetricType toType, double value) {
        if (fromType == MetricType.Celsius && toType == MetricType.Celsius) {
            return value;
        } else if (fromType == MetricType.Celsius && toType == MetricType.Kelvin) {
            return value + 273.15;
        } else if (fromType == MetricType.Celsius && toType == MetricType.Fahrenheit) {
            return (value * 9/5) + 32;
        } else if (fromType == MetricType.Fahrenheit && toType == MetricType.Fahrenheit) {
            return value;
        } else if (fromType == MetricType.Fahrenheit && toType == MetricType.Kelvin) {
            return ((value - 32) * 5/9) + 273.15;
        } else if (fromType == MetricType.Fahrenheit && toType == MetricType.Celsius) {
            return ((value - 32) * 5/9);
        } else if (fromType == MetricType.Kelvin && toType == MetricType.Kelvin) {
            return value;
        } else if (fromType == MetricType.Kelvin && toType == MetricType.Fahrenheit) {
            return ((value - 273.15) * 9/5) + 32;
        } else if (fromType == MetricType.Kelvin && toType == MetricType.Celsius) {
            return value - 273.15;
        }
        return 0;
    }

    /**
     * Provides converted value for only Volume type conversion
     * @params: fromType - Selected 'From' enum value from spinner, toType - Selected 'To' enum value from other spinner, value - Actual value user has entered in 'From Edit Text View'
     * @return: Double value of converted input
     */
    private double getConvertedVolume(MetricType fromType, MetricType toType, double value) {
        if (fromType == MetricType.Liter && toType == MetricType.Liter) {
            return value;
        } else if (fromType == MetricType.Liter && toType == MetricType.Milliliter) {
            return value * 1000;
        } else if (fromType == MetricType.Milliliter && toType == MetricType.Milliliter) {
            return value;
        } else if (fromType == MetricType.Milliliter && toType == MetricType.Liter) {
            return value * 0.001;
        }
        return 0;
    }

    /**
     * Provides converted value for only Weight type conversion
     * @params: fromType - Selected 'From' enum value from spinner, toType - Selected 'To' enum value from other spinner, value - Actual value user has entered in 'From Edit Text View'
     * @return: Double value of converted input
     */
    private double getConvertedWeight(MetricType fromType, MetricType toType, double value) {
        if (fromType == MetricType.Kilogram && toType == MetricType.Kilogram) {
            return value;
        } else if (fromType == MetricType.Kilogram && toType == MetricType.Gram) {
            return value * 1000;
        } else if (fromType == MetricType.Kilogram && toType == MetricType.Milligram) {
            return value * 1000000;
        } else if (fromType == MetricType.Kilogram && toType == MetricType.Ounce) {
            return value * 35.27;
        } else if (fromType == MetricType.Kilogram && toType == MetricType.Pound) {
            return value * 2.205;
        } else if (fromType == MetricType.Gram && toType == MetricType.Gram) {
            return value;
        } else if (fromType == MetricType.Gram && toType == MetricType.Kilogram) {
            return value * 0.001;
        } else if (fromType == MetricType.Gram && toType == MetricType.Milligram) {
            return value * 1000;
        } else if (fromType == MetricType.Gram && toType == MetricType.Ounce) {
            return value * 0.0353;
        } else if (fromType == MetricType.Gram && toType == MetricType.Pound) {
            return value * 0.0022;
        } else if (fromType == MetricType.Milligram && toType == MetricType.Milligram) {
            return value;
        } else if (fromType == MetricType.Milligram && toType == MetricType.Kilogram) {
            return value * 0.000001;
        } else if (fromType == MetricType.Milligram && toType == MetricType.Gram) {
            return value * 0.001;
        } else if (fromType == MetricType.Milligram && toType == MetricType.Ounce) {
            return value * 0.0000353;
        } else if (fromType == MetricType.Milligram && toType == MetricType.Pound) {
            return value * 0.00000220;
        } else if (fromType == MetricType.Ounce && toType == MetricType.Ounce) {
            return value;
        } else if (fromType == MetricType.Ounce && toType == MetricType.Kilogram) {
            return value * 0.0283;
        } else if (fromType == MetricType.Ounce && toType == MetricType.Gram) {
            return value * 28.35;
        } else if (fromType == MetricType.Ounce && toType == MetricType.Milligram) {
            return value * 28349.5;
        } else if (fromType == MetricType.Ounce && toType == MetricType.Pound) {
            return value * 0.0625;
        } else if (fromType == MetricType.Pound && toType == MetricType.Pound) {
            return value;
        } else if (fromType == MetricType.Pound && toType == MetricType.Kilogram) {
            return value * 0.453;
        } else if (fromType == MetricType.Pound && toType == MetricType.Gram) {
            return value * 453.592;
        } else if (fromType == MetricType.Pound && toType == MetricType.Milligram) {
            return value * 453592;
        } else if (fromType == MetricType.Pound && toType == MetricType.Ounce) {
            return value * 16;
        }
        return 0;
    }
}
