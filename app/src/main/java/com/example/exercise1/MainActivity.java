package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button BtnLogin;
    EditText EmailEt, PwEt;
    TextView FormDafTv;
    TextInputLayout EmailError, PwError;
    boolean EmailValid;
    boolean PwValid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmailEt = (EditText) findViewById(R.id.idEmail);
        PwEt = (EditText) findViewById(R.id.idPw);
        FormDafTv = (TextView) findViewById(R.id.idFormDaftar);
        BtnLogin = (Button) findViewById(R.id.idLogin);
        EmailError = (TextInputLayout) findViewById(R.id.idEmailError);
        PwError = (TextInputLayout) findViewById(R.id.idPwError);


        BtnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.Validasi();
            }
        });

        FormDafTv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), pendaftaran.class));
            }
        });
    }

    public void Validasi() {

        if (EmailEt.getText().toString().isEmpty()) {
            EmailError.setError("Email Tidak Boleh Kosong");
            EmailValid = false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(EmailEt.getText().toString()).matches()) {
            EmailError.setError("Masukkan Email");
            EmailValid = false;

        } else {
            EmailValid = true;
            EmailError.setErrorEnabled(false);
        }
        if (PwEt.getText().toString().isEmpty()) {
            PwError.setError("Password Tidak Boleh Kosong");
            PwValid = false;

        } else if (PwEt.getText().length() < 8) {
            PwError.setError("Panjang Password Minimal 8 Karakter");
            PwValid = false;

        }else {
            PwValid = true;
            PwError.setErrorEnabled(false);

        }
        if (!EmailValid || !PwValid || !EmailEt.getText().toString().equals("pam2019@gmail.com") ||
                !PwEt.getText().toString().equals("semester4")) {
            Toast.makeText(getApplicationContext(), "Email atau Password Salah", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(getApplicationContext(), "Login Sukses",Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), list_kontak.class));
    }
}