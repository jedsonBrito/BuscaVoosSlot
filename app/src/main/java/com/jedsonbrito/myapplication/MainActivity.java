package com.jedsonbrito.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView txV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        txV = findViewById(R.id.textView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.forw18));
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {

                        if(line.length()>0) {
                            String begin = line.substring(0, 1);

                            if (begin.equals("U")) {
                                //Linha de Voo Cancelada
                            } else {
                                sb.append(line);
                            }
                        }

                    }
                    txV.setText(sb);
                }catch (FileNotFoundException e){
                    e.getMessage();
                }catch (IOException i) {
                    i.getMessage();
                }


            }
        });
    }
}
