package com.example.pyb.register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.example.pyb.R;
import com.example.pyb.helper.ViewModelFactory;
import com.example.pyb.model.User;
import com.example.pyb.login.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText edtNpm, edtPassword, edtName, edtMail;
    private Button btnCancel, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        edtName = findViewById(R.id.edit_text_name);
        edtNpm = findViewById(R.id.edit_text_npm);
        edtMail = findViewById(R.id.edit_text_mail);
        edtPassword = findViewById(R.id.edit_text_password);
        btnCancel = findViewById(R.id.button_cancel);
        btnRegister = findViewById(R.id.button_register);

        setListener();
    }

    private void setListener() {
        btnCancel.setOnClickListener(view -> backToLogin());
        btnRegister.setOnClickListener(view -> validateForm());
    }

    private void validateForm(){
        if (edtNpm.getText().toString().trim().isEmpty() ||
                edtPassword.getText().toString().trim().isEmpty() ||
                edtName.getText().toString().trim().isEmpty() ||
                edtMail.getText().toString().trim().isEmpty()
        ) {
            Toast.makeText(this, "Semua form harus diisi", Toast.LENGTH_SHORT).show();
        } else if(!isValidEmail(edtMail.getText().toString().trim())){
            Boolean ac = isValidEmail(edtMail.getText().toString().trim());
            Toast.makeText(this, "Format email tidak valid", Toast.LENGTH_SHORT).show();
        } else {
            doRegister(
                    edtName.getText().toString().trim(),
                    edtNpm.getText().toString().trim(),
                    edtMail.getText().toString().trim(),
                    edtPassword.getText().toString().trim()
            );
        }
    }

    public static boolean isValidEmail(CharSequence value) {
        String EMAIL = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Matcher m = Pattern.compile(EMAIL).matcher(value);
        return m.find();
    }

    private void doRegister(String name, String npm, String mail, String password){
        User user = new User(name, mail, npm, password, "", "", "", "");
        RegisterViewModel registerViewModel = obtainViewModel(this);
        registerViewModel.register(user);
        backToLogin();
    }

    @NonNull
    private static RegisterViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return new ViewModelProvider(activity, factory).get(RegisterViewModel.class);
    }

    private void backToLogin(){
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finishAffinity();
    }
}