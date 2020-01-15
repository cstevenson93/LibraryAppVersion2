package com.example.libraryappversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;

public class browserWebView extends AppCompatActivity {

    String url;
    Uri uri;
    String appPackage;
    WebView myWebView;




    private void launchPage(View view){
        Bundle extras = getIntent().getExtras();
        url = extras.getString("url");
        appPackage = extras.getString("package");
        Intent goToMarket = new Intent(Intent.ACTION_VIEW,uri.parse("market://details?id="+appPackage));
        //Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, appPackage, Toast.LENGTH_SHORT).show();

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
                //setContentView(myWebView);
                //myWebView.loadUrl(url);
                //Toast.makeText(MainActivity.this, "There is no package available in android", Toast.LENGTH_LONG).show();
            }


        }





    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String javascriptUrlUser = "javascript: (function() {document.getElementById('userid').value= '50000005754949';}) ();";
        final String javascriptUrlPass = "javascript: (function() {document.getElementById('password').value= '4949';}) ();";
        final String javascriptUrlLogin ="javascript: (function() {document.getElementsByTagName('input')[9].click();}) ();";


        //final String javascriptURL = "javascript:document.getElementById(\"userid\").value='5';";




        myWebView = new WebView(this);
        //myWebView.getSettings().setJavaScriptEnabled(true);

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

        myWebView.setWebViewClient(new WebViewClient(){




            @Override

            public void onPageFinished(WebView view, String url) {


                if(url.equals("https://camden.bywatersolutions.com/")) {
                    //Toast.makeText(browserWebView.this, "Current Url: " + url, Toast.LENGTH_LONG).show();
                    //myWebView.getSettings().setJavaScriptEnabled(true);
                    view.loadUrl(javascriptUrlUser);
                    view.loadUrl(javascriptUrlPass);
                    view.loadUrl(javascriptUrlLogin);
                }




            }
        });






    }
}
