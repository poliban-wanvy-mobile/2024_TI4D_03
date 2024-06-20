package com.example.utsppb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.Locale;

public class main extends AppCompatActivity {
    Button bt_logout, bt_hitung, bt_about;
    Spinner spinner;
    EditText et_jumlah, et_hasil;
    Float jumlah, hasil;
    String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et_hasil = findViewById(R.id.et_hasil);
        bt_logout = findViewById(R.id.bt_logout);
        bt_logout.setOnClickListener(view -> login());
        bt_about = findViewById(R.id.bt_about);
        bt_about.setOnClickListener(view -> about());
        spinner = findViewById(R.id.spinner);
        bt_hitung = findViewById(R.id.bt_hitung);
        et_jumlah = findViewById(R.id.et_jumlah);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String awal = formatter.format(0.0);
        et_hasil.setText(awal);
        bt_hitung.setOnClickListener(view -> {
           String angka = et_jumlah.getText().toString();
            int pilihBBM = spinner.getSelectedItemPosition();
            Integer pertalite = 10000, dex = 15450, pertamax = 13500, pertamax_turbo = 14750, biosolar = 6800;
            if(angka.equals("")) {
                Toast.makeText(getApplicationContext(), "Jumlah tidak boleh kosong, mohon isi terlebih dahulu", Toast.LENGTH_SHORT).show();
            }else {
                switch (pilihBBM) {
                    case 1:
                        jumlah = Float.parseFloat(angka);
                        hasil = pertalite * jumlah;
                        total = formatter.format(hasil);
                        et_hasil.setText(total);
                        break;
                    case 2:
                        jumlah = Float.parseFloat(angka);
                        hasil = dex * jumlah;
                        total = formatter.format(hasil);
                        et_hasil.setText(total);
                        break;
                    case 3:
                        jumlah = Float.parseFloat(angka);
                        hasil = pertamax * jumlah;
                        total = formatter.format(hasil);
                        et_hasil.setText(total);
                        break;
                    case 4:
                        jumlah = Float.parseFloat(angka);
                        hasil = pertamax_turbo * jumlah;
                        total = formatter.format(hasil);
                        et_hasil.setText(total);
                        break;
                    case 5:
                        jumlah = Float.parseFloat(angka);
                        hasil = biosolar * jumlah;
                        total = formatter.format(hasil);
                        et_hasil.setText(total);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Silakan pilih jenis BBM terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void login() {
        startActivity(new Intent(this, login.class));
    }
    private void about() {
        startActivity(new Intent(this, about.class));
    }
}