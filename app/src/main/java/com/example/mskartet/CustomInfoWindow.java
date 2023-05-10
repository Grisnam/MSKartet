package com.example.mskartet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
public class CustomInfoWindow implements GoogleMap.InfoWindowAdapter {
    private Context context;
    private InfoWindowData data;

    public CustomInfoWindow(Context context) {
        this.context = context;
    }

    public void setData(InfoWindowData data) {
        this.data = data;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);

        TextView textView = view.findViewById(R.id.textView);
        textView.setText(data.getText());

        return view;
    }
}