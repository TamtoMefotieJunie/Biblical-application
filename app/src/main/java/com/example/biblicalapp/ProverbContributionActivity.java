package com.example.biblicalapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class ProverbContributionActivity extends AppCompatActivity {

    private static final String TAG = "ProverbContributionActivity";
    private VolleyService volleyService;
    private EditText category;
    private EditText proverbText;
    private EditText reference;
    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_proverb_contribution);
        // Initialize views
        proverbText = findViewById(R.id.proverbText);
        reference = findViewById(R.id.reference);
        category = findViewById(R.id.category);
        button = findViewById(R.id.button);

        volleyService = VolleyService.getInstance(this);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textProverb = proverbText.getText().toString();
                String textReference = reference.getText().toString();
                String textCategory= category.getText().toString();
                if (TextUtils.isEmpty(textProverb) || TextUtils.isEmpty(textReference) || TextUtils.isEmpty(textCategory) ){
                    Toast.makeText(ProverbContributionActivity.this,"All fields required", Toast.LENGTH_SHORT).show();
                }
                else {
                    registerNewProverb(textProverb,textReference,textCategory);
                }
            }
        });

    }

    private void registerNewProverb(String proverbText,String reference,String category){
        ProgressDialog progressDialog = new ProgressDialog(ProverbContributionActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("adding proverb");
        progressDialog.show();

        String url = Constants.API_URL + "/contribution";

        try {
            JSONObject postData = new JSONObject();
            postData.put("proverbText", proverbText);
            postData.put("reference", reference);
            postData.put("category", category);

            volleyService.makePostRequest(url, postData, new VolleyService.VolleyCallback() {
                @Override
                public void onSuccess(JSONObject result) {
                    // Handle success response
                    progressDialog.dismiss();
                    Toast.makeText(ProverbContributionActivity.this,"Contribution Successfull !!!",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ProverbContributionActivity.this,CategoryActivity.class));
                    finish();
                }

                @Override
                public void onError(VolleyError error) {
                    // Handle error response
                    progressDialog.dismiss();
                    Toast.makeText(ProverbContributionActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        } catch (JSONException e) {
            progressDialog.dismiss();
            Toast.makeText(ProverbContributionActivity.this, "An error occurred", Toast.LENGTH_LONG).show();
        }
    }

}
