package com.cambrian.jav1001_midterm;

import java.util.ArrayList;
import java.util.List;

public enum MetricType {
    Meter("Meter", 0, ConversionType.Distance),
    Centimeter("Centimeter", 1, ConversionType.Distance),
    Millimeter("Millimeter", 2, ConversionType.Distance),
    Mile("Mile", 3, ConversionType.Distance),
    Foot("Foot", 4, ConversionType.Distance),
    Inch("Inch", 5, ConversionType.Distance),
    Kilometer("Kilometer", 6, ConversionType.Distance),

    Celsius("Celsius", 7, ConversionType.Temperature),
    Fahrenheit("Fahrenheit", 8, ConversionType.Temperature),
    Kelvin("Kelvin", 9, ConversionType.Temperature);

    private String stringValue;
    private int intValue;
    private ConversionType typeValue;

    private MetricType(String toString, int value, ConversionType type) {
        stringValue = toString;
        intValue = value;
        typeValue = type;
    }

    @Override
    public String toString() {
        return stringValue;
    }

    public static String[] getAllValues(ConversionType type) {
        List<String> itemList = new ArrayList<String>();
        for (MetricType item:
             MetricType.values()) {
            if(item.typeValue == type) {
                itemList.add(item.toString());
            }
        }
        String[] items = new String[ itemList.size() ];
        itemList.toArray( items );
        return items;
    }

    public static MetricType getTypeFromString(String value) {
        switch (value) {
            case "Meter":
                return MetricType.Meter;
            case "Centimeter":
                return MetricType.Centimeter;
            default:
                return MetricType.Millimeter;
        }
    }
}
