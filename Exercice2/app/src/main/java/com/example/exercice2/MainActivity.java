package com.example.exercice2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Context context = this;
    RadioButton C , F;
    TextView resultat;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.temperature);
        button = findViewById(R.id.calculer);
        resultat = findViewById(R.id.resultat);
        C = findViewById(R.id.celsius);
        F = findViewById(R.id.fehrenheit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String T = text.getText().toString();
                if (T.length() == 0) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("Champ vide");
                    alert.setMessage("Veuillez saisir une valeur de temperature");
                    alert.setCancelable(false);
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = alert.create();
                    dialog.show();
                } else {
                    double convertTemp;
                    String finalTemp;
                    if (F.isChecked()) {
                        convertTemp = ((Double.parseDouble(T)) * 9 / 5) + 32;
                        finalTemp = String.valueOf(convertTemp);
                        resultat.setText(finalTemp + " Degré Fahrenheit");
                    } else if (C.isChecked()) {
                        convertTemp = ((Double.parseDouble(T)) - 32) * 5 / 9;
                        finalTemp = String.valueOf(convertTemp +" Degré Celsius");
                        resultat.setText(finalTemp);
                    }

                }
                ;

            }
        });

    }
    }

