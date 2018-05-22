package com.nust.carloss.wbcgdemoapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map1);
        if(mapFragment == null){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map1, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng start = new LatLng(-22.946184, 14.509871);
        MarkerOptions op = new MarkerOptions();
        op.position(start).title("Walvis Bay");
        map.addMarker(op);
        map.moveCamera(CameraUpdateFactory.newLatLng(start));
    }
}
