package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Call extends AppCompatActivity {
     EditText etname,etpass;
     Button btnlogin;
    String name;
    LinearLayout linearLayout;
     private static final int REQUEST_PHONE_CALL = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        etname=findViewById(R.id.et_name);
        etpass=findViewById(R.id.et_pass);
        btnlogin=findViewById(R.id.btn_login);
        linearLayout=findViewById(R.id.linear1);
        Snackbar.make(linearLayout, "Message is restored!", Snackbar.LENGTH_SHORT).show();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              name=etname.getText().toString();
           /*     Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));
                // get the reference of TextView and ImageVIew from inflated layout
                TextView toastTextView = (TextView) layout.findViewById(R.id.toastTextView);
                ImageView toastImageView = (ImageView) layout.findViewById(R.id.toastImageView);
                // set the text in the TextView
                toastTextView.setText("Custom Toast In Android");
                // set the Image in the ImageView
                toastImageView.setImageResource(R.drawable.ic_crop_portrait_black_24dp);
                // create a new Toast using context
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG); // set the duration for the Toast
                toast.setView(layout); // set the inflated layout
                toast.show(); // display the custom Toast*/
           //phonecall(name);
                Snackbar snackbar = Snackbar
                        .make(linearLayout, "Message is deleted", Snackbar.LENGTH_LONG)

                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(linearLayout, "Message is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                snackbar.show();

        }
    });
    }

    private void phonecall(String name) {
        if (ContextCompat.checkSelfPermission(Call.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
         ActivityCompat.requestPermissions(Call.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }
        else
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +name ));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case REQUEST_PHONE_CALL: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    phonecall(name);
                }
                else
                {
                    Toast.makeText(this, "Sorry", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
