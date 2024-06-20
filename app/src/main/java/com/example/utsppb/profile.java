package com.example.utsppb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class profile extends AppCompatActivity {
    Button bt_back, bt_logout;
    TextView tv_nama, tv_prodi, tv_kelas, tv_hobi;
    ImageView iv_gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bt_logout = findViewById(R.id.bt_logout);
        bt_logout.setOnClickListener(view -> login());
        bt_back = findViewById(R.id.bt_back);
        bt_back.setOnClickListener(view -> about());

        tv_nama = findViewById(R.id.tv_nama);
        tv_prodi = findViewById(R.id.tv_nim);
        tv_kelas = findViewById(R.id.tv_kelas);
        tv_hobi = findViewById(R.id.tv_hobi);
        iv_gambar = findViewById(R.id.iv_gambar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nama = extras.getString("nama");
            String nim = extras.getString("nim");
            String kelas = extras.getString("kelas");
            String hobi = extras.getString("hobi");

            tv_nama.setText(nama);
            tv_prodi.setText(nim);
            tv_kelas.setText(kelas);
            tv_hobi.setText(hobi);

            if (nama.equalsIgnoreCase("M. Naufal Dzil Ikram")) {
                iv_gambar.setImageResource(R.drawable.naufal);
            } else if (nama.equalsIgnoreCase("Muhammad Yusup Haekal Sambas")) {
                iv_gambar.setImageResource(R.drawable.sambas);
            }else if (nama.equalsIgnoreCase("Nuriliani")) {
                iv_gambar.setImageResource(R.drawable.nuril);
            }else if (nama.equalsIgnoreCase("Mico Gosyin")) {
                iv_gambar.setImageResource(R.drawable.mico);
            }else if (nama.equalsIgnoreCase("Muhammad Apriansyah")) {
                iv_gambar.setImageResource(R.drawable.apri);
            }
        }
    }
    private void login() {
        startActivity(new Intent(this, login.class));
    }
    private void about() {
        startActivity(new Intent(this, about.class));
    }
}