package com.example.libraryappversion1.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.libraryappversion1.R;


public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    ActionBar action;

    ImageButton dropDownBE;
    ImageButton dropDownCD;
    ImageButton dropDownCF;
    ImageButton dropDownGT;
    ImageButton dropDownSC;
    ImageButton dropDownHT;
    ImageButton dropDownME;
    ImageButton dropDownVT;


    LinearLayout beLayout;
    LinearLayout cdLayout;
    LinearLayout cfLayout;
    LinearLayout gtLayout;
    LinearLayout scLayout;
    LinearLayout htLayout;
    LinearLayout meLayout;
    LinearLayout vtLayout;


    private String branch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        action = ((AppCompatActivity)getActivity()).getSupportActionBar();

        action.setTitle("Notifications"); //sets actionBar title to Notifications

        //Initializing dropdown Image buttons on each branch's menu
        dropDownBE = (ImageButton) root.findViewById(R.id.dropDownBellmawr);

        dropDownCD = (ImageButton) root.findViewById(R.id.dropDownCamdenDowntown);

        dropDownCF = (ImageButton) root.findViewById(R.id.dropDownCF);

        dropDownGT = (ImageButton) root.findViewById(R.id.dropDownGloucesterTownship);

        dropDownSC = (ImageButton) root.findViewById(R.id.dropDownSouthCounty);

        dropDownHT = (ImageButton) root.findViewById(R.id.dropDownHaddonTownship);

        dropDownME = (ImageButton) root.findViewById(R.id.dropDownMerchantville);

        dropDownVT = (ImageButton) root.findViewById(R.id.dropDownVoorhees);


        //Initializing the layouts the contained each topic to subscribe to
        beLayout = root.findViewById(R.id.beLayout);

        cdLayout = root.findViewById(R.id.cdLayout);

        cfLayout = root.findViewById(R.id.cfLayout);

        gtLayout = root.findViewById(R.id.gtLayout);

        scLayout = root.findViewById(R.id.scLayout);

        htLayout = root.findViewById(R.id.htLayout);

        meLayout = root.findViewById(R.id.meLayout);

        vtLayout = root.findViewById(R.id.vtLayout);



        dropDownBE.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("Button Clicked: ", "True");


                if(beLayout.getVisibility() == View.GONE){

                    dropDownBE.setImageResource(android.R.drawable.arrow_up_float);

                    beLayout.setVisibility(View.VISIBLE);


                    Log.i("Layout visibility: ", Integer.toString(beLayout.getVisibility()));
                } else {

                    if (beLayout.getVisibility() == View.VISIBLE) {

                        dropDownBE.setImageResource(android.R.drawable.arrow_down_float);



                        beLayout.setVisibility(View.GONE);



                        Log.i("Layout visibility: ", Integer.toString(beLayout.getVisibility()));
                    }
                    }

            }
        });


        dropDownCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Button Clicked: ", "True");




                if(cdLayout.getVisibility() == View.GONE){

                    dropDownCD.setImageResource(android.R.drawable.arrow_up_float);

                    cdLayout.setVisibility(View.VISIBLE);






                    Log.i("Layout visibility: ", Integer.toString(cdLayout.getVisibility()));
                } else {

                    if (cdLayout.getVisibility() == View.VISIBLE) {

                        dropDownCD.setImageResource(android.R.drawable.arrow_down_float);

                        cdLayout.setVisibility(View.GONE);




                        Log.i("Layout visibility: ", Integer.toString(cdLayout.getVisibility()));
                    }
            }
        }

        });


        dropDownCF.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("Button Clicked: ", "True");


                if(cfLayout.getVisibility() == View.GONE){

                    dropDownCF.setImageResource(android.R.drawable.arrow_up_float);

                    cfLayout.setVisibility(View.VISIBLE);


                    Log.i("Layout visibility: ", Integer.toString(cfLayout.getVisibility()));
                } else {

                    if (cfLayout.getVisibility() == View.VISIBLE) {

                        dropDownCF.setImageResource(android.R.drawable.arrow_down_float);



                        cfLayout.setVisibility(View.GONE);



                        Log.i("Layout visibility: ", Integer.toString(cfLayout.getVisibility()));
                    }
                }

            }
        });


        dropDownGT.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("Button Clicked: ", "True");


                if(gtLayout.getVisibility() == View.GONE){

                    dropDownGT.setImageResource(android.R.drawable.arrow_up_float);

                    gtLayout.setVisibility(View.VISIBLE);


                    Log.i("Layout visibility: ", Integer.toString(gtLayout.getVisibility()));
                } else {

                    if (gtLayout.getVisibility() == View.VISIBLE) {

                        dropDownGT.setImageResource(android.R.drawable.arrow_down_float);



                        gtLayout.setVisibility(View.GONE);



                        Log.i("Layout visibility: ", Integer.toString(gtLayout.getVisibility()));
                    }
                }

            }
        });

        dropDownSC.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("Button Clicked: ", "True");


                if(scLayout.getVisibility() == View.GONE){

                    dropDownSC.setImageResource(android.R.drawable.arrow_up_float);

                    scLayout.setVisibility(View.VISIBLE);


                    Log.i("Layout visibility: ", Integer.toString(scLayout.getVisibility()));
                } else {

                    if (scLayout.getVisibility() == View.VISIBLE) {

                        dropDownSC.setImageResource(android.R.drawable.arrow_down_float);



                        scLayout.setVisibility(View.GONE);



                        Log.i("Layout visibility: ", Integer.toString(scLayout.getVisibility()));
                    }
                }

            }
        });

        dropDownHT.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("Button Clicked: ", "True");


                if(htLayout.getVisibility() == View.GONE){

                    dropDownHT.setImageResource(android.R.drawable.arrow_up_float);

                    htLayout.setVisibility(View.VISIBLE);


                    Log.i("Layout visibility: ", Integer.toString(htLayout.getVisibility()));
                } else {

                    if (htLayout.getVisibility() == View.VISIBLE) {

                        dropDownHT.setImageResource(android.R.drawable.arrow_down_float);



                        htLayout.setVisibility(View.GONE);



                        Log.i("Layout visibility: ", Integer.toString(htLayout.getVisibility()));
                    }
                }

            }
        });

        dropDownME.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("Button Clicked: ", "True");


                if(meLayout.getVisibility() == View.GONE){

                    dropDownME.setImageResource(android.R.drawable.arrow_up_float);

                    meLayout.setVisibility(View.VISIBLE);


                    Log.i("Layout visibility: ", Integer.toString(meLayout.getVisibility()));
                } else {

                    if (meLayout.getVisibility() == View.VISIBLE) {

                        dropDownME.setImageResource(android.R.drawable.arrow_down_float);



                        meLayout.setVisibility(View.GONE);



                        Log.i("Layout visibility: ", Integer.toString(meLayout.getVisibility()));
                    }
                }

            }
        });

        dropDownVT.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("Button Clicked: ", "True");


                if(vtLayout.getVisibility() == View.GONE){

                    dropDownVT.setImageResource(android.R.drawable.arrow_up_float);

                    vtLayout.setVisibility(View.VISIBLE);


                    Log.i("Layout visibility: ", Integer.toString(vtLayout.getVisibility()));
                } else {

                    if (vtLayout.getVisibility() == View.VISIBLE) {

                        dropDownVT.setImageResource(android.R.drawable.arrow_down_float);



                        vtLayout.setVisibility(View.GONE);



                        Log.i("Layout visibility: ", Integer.toString(vtLayout.getVisibility()));
                    }
                }

            }
        });

        return root;
    }







}