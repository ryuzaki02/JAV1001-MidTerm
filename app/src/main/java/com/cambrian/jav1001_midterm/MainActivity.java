package com.cambrian.jav1001_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ConversionType conversionType = ConversionType.Length;
    private Converter converter = new Converter();
    private MetricType selectedFromType;
    private MetricType selectedToType;
    private String fromTextViewText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupSpinner();
        setupFromTextView();
        setupRadioGroup();
    }

    /**
     * Setup Spinner for both 'From' type and 'To' Type
     * @return: nothing
     */
    private void setupSpinner() {
        Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        fromSpinner.setOnItemSelectedListener(this);

        Spinner toSpinner = (Spinner) findViewById(R.id.toSpinner);
        toSpinner.setOnItemSelectedListener(this);

        updateSpinner(fromSpinner, toSpinner);
    }

    /**
     * Updates spinner data based on Radio Button selection and changes the data
     * @params: fromSpinner - Updates data to 'from' spinner, toSpinner - Updates data to 'to' spinner
     * @return: nothing
     */
    private void updateSpinner(Spinner fromSpinner, Spinner toSpinner) {
        ArrayAdapter fromArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, MetricType.getAllValues(conversionType));
        fromArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(fromArrayAdapter);


        ArrayAdapter toArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, MetricType.getAllValues(conversionType));
        toArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(toArrayAdapter);
    }

    /**
     * Setup 'From' text view to track user inputs with listeners
     * @params: nothing
     * @return: nothing
     */
    private void setupFromTextView() {
        EditText fromTextView = (EditText) findViewById(R.id.fromEditTextView);
        fromTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                fromTextViewText = editable.toString();
                updateToTextView();
            }
        });
    }

    /**
     * Sets Radio Group to track user changes with help of listeners. Also updates both spinner data accordingly.
     * @params: nothing
     * @return: nothing
     */
    private void setupRadioGroup() {
        RadioGroup group = (RadioGroup) findViewById(R.id.conversionTypeGroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.lengthRadioButton:
                        selectedFromType = MetricType.Meter;
                        selectedToType = MetricType.Meter;
                        conversionType = ConversionType.Length;
                        break;
                    case R.id.volumeRadioButton:
                        selectedFromType = MetricType.Liter;
                        selectedToType = MetricType.Liter;
                        conversionType = ConversionType.Volume;
                        break;
                    case R.id.tempRadioButton:
                        selectedFromType = MetricType.Celsius;
                        selectedToType = MetricType.Celsius;
                        conversionType = ConversionType.Temperature;
                        break;
                    case R.id.weightRadioButton:
                        selectedFromType = MetricType.Kilogram;
                        selectedToType = MetricType.Kilogram;
                        conversionType = ConversionType.Weight;
                        break;
                }
                updateSpinner(findViewById(R.id.fromSpinner), findViewById(R.id.toSpinner));
                resetTextView();
            }
        });
    }

    /**
     * Resets both text views that is to say 'from' and 'to' as soon as user changes radio button
     * @params: nothing
     * @return: nothing
     */
    private void resetTextView() {
        EditText fromTextView = (EditText) findViewById(R.id.fromEditTextView);
        EditText toTextView = (EditText) findViewById(R.id.toEditTextView);
        fromTextView.setText("");
        toTextView.setText("");
    }

    /**
     * Updates 'from' and 'to' type of spinners and calculates value for 'to' text field accordingly
     * @params: arg0 - Type of view, position - user selection position inside spinner
     * @return: nothing
     */
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        if (arg0.getId() == R.id.fromSpinner) {
            selectedFromType = MetricType.getMetricValuesFor(conversionType)[position];
        } else if (arg0.getId() == R.id.toSpinner) {
            selectedToType = MetricType.getMetricValuesFor(conversionType)[position];
        }
        if (selectedToType != null && selectedToType != null) {
            updateToTextView();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    /**
     * Updates 'to' text view after spinner and radio button selection and outputs final result
     * @params: nothing
     * @return: nothing
     */
    private void updateToTextView() {
        EditText toTextView = (EditText) findViewById(R.id.toEditTextView);
        if (!fromTextViewText.isEmpty()) {
            toTextView.setText(converter.getConvertedValue(conversionType, selectedFromType, selectedToType, fromTextViewText));
        } else {
            toTextView.setText("");
        }
    }
}