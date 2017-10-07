package com.example.zcjse.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nHeightEditText;
    private EditText nWeightEditText;
    private Button nCalculateButton;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        nWeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        nCalculateButton = (Button) findViewById(R.id.calculate_button);

        nCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height = Double.valueOf(nHeightEditText.getText().toString());
                Double weight = Double.valueOf(nWeightEditText.getText().toString());

                Double bmi = weight / ((height / 100) * (height / 100));
                String bmiText = getBmiText(bmi);

                String result = String.format("ค่า BMI ที่ได้คือ %.1f\n\nอยู่ในเกณฑ์ : %s", bmi, bmiText);

/*
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nHeightEditText.setText("");
                        nWeightEditText.setText("");
                        nHeightEditText.requestFocus();
                        //finish();//ปิด activity ในปัจจุบัน
                    }
                });
*/

                // สร้างอินเทนต์ โดยระบุคอนเท็กซ์ และแอคทิวิตีที่ต้องการรัน
                Intent intent = new Intent(MainActivity.this, BmiResultActivity.class);
                // ใส่ค่าตัวเลข bmi ลงในอินเทนต์
                intent.putExtra("bmi_value", bmi);
                // ใส่ข้อความ (ที่บอกผอม, ปกติ, อ้วน) ลงในอินเทนต์
                intent.putExtra("bmi_text", bmiText);
                // ยิงอินเทนต์ออกไปให้ Android จัดการ (รันแอคทิวิตีใหม่)
                startActivity(intent);

            }

        });

    }

    private String getBmiText(Double bmi) {
        /*
        bmi < 18.5 : mass min than normal
18.5 <= bmi < 25 : normal
25 <= bmi < 30 : mass more than normal
bmi >= 30 : mass more than normal alot (fat)
         */
        String bmiText = "";
        if (bmi < 18.5) {
            bmiText = "นํ้าหนักน้อยกว่าปกติ";
        } else if (bmi < 25) {
            bmiText = "นํ้าหนักปกติ";
        } else if (bmi < 30) {
            bmiText = "นํ้าหนักมากกว่าปกติ (ท้วม)";
        } else {
            bmiText = "นํ้าหนักมากกว่าปกติมาก (อ้วน)";
        }
        return bmiText;
    }

}
