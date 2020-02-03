package com.example.libraryappversion1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class searchActivity extends AppCompatActivity {

    public String ISBN = "1000456";
    EditText numField;
    static boolean inBackground;
    private boolean isbnVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

         numField = (EditText) findViewById(R.id.numField);

    }

    public void openScanner(View view){

        startActivityForResult(new Intent(this, ScannerActivity.class),2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            ISBN=data.getStringExtra("ISBN");
            numField.setText(ISBN);
        }
    }

    public void searchButton(View view){
        ISBN = numField.getText().toString();
        Log.i("Click Status: ", "Button Clicked");
        Intent browser = new Intent(this, browserWebView.class);
        browser.putExtra("url", "https://camden.bywatersolutions.com/");
        browser.putExtra("origin", "search");
        browser.putExtra("ISBN", ISBN);
        this.startActivity(browser) ;
    }

    public void onClick(View view){

        ConstraintLayout isbnLayout = (ConstraintLayout) findViewById(R.id.isbnLayout);
        Button category = (Button) findViewById(R.id.categoryButton);
        EditText numField = (EditText) findViewById(R.id.numField);
        ImageButton scanButton = (ImageButton) findViewById(R.id.scanButton);

        if(isbnVisible == true) {
            //isbnLayout.setVisibility(View.INVISIBLE);
            scanButton.setVisibility(View.GONE);
            numField.setHint("Keyword");
            category.setText("Search By ISBN");
            isbnVisible = false;
        } else {

            if (isbnVisible == false) {
                //isbnLayout.setVisibility(View.VISIBLE);
                scanButton.setVisibility(View.VISIBLE);
                numField.setHint("ISBN");
                category.setText("Search By Keyword");
                isbnVisible = true;
            }
        }

    }

    @Override
    protected void onStop() {
        inBackground = true;
        super.onStop();



    }

    @Override
    protected void onStart() {
        inBackground = false;
        super.onStart();

    }

    @Override
    protected void onResume() {
        inBackground = false;
        super.onResume();
    }
}
