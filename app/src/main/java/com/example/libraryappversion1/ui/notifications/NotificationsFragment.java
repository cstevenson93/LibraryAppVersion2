package com.example.libraryappversion1.ui.notifications;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.libraryappversion1.MainActivity;
import com.example.libraryappversion1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    ActionBar action;
    ImageButton dropDownBellmawr;
    ImageButton dropDownCD;
    LinearLayout beLayout;
    LinearLayout cdLayout;
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


        dropDownBellmawr = (ImageButton) root.findViewById(R.id.dropDownBellmawr);

        dropDownCD = (ImageButton) root.findViewById(R.id.dropDownCamdenDowntown);

        beLayout = (LinearLayout) root.findViewById(R.id.beLayout);

        cdLayout = (LinearLayout) root.findViewById(R.id.cdLayout);



        dropDownBellmawr.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("Button Clicked: ", "True");


                if(beLayout.getVisibility() == View.GONE){

                    dropDownBellmawr.setImageResource(android.R.drawable.arrow_up_float);

                    beLayout.setVisibility(View.VISIBLE);


                    Log.i("Layout visibility: ", Integer.toString(beLayout.getVisibility()));
                } else {

                    if (beLayout.getVisibility() == View.VISIBLE) {

                        dropDownBellmawr.setImageResource(android.R.drawable.arrow_down_float);



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
        return root;
    }





}