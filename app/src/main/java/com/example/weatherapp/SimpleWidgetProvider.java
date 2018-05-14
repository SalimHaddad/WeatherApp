package com.example.weatherapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.RemoteViews;

import com.example.weatherapp.api.weather.WeatherApiManager;
import com.example.weatherapp.screens.MainActivity;

import java.util.Random;

/**
 * Created by salimhaddad on 5/14/18.
 */

public class SimpleWidgetProvider extends AppWidgetProvider {

    private WeatherApiManager weatherApiManager;
    private Double latitude, longitude;
    private LocationManager locationManager;


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds)
        {
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.weather_widget);

            views.setOnClickPendingIntent(R.id.actionButton, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);

        }

    }
}
