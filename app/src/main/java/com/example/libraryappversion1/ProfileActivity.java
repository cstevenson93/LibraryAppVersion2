package com.example.libraryappversion1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    protected final static String NODE_USERS = "users";
    private boolean menuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBar action = getSupportActionBar();

        action.setDisplayShowTitleEnabled(false);


        mAuth = FirebaseAuth.getInstance();



        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {

                        if(task.isSuccessful()){

                            String token = task.getResult().getToken();

                            saveToken(token);


                        }else {

                        }
                    }
                });


    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() == null) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }


    }

    private void saveToken(String token){

        String email = mAuth.getCurrentUser().getEmail();
        User user = new User(email, token);

        DatabaseReference dbUsers = FirebaseDatabase.getInstance().getReference(NODE_USERS);

        dbUsers.child(mAuth.getCurrentUser().getUid())
                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ProfileActivity.this,"Token Saved",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void signOut(View view){
        mAuth.signOut();

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    public void subscribe(View view){

        Toast.makeText(this,getResources().getResourceEntryName(view.getId()) , Toast.LENGTH_LONG).show();

        //Bellmawr
        if(getResources().getResourceEntryName(view.getId()).equals("beSubscribe")){
            subscribeButton("be");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("beChildSubscribe")){
            subscribeButton("beChild");
        }

        //Camden Downtown (Rutgers)
        if(getResources().getResourceEntryName(view.getId()).equals("cdSubscribe")){
            subscribeButton("cd");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("cdChildSubscribe")){
            subscribeButton("cdChild");
        }

        //Camden Ferry
        if(getResources().getResourceEntryName(view.getId()).equals("cfSubscribe")){
            subscribeButton("cf");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("cfChildSubscribe")){
            subscribeButton("cfChild");
        }

        //Gloucester Township
        if(getResources().getResourceEntryName(view.getId()).equals("gtSubscribe")){
            subscribeButton("gt");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("gtChildSubscribe")){
            subscribeButton("gtChild");
        }

        //South County
        if(getResources().getResourceEntryName(view.getId()).equals("scSubscribe")){
            subscribeButton("sc");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("scChildSubscribe")){
            subscribeButton("scChild");
        }

        //Haddon Township
        if(getResources().getResourceEntryName(view.getId()).equals("htSubscribe")){
            subscribeButton("ht");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("htChildSubscribe")){
            subscribeButton("htChild");
        }

        //Merchantville
        if(getResources().getResourceEntryName(view.getId()).equals("meSubscribe")){
            subscribeButton("me");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("meChildSubscribe")){
            subscribeButton("meChild");
        }

        //Voorhees
        if(getResources().getResourceEntryName(view.getId()).equals("vtSubscribe")){
            subscribeButton("vt");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("vtChildSubscribe")){
            subscribeButton("vtChild");
        }
    }

    public void unSubscribe(View view){

        //Bellmawr
        if(getResources().getResourceEntryName(view.getId()).equals("beUnsubscribe")){
            unsubscribeButton("be");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("beChildUnsubscribe")){
            unsubscribeButton("beChild");
        }

        //Camden Downtown (Rutgers)
        if(getResources().getResourceEntryName(view.getId()).equals("cdUnsubscribe")){
            unsubscribeButton("cd");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("cdChildUnsubscribe")){
            unsubscribeButton("cdChild");
        }

        //Camden Ferry
        if(getResources().getResourceEntryName(view.getId()).equals("cfUnsubscribe")){
            unsubscribeButton("cf");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("cfChildUnsubscribe")){
            unsubscribeButton("cfChild");
        }

        //Gloucester Township
        if(getResources().getResourceEntryName(view.getId()).equals("gtUnsubscribe")){
            unsubscribeButton("gt");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("gtChildUnsubscribe")){
            unsubscribeButton("gtChild");
        }

        //South County
        if(getResources().getResourceEntryName(view.getId()).equals("scUnsubscribe")){
            unsubscribeButton("sc");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("scChildUnsubscribe")){
            unsubscribeButton("scChild");
        }

        //Haddon Township
        if(getResources().getResourceEntryName(view.getId()).equals("htUnsubscribe")){
            unsubscribeButton("ht");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("htChildUnsubscribe")){
            unsubscribeButton("htChild");
        }

        //Merchantville
        if(getResources().getResourceEntryName(view.getId()).equals("meUnsubscribe")){
            unsubscribeButton("me");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("meChildUnsubscribe")){
            unsubscribeButton("meChild");
        }

        //Voorhees
        if(getResources().getResourceEntryName(view.getId()).equals("vtUnsubscribe")){
            unsubscribeButton("vt");
        }

        if(getResources().getResourceEntryName(view.getId()).equals("vtChildUnsubscribe")){
            unsubscribeButton("vtChild");
        }







        //
    }

    public void subscribeButton(String branch){
        FirebaseMessaging.getInstance().subscribeToTopic(branch)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Subscribe Successful";
                        if (!task.isSuccessful()) {
                            msg = "Subscribe failed";
                        }
                        Log.d("Subscribe status: ", msg);
                        Toast.makeText(ProfileActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void unsubscribeButton(String branch){
        FirebaseMessaging.getInstance().unsubscribeFromTopic(branch)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Unsubscribe Successful";
                        if (!task.isSuccessful()) {
                            msg = "Unsubscribe failed";
                        }
                        Log.d("Unsubscribe status: ", msg);
                        Toast.makeText(ProfileActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void openMenu(View view){

        Log.i("Menu Button Status: ", "Button Pressed");

        float xTranslation;



        ConstraintLayout container = (ConstraintLayout) findViewById(R.id.frontLayout);
        View navHost =  findViewById(R.id.nav_host_fragment);

        final LinearLayout menuLayout = (LinearLayout) findViewById(R.id.menuLayout);
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);

        //xTranslation = container.getTranslationX();

        xTranslation = menuLayout.getTranslationX();









        if(xTranslation == 0.0){

            menuLayout.setVisibility(View.VISIBLE);
           menuLayout.animate().translationXBy(-750);

            //container.animate().translationXBy(-750);
        }

        if(xTranslation == -750.0){

            menuLayout.animate().translationXBy(750).withEndAction(new Runnable() {
                @Override
                public void run() {
                    menuLayout.setVisibility(View.GONE);
                }
            }).start();


            //container.animate().translationXBy(750);
        }





    }


}
