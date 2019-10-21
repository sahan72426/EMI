package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView loan, interest, no_of_month, result;
    private Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loan = findViewById(R.id.Loan);
        interest = findViewById(R.id.Interest);
        no_of_month = findViewById(R.id.months);
        result = findViewById(R.id.total);
        calculate = findViewById(R.id.Calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateEMI();
            }
        });
    }

    private void calculateEMI(){

        double loanamount = Double.parseDouble(loan.getText().toString());
        double rate = Double.parseDouble(interest.getText().toString());
        double month = Double.parseDouble(no_of_month.getText().toString());

        model emImodel = new model(loanamount,rate,month);

        double p = emImodel.getLoan();
        double r = emImodel.getInterest()/12/100;   //rate is calculated per month
        double n = emImodel.getNo_of_month();

        double resultemi = p*r*Math.pow(1+r,n)/(Math.pow(1+r,n)-1);
        String output = String.format("%.2f",resultemi);
        result.setText("RS: "+output);

    }
}
