package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class First extends AppCompatActivity {
    EditText edtName,edtPass;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        edtName=findViewById(R.id.edt_name);
        edtPass=findViewById(R.id.edt_Pass);
        btnlogin=findViewById(R.id.btn_Login);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(First.this, "Welcome", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
