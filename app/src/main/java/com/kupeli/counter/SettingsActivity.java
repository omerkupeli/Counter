package com.kupeli.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    Button upperPlus ,upperMinus ,lowerPlus ,lowerMinus;
    CheckBox upperVib , upperSound ,lowerVib ,lowerSound;
    TextView upperLimit,lowerLimit;

    SetClass setClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        upperPlus = (Button) findViewById(R.id.upperPlus);
        upperMinus = (Button) findViewById(R.id.buUpperMinus);
        lowerPlus = (Button) findViewById(R.id.lowerPlus);
        lowerMinus = (Button) findViewById(R.id.lowerMinus);
        upperVib = (CheckBox) findViewById(R.id.upperVib);
        upperSound = (CheckBox) findViewById(R.id.upperSound);
        lowerVib = (CheckBox) findViewById(R.id.lowerVib);
        lowerSound = (CheckBox) findViewById(R.id.lowerSound);
        upperLimit = (TextView) findViewById(R.id.upperLimit);
        lowerLimit = (TextView) findViewById(R.id.lowerLimit);

        setClass =SetClass.getSetClass(getApplicationContext());

        upperPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setClass.upperLimit++;
                upperLimit.setText(String.valueOf(setClass.upperLimit));
            }
        });

        upperMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setClass.upperLimit--;
                upperLimit.setText(String.valueOf(setClass.upperLimit));
            }
        });

        lowerPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setClass.lowerLimit++;
                lowerLimit.setText(String.valueOf(setClass.lowerLimit));
            }
        });

        lowerMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setClass.lowerLimit--;
                lowerLimit.setText(String.valueOf(setClass.lowerLimit));
            }
        });

        upperVib.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setClass.upperVib =b;
            }
        }));

        upperSound.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setClass.upperSound =b;
            }
        }));
        lowerVib.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setClass.lowerVib =b;
            }
        }));

        lowerSound.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setClass.lowerSound =b;
            }
        }));

        upperLimit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(upperLimit.getText().toString().length() !=0){
                    setClass.upperLimit=Integer.parseInt(upperLimit.getText().toString());
                }

            }
        });

        lowerLimit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(lowerLimit.getText().toString().length() !=0){
                    setClass.lowerLimit=Integer.parseInt(lowerLimit.getText().toString());
                }

            }
        });





    }
    @Override
    protected void onResume() {
        super.onResume();
        upperLimit.setText(String.valueOf(setClass.upperLimit));
        lowerLimit.setText(String.valueOf(setClass.lowerLimit));
        upperVib.setChecked(setClass.upperVib);
        upperSound.setChecked(setClass.upperSound);
        lowerVib.setChecked(setClass.lowerVib);
        lowerSound.setChecked(setClass.lowerSound);
    }

    @Override
    protected void onPause() {
        super.onPause();
        setClass.saveValues();
    }
}