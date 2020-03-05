package com.example.libraryappversion2.ui.eContent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryappversion2.R;
import com.example.libraryappversion2.RecyclerViewAdapter;
import com.example.libraryappversion2.browserWebView;

import java.util.ArrayList;

public class eContentFragment extends Fragment {

    private com.example.libraryappversion2.ui.eContent.eContentViewModel eContentViewModel;

    private static final String TAG = "eContent";

    //vars
    private ArrayList<String> mPackage = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mLinkUrls = new ArrayList<>();


    WebView webView;
    ActionBar action;













    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing Bitmaps.");



        //mImageUrls.add("https://www.camdencountylibrary.org/sites/default/files/images/staffdayphoto500.jpg");
        //mNames.add("Staff Day");
        //mLinkUrls.add("https://www.camdencountylibrary.org/using-the-library");



        mImageUrls.add("https://lh3.googleusercontent.com/48wwD4kfFSStoxwuwCIu6RdM2IeZmZKfb1ZeQkga0qEf1JKsiD-hK3Qf8qvxHL09lQ=s180");
        mNames.add("Kindle Reader");
        mLinkUrls.add("market://details?id=com.amazon.kindle");
        mPackage.add("com.amazon.kindle");

        mImageUrls.add("https://lh3.googleusercontent.com/XD4PNp-EdVGvrFmvwr9Rt5GoUhcsTszVQPwOUYIbg3WAnh3cPFfEgC6tftiN820rxg4N=s180");
        mNames.add("Kanopy");
        mLinkUrls.add("market://details?id=com.kanopy");
        mPackage.add("com.kanopy");

        mImageUrls.add("https://lh3.googleusercontent.com/6LpW-j_2deNEViHpCtn2HNvGrXL7V4KmqNPuh488iw7Zcf6arhNN8Qu3GXiKphX2dms=s180");
        mNames.add("Hoopla");
        mLinkUrls.add("market://details?id=com.hoopladigital.android");
        mPackage.add("com.hoopladigital.android");

        mImageUrls.add("https://lh3.googleusercontent.com/dr_qIHpWj4Xv0wON0eKPDZQ1HlrANqXpzrHVVKguSSkQ74jbgNVQIlH5lrZZgJP9iOA=s180");
        mNames.add("OverDrive");
        mLinkUrls.add("market://details?id=com.overdrive.mobile.android.mediaconsole");
        mPackage.add("com.overdrive.mobile.android.mediaconsole");

        mImageUrls.add("https://lh3.googleusercontent.com/fsfzoSofx2cyzz-gFSUvSkh1TE9dDJ8lxRfBqykIuSzlfSvbX5SlFg1rXhOKvjkhGjg=s180");
        mNames.add("Libby, by OverDrive");
        mLinkUrls.add("market://details?id=com.overdrive.mobile.android.libby");
        mPackage.add("com.overdrive.mobile.android.libby");


        mImageUrls.add("https://lh3.googleusercontent.com/zXfWbG2f1xbsbRbD5XAkhyTzrbhaH-d_RKmg8TIHGxYDau1YA9tzX68MprnxzeBNLQ=s180");
        mNames.add("RB Digital");
        mLinkUrls.add("market://details?id=com.ocd");
        mPackage.add("com.ocd");

        mImageUrls.add("https://lh3.googleusercontent.com/vpf1uCk2PgjKPihGOVYGnvTYB3JHadRjl2cGj9kUdAntW_sG8MryuaSaJsnPjhErU_av=s180");
        mNames.add("SmartAlec Mobile Printing");
        mLinkUrls.add("market://details?id=comprise.online.smartalec");
        mPackage.add("comprise.online.smartalec");

        mImageUrls.add("https://lh3.googleusercontent.com/gvbeJ4qfEV2dOQoXK_eAPHiPGQ1_raqwloQqgsg-I9kJ8AaYuPW7UcKpq8mbfVIW3hv2=s180");
        mNames.add("Rosetta Stone");
        mLinkUrls.add("market://details?id=air.com.rosettastone.mobile.CoursePlayer");
        mPackage.add("air.com.rosettastone.mobile.CoursePlayer");

        mImageUrls.add("https://drive.google.com/thumbnail?id=1lpUWSphlDx0_isZrqhtY2JAfgPIkx2ZJ");
        mNames.add("CamCat");
        mLinkUrls.add("https://camden.bywatersolutions.com/");
        mPackage.add("No Package");

        //webView = (WebView) findViewById(R.id.webview);

        initRecyclerView();

    }

    public void openBrowser(View view){
        startActivity(new Intent(getContext(), browserWebView.class));

    }

    private void initRecyclerView(){
        action = ((AppCompatActivity)getActivity()).getSupportActionBar();
        //action.hide(); //hide the actionbar

        Log.d(TAG, "initRecyclerView: initrecyclerview");
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), mPackage, mNames, mImageUrls,mLinkUrls, webView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        eContentViewModel =
                ViewModelProviders.of(this).get(com.example.libraryappversion2.ui.eContent.eContentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_econtent, container, false);
        //final TextView textView = root.findViewById(R.id.text_eContent);
        eContentViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d("eContent on create:", s);
                initImageBitmaps();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();

        action.show();


    }
}