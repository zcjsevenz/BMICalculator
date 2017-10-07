package com.example.zcjse.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {
    private TextView nBMI;
    private TextView nTextBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        // เข้าถึงอินเทนต์ที่ส่งมจากต้นทาง (MainActivity)
        Intent intent = getIntent();
        // อ่านค่าตัวเลข bmi จากอินเทนต์
        Double bmi = intent.getDoubleExtra("bmi_value", 0);
        // อ่านข้อความ (ที่บอกผอม, ปกติ, อ้วน) จากอินเทนต์
        String bmiText = intent.getStringExtra("bmi_text");
        String result = String.format("ค่า BMI คือ  %.1f",bmi);

        TextView nBMI = (TextView) findViewById(R.id.ShowBMI);
        TextView nTextBMI = (TextView)findViewById(R.id.ShowText);
        nBMI.setText(result);
        nTextBMI.setText("อยู่ในเกณฑ์ : "+bmiText);

        // นำค่า bmi, bmiText ไปใช้งานตามต้องการ




    }
}
