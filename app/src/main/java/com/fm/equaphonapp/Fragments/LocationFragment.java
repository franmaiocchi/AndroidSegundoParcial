package com.fm.equaphonapp.Fragments;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fm.equaphonapp.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment implements OnMapReadyCallback
{
    private GoogleMap mapa;

    public LocationFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap map)
    {
        mapa = map;

        mapa.getUiSettings().setZoomControlsEnabled(true);

        CameraUpdate camUpd1 =
                CameraUpdateFactory
                        .newLatLngZoom(new LatLng(-34.60711390821141, -58.44447813928127), 11);

        mapa.moveCamera(camUpd1);

        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-34.6008788, -58.4698083))
                .title("Espinosa 2539 (C1416CFC)")
                .snippet("+54-11-4588-0568\n" +
                        "CABA, ARGENTINA\n" +
                        "info@equaphon.net\n" +
                        "Producción, Departamento de Ingeniería, Soporte de Producto, Expedición, Deposito."));

        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-34.5936894, -58.4990952))
                .title("Gutenberg 2976 (C1419IDH)")
                .snippet("+54-11-4503-5750\n" +
                        "CABA, ARGENTINA\n" +
                        "info@equaphon.net\n" +
                        "Administración, Comercialización, Servicio Técnico, Escuela DiGiCo, Prensa y Comunicación."));

        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-34.6070129, -58.3899137))
                .title("Paraná 147 (C1017AAC)")
                .snippet("+54-11-4372-7236 \n" +
                        "CABA, ARGENTINA \n" +
                        "parana@equaphon.net \n" +
                        "Laboratorio de Mercado, Comercialización, Tienda Online."));

        mapa.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter()
        {
            @Override
            public View getInfoWindow(Marker marker)
            {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker)
            {
                LinearLayout info = new LinearLayout(getContext());
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(getContext());
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(getContext());
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });
    }



}
