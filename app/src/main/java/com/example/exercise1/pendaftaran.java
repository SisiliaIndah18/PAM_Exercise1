package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class pendaftaran extends AppCompatActivity {
    String agama = "", JenisKelamin = "";
    Button BtnBatal, BtnDaftar;
    EditText DaftarAlamat, DaftarEmail, DaftarNama, DaftarPassword, DaftarRepassword;
    TextInputLayout DaftarAlamatError, DaftarEmailError, DaftarNamaError, DaftarPasswordError, DaftarRepasswordError;
    RadioButton rbBudha, rbHindu, rbIslam, rbKatolik, rbKepercayaan, rbKonghucu, rbKristen, rbLaki, rbPerempuan;
    RadioGroup rg1Agama, rg2Agama, rg3Agama, rgJenisKelamin;
    private int CheckAgama, CheckJenisKelamin;
    private boolean Checking = true;
    boolean EmailValid = false;
    boolean PasswordValid = false;
    boolean RePasswordValid = false;
    boolean AlamatValid = false;
    boolean NamaValid = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendaftaran);
        Item();
        rg1Agama.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && pendaftaran.this.Checking) {
                    pendaftaran.this.Checking = false;
                    pendaftaran.this.rg2Agama.clearCheck();
                    pendaftaran.this.rg3Agama.clearCheck();
                    pendaftaran.this.CheckAgama = i;
                }
                pendaftaran.this.Checking = true;
            }
        });
        rg2Agama.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && pendaftaran.this.Checking) {
                    pendaftaran.this.Checking = false;
                    pendaftaran.this.rg1Agama.clearCheck();
                    pendaftaran.this.rg3Agama.clearCheck();
                    pendaftaran.this.CheckAgama = i;
                }
                pendaftaran.this.Checking = true;
            }
        });
        rg3Agama.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && pendaftaran.this.Checking) {
                    pendaftaran.this.Checking = false;
                    pendaftaran.this.rg1Agama.clearCheck();
                    pendaftaran.this.rg2Agama.clearCheck();
                    pendaftaran.this.CheckAgama = i;
                }
                pendaftaran.this.Checking = true;
            }
        });
        this.rgJenisKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && pendaftaran.this.Checking) {
                    pendaftaran.this.Checking = false;
                    pendaftaran.this.CheckJenisKelamin = i;
                }
                pendaftaran.this.Checking = true;
            }
        });
        BtnDaftar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                pendaftaran.this.JenisAgama(view);
                pendaftaran.this.JenisKelamin(view);
                pendaftaran.this.validasi(view);
            }
        });
        BtnBatal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                pendaftaran.this.startActivity(new Intent(pendaftaran.this.getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void Item() {
        DaftarNama = (EditText) findViewById(R.id.idNama);
        DaftarAlamat = (EditText) findViewById(R.id.idAlamat);
        DaftarEmail = (EditText) findViewById(R.id.idDafEmail);
        DaftarPassword = (EditText) findViewById(R.id.idDafPw);
        DaftarRepassword = (EditText) findViewById(R.id.idDafRepw);
        rgJenisKelamin = (RadioGroup) findViewById(R.id.rgJenisKelamin);
        rg1Agama = (RadioGroup) findViewById(R.id.rg1);
        rg2Agama = (RadioGroup) findViewById(R.id.rg2);
        rg3Agama = (RadioGroup) findViewById(R.id.rg3);
        rbLaki = (RadioButton) findViewById(R.id.idLaki);
        rbPerempuan = (RadioButton) findViewById(R.id.idPerempuan);
        rbIslam = (RadioButton) findViewById(R.id.idIslam);
        rbKatolik = (RadioButton) findViewById(R.id.idKatolik);
        rbKristen = (RadioButton) findViewById(R.id.idKristen);
        rbKonghucu = (RadioButton) findViewById(R.id.idKonghucu);
        rbHindu = (RadioButton) findViewById(R.id.idHindu);
        rbBudha = (RadioButton) findViewById(R.id.idBudha);
        rbKepercayaan = (RadioButton) findViewById(R.id.idKepercayaan);
        DaftarNamaError = (TextInputLayout) findViewById(R.id.DafNamaError);
        DaftarAlamatError = (TextInputLayout) findViewById(R.id.DafAlamatError);
        DaftarEmailError = (TextInputLayout) findViewById(R.id.DafEmailError);
        DaftarPasswordError = (TextInputLayout) findViewById(R.id.DafPwError);
        DaftarRepasswordError = (TextInputLayout) findViewById(R.id.DafRepwError);
        BtnBatal = (Button) findViewById(R.id.btnBatal);
        BtnDaftar = (Button) findViewById(R.id.btnDaftar);
    }

    public void JenisAgama(View view) {
        int i = this.CheckAgama;
        if (i == R.id.idIslam) {
            this.agama = "Islam";
        } else if (i == R.id.idKatolik) {
            this.agama = "Katolik";
        } else if (i == R.id.idKristen) {
            this.agama = "Kristen";
        } else if (i == R.id.idKonghucu) {
            this.agama = "Konghucu";
        } else if (i == R.id.idHindu) {
            this.agama = "Hindu";
        } else if (i == R.id.idBudha) {
            this.agama = "Budha";
        } else if (i == R.id.idKepercayaan) {
            this.agama = "Aliran Kepercayaan";
        }
    }

    public void JenisKelamin(View view) {
        int i = this.CheckJenisKelamin;
        if (i == R.id.idLaki) {
            JenisKelamin = "Laki-Laki";
        } else if (i == R.id.idPerempuan) {
            JenisKelamin = "Perempuan";
        }
    }

    public void validasi(View view) {
        if (this.DaftarNama.getText().toString().isEmpty() || DaftarAlamat.getText().toString().isEmpty()
                || DaftarEmail.getText().toString().isEmpty() || DaftarPassword.getText().toString().isEmpty()
                || DaftarRepassword.getText().toString().isEmpty() || agama.isEmpty() || JenisKelamin.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Data Harus Diisi Semua", Toast.LENGTH_LONG).show();
        }
        if (DaftarNama.getText().toString().isEmpty()) {
            DaftarNamaError.setError("Nama Tidak Boleh Kosong");
            NamaValid = false;
        } else {
            DaftarNamaError.setErrorEnabled(false);
            NamaValid = true;
        }
        if (DaftarAlamat.getText().toString().isEmpty()) {
            DaftarAlamatError.setError("Alamat Tidak Boleh Kosong");
            AlamatValid = false;
        } else {
            DaftarAlamatError.setErrorEnabled(false);
            AlamatValid = true;
        }
        if (DaftarEmail.getText().toString().isEmpty()) {
            DaftarEmailError.setError("Email Tidak Boleh Kosong");
            EmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(DaftarEmail.getText().toString()).matches()) {
            DaftarEmailError.setError("Harap Masukkan Email Dengan Benar");
            EmailValid = false;
        } else {
            EmailValid = true;
            DaftarEmailError.setErrorEnabled(false);
        }
        if (DaftarPassword.getText().toString().isEmpty()) {
            DaftarPasswordError.setError("Password Tidak Boleh Kosong");
            PasswordValid = false;
        } else if (this.DaftarPassword.getText().length() < 6) {
            DaftarPasswordError.setError("Panjang Password Minimal 6 Karakter");
            PasswordValid = false;
        } else {
            PasswordValid = true;
            DaftarPasswordError.setErrorEnabled(false);
        }
        if (DaftarRepassword.getText().toString().isEmpty()) {
            DaftarRepasswordError.setError("Re-Password Tidak Boleh Kosong");
            RePasswordValid = false;
        } else if (DaftarRepassword.getText().length() < 12) {
            DaftarRepasswordError.setError("Panjang Re-Password Minimal 12 Karakter");
            RePasswordValid = false;
        } else if (!DaftarRepassword.getText().toString().equals(DaftarPassword.getText().toString())) {
            DaftarRepasswordError.setError("Password Tidak Sama");
            RePasswordValid = false;
        } else {
            RePasswordValid = true;
            DaftarRepasswordError.setErrorEnabled(false);
        }
        if (NamaValid && AlamatValid && EmailValid && PasswordValid && RePasswordValid
                && !agama.isEmpty() && !JenisKelamin.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}