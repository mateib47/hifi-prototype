package com.google.android.gms.samples.vision.ocrreader;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PreferencesActivity extends AppCompatActivity {

    RadioButton minimum;
    RadioButton recommended;
    CheckBox milk;
    CheckBox egg;
    CheckBox peanut;
    CheckBox wheat;
    CheckBox soy;
    CheckBox seafood;
    CheckBox lactose;
    CheckBox vegan;
    CheckBox vegetarian;
    CheckBox gluten;
    Button apply;
    private String preferenceSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrences);

        preferenceSelection = getIntent().getExtras().getString("preferences");
        milk = (CheckBox) findViewById(R.id.Milk);
        egg = (CheckBox) findViewById(R.id.Egg);
        peanut = (CheckBox) findViewById(R.id.Peanut);
        wheat = (CheckBox) findViewById(R.id.Wheat);
        soy = (CheckBox) findViewById(R.id.Soy);
        seafood = (CheckBox) findViewById(R.id.Seafood);
        lactose = (CheckBox) findViewById(R.id.Lactose);
        vegan = (CheckBox) findViewById(R.id.Vegan);
        vegetarian = (CheckBox) findViewById(R.id.Vegetarian);
        gluten = (CheckBox) findViewById(R.id.Gluten);
        minimum = (RadioButton) findViewById(R.id.Minimum);
        recommended = (RadioButton) findViewById(R.id.Recommended);
        apply = (Button) findViewById(R.id.Apply);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Preferences have been saved.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                preferenceSelection = getPreferenceString();
                onBackPressed();
            }

        });

        checkPreviousPreferences();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public void finishSession(){
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void checkPreviousPreferences() {
        if (preferenceSelection.charAt(0) == '1') {
            milk.setChecked(true);
        }

        if (preferenceSelection.charAt(1) == '1') {
            egg.setChecked(true);
        }

        if (preferenceSelection.charAt(2) == '1') {
            peanut.setChecked(true);
        }

        if (preferenceSelection.charAt(3) == '1') {
            wheat.setChecked(true);
        }

        if (preferenceSelection.charAt(4) == '1') {
            soy.setChecked(true);
        }

        if (preferenceSelection.charAt(5) == '1') {
            seafood.setChecked(true);
        }

        if (preferenceSelection.charAt(6) == '1') {
            lactose.setChecked(true);
        }

        if (preferenceSelection.charAt(7) == '1') {
            vegan.setChecked(true);
        }

        if (preferenceSelection.charAt(8) == '1') {
            vegetarian.setChecked(true);
        }

        if (preferenceSelection.charAt(9) == '1') {
            gluten.setChecked(true);
        }
        if (preferenceSelection.charAt(10) == '1') {
            minimum.setChecked(true);
        }
        if (preferenceSelection.charAt(11) == '1') {
            recommended.setChecked(true);
        }
    }

    private String getPreferenceString() {
        StringBuilder sb = new StringBuilder();

        if (milk.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }

        if (egg.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }

        if (peanut.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }

        if (wheat.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }

        if (soy.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }

        if (seafood.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }

        if (lactose.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }

        if (vegan.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }

        if (vegetarian.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }

        if (gluten.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }
        if (minimum.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }
        if (recommended.isChecked()) {
            sb.append('1');
        } else {
            sb.append('0');
        }
        return sb.toString();
    }

    public void onBackPressed() {
        Intent i = new Intent(PreferencesActivity.this, MainActivity.class);
        i.putExtra("preferences", preferenceSelection);
        startActivity(i);
        finish();
    }
}
