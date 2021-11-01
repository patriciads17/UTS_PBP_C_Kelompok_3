package com.example.pyb.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.example.pyb.MainActivity;
import com.example.pyb.R;
import com.example.pyb.helper.ViewModelFactory;
import com.example.pyb.database.UserPreferences;
import com.example.pyb.register.RegisterActivity;
import com.example.pyb.model.User;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText edtNpm, edtPassword;
    private Button btnLogin, btnRegister;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        edtNpm = findViewById(R.id.edit_text_npm);
        edtPassword = findViewById(R.id.edit_text_password);
        btnLogin = findViewById(R.id.button_login);
        btnRegister = findViewById(R.id.button_register);
        userPreferences = new UserPreferences(this);

        setListener();
        checkLogin();
    }

    private void setListener() {
        btnLogin.setOnClickListener(view -> validateForm());
        btnRegister.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }

    private void checkLogin(){
        if(userPreferences.checkLogin()){
            moveToHome();
        }
    }

    private void validateForm() {
        if (edtNpm.getText().toString().trim().isEmpty() || edtPassword.getText().toString().trim().isEmpty()) {
            Toast.makeText(LoginActivity.this, "Username Atau Password Kosong", Toast.LENGTH_SHORT).show();
        } else {
            doLogin(edtNpm.getText().toString().trim(), edtPassword.getText().toString().trim());
        }
    }

    private void doLogin(String npm, String password) {
        LoginViewModel loginViewModel = obtainViewModel(LoginActivity.this);
        loginViewModel.login(npm, password).observe(this, user -> {
            if (user != null) {
                userPreferences.setLogin(user);
                moveToHome();
            } else {
                Toast.makeText(LoginActivity.this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    private static LoginViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return new ViewModelProvider(activity, factory).get(LoginViewModel.class);
    }

    private void moveToHome(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}