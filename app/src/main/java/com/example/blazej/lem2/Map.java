package com.example.blazej.lem2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;


/**
 * Created by blazej on 15.08.14.
 */
public class Map extends Fragment {

    MapView mapView;
    GoogleMap map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.map, container, false);

        MapsInitializer.initialize(getActivity());

        if (savedInstanceState == null) {
            Log.i("mapy", "jest null");
        } else {
            Log.i("mapy", "jest ok");
        }

        switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) )
        {
            case ConnectionResult.SUCCESS:
                Toast.makeText(getActivity(), "SUCCESS", Toast.LENGTH_SHORT).show();
                mapView = (MapView) rootView.findViewById(R.id.map);
                mapView.onCreate(savedInstanceState);
                // Gets to GoogleMap from the MapView and does initialization stuff
                if(mapView!=null)
                {
                    map = mapView.getMap();
                    map.getUiSettings().setMyLocationButtonEnabled(false);
                    map.setMyLocationEnabled(true);
                    //CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(43.1, -87.9), 10);
                    //map.animateCamera(cameraUpdate);
                }
                break;
            case ConnectionResult.SERVICE_MISSING:
                Toast.makeText(getActivity(), "SERVICE MISSING", Toast.LENGTH_SHORT).show();
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                Toast.makeText(getActivity(), "UPDATE REQUIRED", Toast.LENGTH_SHORT).show();
                break;
            default: Toast.makeText(getActivity(), GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()), Toast.LENGTH_SHORT).show();
        }


        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("mapy", "onCreate");
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Log.i("mapy", "jest null2");
        } else {
            Log.i("mapy", "jest ok2");
        }
    }



    @Override
    public void onResume() {
        Log.i("mapy", "onResume");
        mapView.onResume();
        super.onResume();
    }
    @Override
    public void onDestroy() {
        Log.i("mapy", "onDestroy");
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    public void onLowMemory() {
        Log.i("mapy", "onLowMemory");
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onStop() {
        Log.i("mapy", "onStop");
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        Log.i("mapy", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }


}
