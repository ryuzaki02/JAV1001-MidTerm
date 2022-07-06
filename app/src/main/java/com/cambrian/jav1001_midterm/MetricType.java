package com.cambrian.jav1001_midterm;

import java.util.ArrayList;
import java.util.List;

public enum MetricType {
    Meter("Meter", 0, ConversionType.Length),
    Centimeter("Centimeter", 1, ConversionType.Length),
    Millimeter("Millimeter", 2, ConversionType.Length),
    Mile("Mile", 3, ConversionType.Length),
    Foot("Foot", 4, ConversionType.Length),
    Inch("Inch", 5, ConversionType.Length),
    Kilometer("Kilometer", 6, ConversionType.Length),

    Celsius("Celsius", 7, ConversionType.Temperature),
    Fahrenheit("Fahrenheit", 8, ConversionType.Temperature),
    Kelvin("Kelvin", 9, ConversionType.Temperature),

    Kilogram("Kilogram", 10, ConversionType.Weight),
    Gram("Gram", 11, ConversionType.Weight),
    Ounce("Ounce", 12, ConversionType.Weight),
    Pound("Pound", 13, ConversionType.Weight),
    Milligram("Milligram", 14, ConversionType.Weight),

    Liter("Liter", 15, ConversionType.Volume),
    Milliliter("Milliliter", 16, ConversionType.Volume);

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

    public static MetricType[] getMetricValuesFor(ConversionType conversionType) {
        List<MetricType> listValues = new ArrayList<MetricType>();
        for (MetricType type:
             MetricType.values()) {
            if (type.typeValue == conversionType) {
                listValues.add(type);
            }
        }
        MetricType[] items = new MetricType[ listValues.size() ];
        listValues.toArray( items );
        return items;
    }
}
