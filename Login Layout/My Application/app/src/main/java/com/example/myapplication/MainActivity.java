package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.login_relative);

        usernameEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.btnLogin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_relative), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Hiển thị bằng Toast -> Be bé tinh tế
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = usernameEditText.getText().toString().trim();
//                String password = passwordEditText.getText().toString().trim();
//
//                if (username.equals("admin") && password.equals("123456")) {
//                    Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        //Hiến thị bằng dialog
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                if (username.equals("admin") && password.equals("123456")) {
                    builder.setTitle("Success")
                            .setMessage("Login successfully")
                            .setPositiveButton("OK", null);
                } else {
                    builder.setTitle("Error")
                            .setMessage("Login failed")
                            .setPositiveButton("Try Again", null);
                }
                builder.show();
            }
        });
    }
}