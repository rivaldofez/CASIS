package com.example.casis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button valid, check;
    ToggleButton swicth;
    TextView status;
    EditText number_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valid = (Button) findViewById(R.id.validbtn);
        check = (Button) findViewById(R.id.checkbtn);
        swicth = (ToggleButton) findViewById(R.id.switchAlarm);
        status = (TextView) findViewById(R.id.status);
        number_view = (EditText) findViewById(R.id.number);

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swicth.isChecked()){

                }else{
                    Integer sum=0;
                    String number = number_view.getText().toString();

                    if(number.length()==10){
                        for(int i=1 ; i<=10;i++){
                            sum = sum + (Character.getNumericValue(number.charAt(i-1))*i);
                        }
                        if(sum%11==0){
                            status.setText("Valid karena "+sum.toString()+" mod 11 == 0");
                        }else{
                            status.setText("Tidak Valid karena "+sum.toString()+" mod 11 == "+sum%11);
                        }
                    }else if(number.length()==13){
                        for(int i=1 ; i<=13;i++){
                           if(i%2==1){
                               sum = sum + (Character.getNumericValue(number.charAt(i-1))*1);
                           }else{
                               sum = sum + (Character.getNumericValue(number.charAt(i-1))*3);
                           }
                        }
                        if(sum%10==0){
                            status.setText("Valid karena "+sum.toString()+" mod 10 == 0");
                        }else{
                            status.setText("Tidak Valid karena "+sum.toString()+" mod 10 == "+sum%10);
                        }
                    }else{
                        status.setText("Terjadi Kesalahan, silahkan cek kembali number");
                    }
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swicth.isChecked()){
                    Integer sum=0;
                    Integer indeks=1;
                    String number = number_view.getText().toString();

                        for(int i=number.length()-2 ; i>=0 ;i--){
                            sum = sum + (Character.getNumericValue(number.charAt(i))*indeks);
                            indeks++;
                        }
                        status.setText("Check digit adalah "+sum%10 +" CAS = "+number);

                }else{
                    Integer sum=0;
                    String number = number_view.getText().toString();

                    if(number.length()==9){
                        for(int i=1 ; i<=9;i++){
                            sum = sum + (Character.getNumericValue(number.charAt(i-1))*i);
                        }
                        status.setText("Check digit adalah "+sum%11 +" ISBN = "+number+sum%11);
                    }else if(number.length()==12){
                        for(int i=1 ; i<=12;i++) {
                            if (i % 2 == 1) {
                                sum = sum + (Character.getNumericValue(number.charAt(i - 1)) * 1);
                            } else {
                                sum = sum + (Character.getNumericValue(number.charAt(i - 1)) * 3);
                            }
                        }
                        status.setText("Check digit adalah "+(sum%10)+" ISBN = "+number+(10-(sum%10)));
                    }else{
                        status.setText("Terjadi Kesalahan, silahkan cek kembali number");
                    }
                }
            }
        });
    }
}
