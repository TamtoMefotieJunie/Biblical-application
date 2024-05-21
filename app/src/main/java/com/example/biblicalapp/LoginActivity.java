package com.example.biblicalapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private VolleyService volleyService;
    private EditText password;
    private EditText email;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Initialize views
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        loginButton = findViewById(R.id.loginButton);

        volleyService = VolleyService.getInstance(this);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textEmail = email.getText().toString();
                String textPassword = password.getText().toString();
                if ( TextUtils.isEmpty(textEmail) || TextUtils.isEmpty(textPassword) ){
                    Toast.makeText(LoginActivity.this,"All fields required", Toast.LENGTH_SHORT).show();
                }
                else {
                    loginAccount(textPassword,textEmail);
                }
            }
        });

    }
    private void loginAccount(String password,String email ){
        ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Signing in");
        progressDialog.show();

        String url = "http://192.168.198.157/biblicapp/process.php/login";
        try {
            JSONObject postData = new JSONObject();

            postData.put("password", password);
            postData.put("email", email);

            volleyService.makePostRequest(url, postData, new VolleyService.VolleyCallback() {
                @Override
                public void onSuccess(JSONObject result) {
                    // Handle success response
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,"Login Successfull !!!",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this,activity_home.class));
                    finish();
                }

                @Override
                public void onError(VolleyError error) {
                    // Handle error response
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        } catch (JSONException e) {
            progressDialog.dismiss();
            Toast.makeText(LoginActivity.this, "An error occurred", Toast.LENGTH_LONG).show();
        }
    }

}
