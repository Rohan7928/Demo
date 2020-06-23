package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    Button buttonSubmit;
    CheckBox cb1, cb2, cb3, cb4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        buttonSubmit = findViewById(R.id.btnSubmit);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.clearCheck();
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb) {
                    Toast.makeText(Registration.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
     buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onRadio();
                //Get the selected RadioButton

                String checkBoxChoices = "";

                if (cb1.isChecked()) {
                    checkBoxChoices = cb1.getText().toString() ;
                }
               else if (cb2.isChecked()) {
                    checkBoxChoices = cb2.getText().toString() ;
                }
                else if (cb3.isChecked()) {
                    checkBoxChoices = cb3.getText().toString() ;
                }

                else if (cb4.isChecked()) {
                    checkBoxChoices = cb4.getText().toString() ;
                }
                else
                {
                    Toast.makeText(Registration.this, "Nothing", Toast.LENGTH_SHORT).show();
                }


                // display it as Toast to the user

                Toast.makeText(Registration.this,  "\n CheckBox Choices: \n "+ checkBoxChoices , Toast.LENGTH_LONG).show();

            }
        });
    }

    private void onRadio() {
        selectedRadioButton  =findViewById(radioGroup.getCheckedRadioButtonId());
        // get RadioButton text
        String selected = selectedRadioButton.getText().toString();
        Toast.makeText(Registration.this, "Selected Radio Button is:" + selected,Toast.LENGTH_SHORT).show();

    }
}

