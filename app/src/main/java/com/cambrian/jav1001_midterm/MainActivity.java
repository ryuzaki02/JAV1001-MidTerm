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
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ConversionType conversionType = ConversionType.Distance;
    private Converter converter = new Converter();
    private MetricType selectedFromType = MetricType.Meter;
    private MetricType selectedToType = MetricType.Meter;
    private String fromTextViewText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupSpinner();
        setupFromTextView();
    }

    // Setup Elements
    private void setupSpinner() {
        Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        fromSpinner.setOnItemSelectedListener(this);

        ArrayAdapter fromArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, MetricType.getAllValues(conversionType));
        fromArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(fromArrayAdapter);

        Spinner toSpinner = (Spinner) findViewById(R.id.toSpinner);
        toSpinner.setOnItemSelectedListener(this);

        ArrayAdapter toArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, MetricType.getAllValues(conversionType));
        toArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(toArrayAdapter);
    }

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

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        if (arg0.getId() == R.id.fromSpinner) {
            selectedFromType = MetricType.values()[position];
        } else if (arg0.getId() == R.id.toSpinner) {
            selectedToType = MetricType.values()[position];
        }
        if (selectedToType != null && selectedToType != null) {
            updateToTextView();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    private void updateToTextView() {
        if (!fromTextViewText.isEmpty()) {
            EditText toTextView = (EditText) findViewById(R.id.toEditTextView);
            toTextView.setText(converter.getConvertedValue(conversionType, selectedFromType, selectedToType, fromTextViewText));
        }
    }
}