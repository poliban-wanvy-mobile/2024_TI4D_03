package com.example.utsppb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {
    Button bt_login;
    EditText et_password, et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bt_login = findViewById(R.id.bt_login);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);


        bt_login.setOnClickListener(view -> {
            String password = et_password.getText().toString();
            String email = et_email.getText().toString();
            if (password.equals("admin")&&email.equals("admin")) {
                main();
            } else if (email.equals("admin")) {
                String text = "Masukan password yang benar!!!";
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
            }else if (email.equals("")&&password.equals("")) {
                String text = "Masukan email dan password yang benar!!!";
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
            } else if (email.equals("")) {
                String text = "Masukan email yang benar!!!";
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void main() {
        startActivity(new Intent(this, main.class));
    }
}