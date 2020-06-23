package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText edtname,edtpassword;
    Button btnback,btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edtname=findViewById(R.id.edt_name);
        edtpassword=findViewById(R.id.edt_password);
        btnsubmit=findViewById(R.id.btn_submit);
        btnback=findViewById(R.id.btn_back);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("key_1");
        edtname.setText(title);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Call.class));
            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtname.getText().toString();
                Toast.makeText(getApplicationContext(),"Welcome "+name,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
