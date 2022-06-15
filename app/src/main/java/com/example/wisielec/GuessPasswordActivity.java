package com.example.wisielec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class GuessPasswordActivity extends AppCompatActivity {

    Intent intent;
    String password;
    String category;
    String currentPassword = "";
    TextView tvPassword;
    TextView tvCategory;
    TextView tvResultInfo;
    ImageView imageViewHangman;
    TableLayout tableLayout;
    Button btnSameCategory;
    Button btnChangeCategory;
    int faults = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        setContentView(R.layout.activity_guess_password);
        intent = getIntent();

        tvPassword = (TextView) findViewById(R.id.tvPassword);
        tvCategory = (TextView) findViewById(R.id.tvCategory);
        btnChangeCategory = (Button) findViewById(R.id.btnChangeCategory);
        btnSameCategory = (Button) findViewById(R.id.btnSameCategory);
        tvResultInfo = (TextView) findViewById(R.id.tvResultInfo);
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        imageViewHangman = (ImageView) findViewById(R.id.imageViewHangman);
        password = intent.getStringExtra("password");
        category = intent.getStringExtra("category").toUpperCase(Locale.ROOT);
        password = password.toUpperCase(Locale.ROOT);
        tvCategory.setText(category);

        for(int i = 0; i < password.length(); i++){
            String myChar = Character.toString(password.charAt(i));
            if(myChar.equals(" ")){
                currentPassword += " ";
            }
            else{
                currentPassword += "_";
            }
        }
        if(currentPassword != null) {
            tvPassword.setText(currentPassword);
        }

        btnChangeCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChooseCategoryActivity.class);
                startActivity(intent);
            }
        });

        btnSameCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChooseCategoryActivity.class);
                intent.putExtra("sameCat", true);
                intent.putExtra("category", category.toLowerCase());
                startActivity(intent);
            }
        });
    }

    public void letterClicked(View view) {
        String strLetterClicked = (String) ((TextView) view).getText();
        boolean isLetter = false;
        for(int i = 0; i < password.length(); i++){
            String myChar = Character.toString(password.charAt(i));
            if(myChar.equalsIgnoreCase(strLetterClicked)){
                currentPassword = currentPassword.substring(0, i) + strLetterClicked + currentPassword.substring(i + 1);
                isLetter = true;
            }
        }
        if(!isLetter){
            faults++;
            switch(faults) {
                case 1:
                    imageViewHangman.setImageResource(R.drawable.wisielec_e1);
                    break;
                case 2:
                    imageViewHangman.setImageResource(R.drawable.wisielec_e2);
                    break;
                case 3:
                    imageViewHangman.setImageResource(R.drawable.wisielec_e3);
                    break;
                case 4:
                    imageViewHangman.setImageResource(R.drawable.wisielec_e4);
                    break;
                case 5:
                    imageViewHangman.setImageResource(R.drawable.wisielec_e5);
                    break;
                case 6:
                    imageViewHangman.setImageResource(R.drawable.wisielec_e6);
                    break;
                case 7:
                    imageViewHangman.setImageResource(R.drawable.wisielec_e7);
                    break;
                case 8:
                    imageViewHangman.setImageResource(R.drawable.wisielec_e8);
                    break;
                case 9:
                    imageViewHangman.setImageResource(R.drawable.wisielec_e9);
                    break;
            }
            //((TextView) view).setTextColor(Color.rgb(255,0,0));
            view.setClickable(false);
            view.setVisibility(View.INVISIBLE);
        }
        else{
            tvPassword.setText(currentPassword);
            //((TextView) view).setTextColor(Color.rgb(0,255,0));
            view.setClickable(false);
            view.setVisibility(View.INVISIBLE);
        }

        if(faults == 9){
            tableLayout.setVisibility(View.INVISIBLE);
            tableLayout.setClickable(false);
            String comunicat = "PRZEGRANA";
            tvResultInfo.setText(comunicat);
            tvResultInfo.setTextColor(Color.rgb(255, 0, 0));
            tvResultInfo.setVisibility(View.VISIBLE);
            tvPassword.setText(password);
            btnSameCategory.setClickable(true);
            btnSameCategory.setVisibility(View.VISIBLE);
            btnChangeCategory.setClickable(true);
            btnChangeCategory.setVisibility(View.VISIBLE);
        }

        if(currentPassword.equalsIgnoreCase(password)){
            tableLayout.setVisibility(View.INVISIBLE);
            tableLayout.setClickable(false);
            String comunicat = "WYGRANA";
            tvResultInfo.setText(comunicat);
            tvResultInfo.setTextColor(Color.rgb(0, 255, 0));
            tvResultInfo.setVisibility(View.VISIBLE);
            tvPassword.setText(password);
            btnSameCategory.setClickable(true);
            btnSameCategory.setVisibility(View.VISIBLE);
            btnChangeCategory.setClickable(true);
            btnChangeCategory.setVisibility(View.VISIBLE);
        }
    }
}