package com.cambrian.jav1001_midterm;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum to track the type of Metric. Contains all type conversion type metrics
 * @author: Aman Thakur
 */
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

    /**
     * Constructor initialise cases of enum
     * @params: toString - Name of Enum, value - Integer value of Enum, type: Type of Conversion
     * @return: Object of enum
     */
    private MetricType(String toString, int value, ConversionType type) {
        stringValue = toString;
        intValue = value;
        typeValue = type;
    }

    /**
     * Convert enum type to it's string value
     * @params: None
     * @return: String value of current enum
     */
    @Override
    public String toString() {
        return stringValue;
    }

    /**
     * Provides array of string value of enums based on it's conversion type
     * @params: type - Conversion type to segregate Metric enum cases
     * @return: String Array contains value of all string value of enums wrt to conversion type
     */
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

    /**
     * Provides array of enums based on it's conversion type
     * @params: conversionType - Conversion type to segregate Metric enum cases
     * @return: Metric Type Array contains value of all enums wrt to conversion type
     */
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
