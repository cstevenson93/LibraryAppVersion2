package com.example.libraryappversion2;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class toolbar_widget extends AppWidgetProvider {

    Context mContext;
    AppWidgetManager mWidgetManager;
    int[] mWidgetIds;





    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {


        mContext = context;
        mWidgetManager = appWidgetManager;
        mWidgetIds = appWidgetIds;

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.toolbar_widget_layout);
        Intent configIntent = new Intent(context, searchActivity.class);

        PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);


        remoteViews.setOnClickPendingIntent(R.id.searchBarTextView, configPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }
}

