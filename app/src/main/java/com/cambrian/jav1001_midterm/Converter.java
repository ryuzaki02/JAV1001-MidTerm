package com.cambrian.jav1001_midterm;

import android.util.Log;

import java.text.DecimalFormat;

public class Converter {
    public String getConvertedValue(ConversionType conversionType, MetricType fromType, MetricType toType, String value) {
        double dValue = Double.valueOf(value);
        return new DecimalFormat("0.########").format(getConvertedDistance(fromType, toType, dValue));
    }

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
        return 0.0;
    }
}
