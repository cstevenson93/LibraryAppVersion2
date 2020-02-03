package com.example.libraryappversion1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class browserWebView extends AppCompatActivity {

    String url;
    Uri uri;
    String appPackage;
    WebView myWebView;
    ActionBar action;




    private void launchPage(View view){
        Bundle extras = getIntent().getExtras();
        Intent goToMarket = null;
        url = extras.getString("url");

        if(!url.equals("https://camden.bywatersolutions.com/")){
            appPackage = extras.getString("package");
            goToMarket = new Intent(Intent.ACTION_VIEW,uri.parse("market://details?id="+appPackage));
        }



        if(url.equals("https://camden.bywatersolutions.com/")){
            myWebView.loadUrl(url);
        } else {

            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appPackage);
            if (launchIntent != null) {
                startActivity(launchIntent);
                finish();
            } else {

                startActivity(goToMarket);
                finish();

            }


        }

    }

    private void launchSearch(View view){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String origin = getIntent().getExtras().get("origin").toString();

        Log.i("ORIGIN KEY:  ", origin);

        //eContent Process

            final String javascriptUrlUser = "javascript: (function() {document.getElementById('userid').value= '50000005754949';}) ();";
            final String javascriptUrlPass = "javascript: (function() {document.getElementById('password').value= '4949';}) ();";
            final String javascriptUrlLogin = "javascript: (function() {document.getElementsByTagName('input')[9].click();}) ();";





            myWebView = new WebView(this);

            WebSettings webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setLoadWithOverviewMode(true);
            webSettings.setUseWideViewPort(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webSettings.setSupportZoom(true);
            webSettings.setDefaultTextEncodingName("utf-8");


            setContentView(myWebView);

            launchPage(myWebView);

            myWebView.setWebViewClient(new WebViewClient() {


                @Override

                public void onPageFinished(WebView view, String url) {


                    if (url.equals("https://camden.bywatersolutions.com/")) {
                        //Toast.makeText(browserWebView.this, "Current Url: " + url, Toast.LENGTH_LONG).show();
                        //myWebView.getSettings().setJavaScriptEnabled(true);
                        view.loadUrl(javascriptUrlUser);
                        view.loadUrl(javascriptUrlPass);
                        view.loadUrl(javascriptUrlLogin);

                        //Search Bar Process
                        if (origin.equals("search")){
                            final String javascriptSearch = "javascript: (function() {document.getElementById('translControl1').value= '" + getIntent().getExtras().get("ISBN").toString() + "';}) ();";
                            final String javascriptSearchButton = "javascript: (function() {document.getElementsByTagName('button')[0].click();}) ();";





                                    view.loadUrl(javascriptSearch);
                                    view.loadUrl(javascriptSearchButton);





                        }
                    }


                }
            });






    }
}
