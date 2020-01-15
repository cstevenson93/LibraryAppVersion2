package com.example.libraryappversion1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mLinkUrls = new ArrayList<>();
    private ArrayList<String> mPackages = new ArrayList<>();
    private Context mContext;
    private WebView webView;




    public RecyclerViewAdapter(Context mContext, ArrayList<String> mPackageName, ArrayList<String> mImageName, ArrayList<String> mImages, ArrayList<String> mLinks, WebView inWebView) {
        this.mImageNames = mImageName;
        this.mImages = mImages;
        this.mLinkUrls = mLinks;
        this.mPackages = mPackageName;
        this.mContext = mContext;
        this.webView = inWebView;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");



        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));
                Intent browser = new Intent(mContext, browserWebView.class);
                browser.putExtra("url", mLinkUrls.get(position));
                browser.putExtra("package", mPackages.get(position));
                mContext.startActivity(browser) ;




                //webView.loadUrl(mLinkUrls.get(position));



            }
        });

    }





    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
