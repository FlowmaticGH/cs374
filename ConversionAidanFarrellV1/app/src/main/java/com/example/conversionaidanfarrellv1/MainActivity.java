package com.example.conversionaidanfarrellv1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    private EditText milesInput;
    private TextView mResult;
    private NumberFormat formatter = new DecimalFormat("#0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        milesInput = findViewById(R.id.mileBox);
        mResult = findViewById(R.id.Result);

    }

    public void Conversion(View view) {
        boolean onlyDigits = true;

        String sMiles = milesInput.getText().toString();
        for(int i = 0; i < sMiles.length(); i++){
            if(!Character.isDigit(sMiles.charAt(i))){
                onlyDigits = false;
            }
        }
        if(onlyDigits && sMiles!=null){
            double dMiles = Double.parseDouble(sMiles);
            double dKilometers = dMiles*1.609;
            String complete = formatter.format(dMiles) + " miles = " + formatter.format(dKilometers) + "km";
            mResult.setText(complete);
        }
        else{
            String isFalse = "You can only enter numbers into the text box.\nTry again";
            mResult.setText(isFalse);
        }

    }
}