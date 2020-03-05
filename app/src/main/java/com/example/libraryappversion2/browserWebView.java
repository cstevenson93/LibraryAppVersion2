package com.example.libraryappversion2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

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

            //setContentView(myWebView);
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
        setContentView(R.layout.activity_browser);

        final String origin = getIntent().getExtras().get("origin").toString();

        Log.i("ORIGIN KEY:  ", origin);

        //eContent Process

            final String javascriptUrlUser = "javascript: (function() {document.getElementById('userid').value= '50000005754949';}) ();";
            final String javascriptUrlPass = "javascript: (function() {document.getElementById('password').value= '4949';}) ();";
            final String javascriptUrlLogin = "javascript: (function() {document.getElementsByTagName('input')[9].click();}) ();";






            myWebView = (WebView) findViewById(R.id.catWebView);



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




            launchPage(myWebView);

            myWebView.setWebViewClient(new WebViewClient() {





                @Override

                public void onPageFinished(WebView view, String url) {

                    Log.i("Current URL: ", url);


                    if (url.contains("https://camden.bywatersolutions.com/")) {
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

                @Override
                public void onPageCommitVisible (WebView view, String url){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ProgressBar progressBar = (ProgressBar) findViewById(R.id.catProgressBar);

                            myWebView.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                        }
                    }, 3500);
                }

            });






    }
}
