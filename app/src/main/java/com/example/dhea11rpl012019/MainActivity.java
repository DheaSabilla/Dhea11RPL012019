package com.example.dhea11rpl012019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtusername;
    EditText txtpassword;
    Button btnlogin;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("login", MODE_PRIVATE);
        txtusername = findViewById(R.id.et1);
        txtpassword = findViewById(R.id.et2);
        btnlogin = findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et1key = txtusername.getText().toString();
                String et2key = txtpassword.getText().toString();
                if (txtusername.getText().toString().isEmpty() ||
                        txtpassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                } else {

                    if (txtusername.getText().toString().equals("Dhea")
                            && txtpassword.getText().toString().equals("Sabilla")) {
                        Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                        editor = pref.edit();
                        editor.putString("userid", txtusername.getText().toString());
                        editor.apply();
                    } else {
                        Toast.makeText(MainActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

