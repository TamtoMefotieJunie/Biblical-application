package com.example.biblicalapp;


import android.app.ProgressDialog;
import android.os.Bundle;
import java.sql.PreparedStatement;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import java.sql.SQLException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.ViewCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private VolleyService volleyService;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText emailEditText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        emailEditText = findViewById(R.id.emailEditText);
        button = findViewById(R.id.button);

        volleyService = VolleyService.getInstance(this);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textUsername = usernameEditText.getText().toString();
                String textEmail = emailEditText.getText().toString();
                String textPassword = passwordEditText.getText().toString();
                    if (TextUtils.isEmpty(textUsername) || TextUtils.isEmpty(textEmail) || TextUtils.isEmpty(textPassword) ){
                        Toast.makeText(MainActivity.this,"All fields required", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        registerNewAccount(textUsername,textEmail,textPassword);
                    }
            }
        });

    }

    private void registerNewAccount(String usernameEditText,String emailEditText,String passwordEditText){
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Signing up");
        progressDialog.show();

        String url = Constants.API_URL+ "/register";
        try {
            JSONObject postData = new JSONObject();
            postData.put("usernameEditText", usernameEditText);
            postData.put("passwordEditText", passwordEditText);
            postData.put("emailEditText", emailEditText);

            volleyService.makePostRequest(url, postData, new VolleyService.VolleyCallback() {
                @Override
                public void onSuccess(JSONObject result) {
                    // Handle success response
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Register Successfull !!!",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    finish();
                }

                @Override
                public void onError(VolleyError error) {
                    // Handle error response
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"An error occured while registering !!!",Toast.LENGTH_LONG).show();
                }
            });
        } catch (JSONException e) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, "An error occurred", Toast.LENGTH_LONG).show();
        }
    }


}