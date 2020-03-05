package com.example.libraryappversion2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.libraryappversion2.R;

public class HomeFragment extends Fragment {

    ActionBar action;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        //homeViewModel.getText().observe(this, new Observer<String>() {
        //    @Override
         //   public void onChanged(@Nullable String s) {
         //       textView.setText(s);
        //    }
        //});

        action = ((AppCompatActivity)getActivity()).getSupportActionBar();

        action.setTitle("Home"); //sets actionBar title to Home
        return root;
    }


}