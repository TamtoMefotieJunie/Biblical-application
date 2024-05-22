package com.example.biblicalapp;

import android.app.ProgressDialog;
import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.Request;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private static final String TAG = "CategoryActivity";
    private VolleyService volleyService;
    public Button button;
    private LinearLayout categoriesLayout;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);
        categoriesLayout = findViewById(R.id.categoriesLayout);
        requestQueue = Volley.newRequestQueue(this);
        fetchCategories();


        //proverb contribution
        button = (Button) findViewById(R.id.contributeProverb);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, ProverbContributionActivity.class);
                startActivity(intent);
            }
        });
    }

        private void fetchCategories() {
            String url = "http://192.168.228.157/biblicapp/category";

            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Fetching Categories...");
            progressDialog.show();

            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            progressDialog.dismiss();
                            try {
                                ArrayList<String> categories = new ArrayList<>();
                                for (int i = 0; i < response.length(); i++) {
                                    categories.add(response.getString(i));
                                }
                                displayCategories(categories);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(CategoryActivity.this, "Error parsing categories", Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                            Toast.makeText(CategoryActivity.this, "Error fetching categories", Toast.LENGTH_SHORT).show();
                        }
                    });

            requestQueue.add(jsonArrayRequest);
        }
        

        private void displayCategories(ArrayList<String> categories) {
            for (String category : categories) {
                TextView textView = new TextView(this);
                textView.setText(category);
                textView.setTextSize(20);
                categoriesLayout.addView(textView);
            }
        }


}