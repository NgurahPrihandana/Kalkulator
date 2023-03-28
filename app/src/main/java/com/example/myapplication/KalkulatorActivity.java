package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KalkulatorActivity extends AppCompatActivity {
    private EditText edtAngka1;
    private EditText edtAngka2;
    private EditText edtHasil;
    private RadioGroup rdGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalkulator);

        edtAngka1 = (EditText) findViewById(R.id.angka1);
        edtAngka2 = (EditText) findViewById(R.id.angka2);
        edtHasil = (EditText) findViewById(R.id.hasil);
        rdGroup = (RadioGroup) findViewById(R.id.actionGroup);

        Button btnHitung = (Button) findViewById(R.id.submit_button);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = rdGroup.getCheckedRadioButtonId();
                if(TextUtils.isEmpty(edtAngka1.getText()) || TextUtils.isEmpty(edtAngka2.getText())) {
                    Toast.makeText(KalkulatorActivity.this, "Angka Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    int val1 = Integer.parseInt(edtAngka1.getText().toString());
                    int val2 = Integer.parseInt(edtAngka2.getText().toString());

                    switch (selectedId) {
                        case R.id.tambah:
                            edtHasil.setText(Integer.toString(val1 + val2));
                            break;
                        case R.id.kurang:
                            edtHasil.setText(Integer.toString(val1 - val2));
                            break;
                        case R.id.kali:
                            edtHasil.setText(Integer.toString(val1 * val2));
                            break;
                        case R.id.bagi:
                            edtHasil.setText(Integer.toString(val1 / val2));
                            break;
                    }
                }
            }
        });

        Button btnClear = (Button) findViewById(R.id.clear_button);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtAngka1.setText("");
                edtAngka2.setText("");
                edtHasil.setText("");
            }
        });

        if(savedInstanceState != null) {

        }

    }
}
