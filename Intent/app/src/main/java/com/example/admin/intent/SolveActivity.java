package com.example.admin.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SolveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent call = getIntent();
        Bundle bundle = call.getBundleExtra("Numbers");
        double a = bundle.getDouble("value_a");
        double b = bundle.getDouble("value_b");
        double c = bundle.getDouble("value_c");
        foo(a,b,c);
    }

    private void foo(double a, double b, double c){
        double delta, result1, result2;
        TextView result_1 = (TextView) findViewById(R.id.result_1);
        try {
            if (a == 0) {
                result_1.setText((c / b) + "");
            } else {
                delta = b * b - a * 4 * c;
                if (delta < 0) {
                    result_1.setText("Phuong trinh vo nghiem");
                }
                if (delta == 0) {
                    result1 = (-b + Math.sqrt(delta)) / (2 * a);
                    result_1.setText("Phuong trinh co nghiem kep:" + result1);
                }
                if (delta > 0) {
                    result1 = (-b + Math.sqrt(delta)) / (2 * a);
                    result2 = (-b - Math.sqrt(delta)) / (2 * a);
                    result_1.setText("Phuong trinh co 2 nghiem phan biet:\n" + "x1 = " + result1 + "\n" + "x2 = " + result2);
                }
            }
        } catch (NumberFormatException ex){
            ex.getStackTrace();
        }
    }

}
