package com.example.biblicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoryActivity extends AppCompatActivity {

    private LinearLayout categoriesLayout;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoriesLayout = findViewById(R.id.categoriesLayout);
        button = findViewById(R.id.contributeProverb);

        // Display categories
        displayCategories();

        // Proverb contribution button setup
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, ProverbContributionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void displayCategories() {
        ArrayList<String> categories = new ArrayList<>(Arrays.asList(
                "Wisdom and Knowledge", "Righteousness and Justice", "Love and Compassion", "Faith and Hope",
                "Courage and Strength","Humility and pride","wealth and poverty","friendship and relationship",
                "Anger and patience","speech and silence","Forgiveness and Mercy","Gratitude and Contentment"
        ));

        for (String category : categories) {
            TextView categoryView = new TextView(this);
            categoryView.setText(category);
            categoryView.setTextSize(25);
            categoryView.setPadding(10, 30, 10, 10);

            categoryView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to ProverbListActivity and pass the selected category
                    Intent intent = new Intent(CategoryActivity.this, ProverbListActivity.class);
                    intent.putExtra("category", category);
                    startActivity(intent);
                }
            });
            categoriesLayout.addView(categoryView);
        }
    }
}
