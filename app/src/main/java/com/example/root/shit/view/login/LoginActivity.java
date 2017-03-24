package com.example.root.shit.view.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.root.shit.R;
import com.example.root.shit.view.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_signin)
    Button btnSignIn;

    @BindView(R.id.tv_create)
    TextView tvCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnSignIn.setOnClickListener(v -> goToMainActivity());
        tvCreate.setOnClickListener(v -> goToRegistrationActivity());
    }

    private void goToRegistrationActivity() {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    private void goToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
