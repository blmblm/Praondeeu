package br.com.praondeeu.praondeeu;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private double latitude;
    private double longitude;
    public String id, categ, latit, longit, url;

    private String HOST = "http://192.168.15.9/webservices";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_maps );


        Intent intent = getIntent ();
        final String id = (String) intent.getStringExtra ( "ID" );
        final String tp = (String) intent.getStringExtra ( "CATEG" );
        if ( tp.equals ( "1" ) ) {
            url = HOST + "/mapaBaile.php";
        }
        if ( tp.equals ( "2" ) ) {
            url = HOST + "/mapaSamba.php";
        }
        if ( tp.equals ( "3" ) ) {
            url = HOST + "/mapaBalada.php";
        }
        if ( tp.equals ( "4" ) ) {
            url = HOST + "/mapaCinema.php";
        }
        if ( tp.equals ( "5" ) ) {
            url = HOST + "/mapaEsporte.php";
        }
        if ( tp.equals ( "6" ) ) {
            url = HOST + "/mapaFeira.php";
        }
        if ( tp.equals ( "7" ) ) {
            url = HOST + "/mapaPasseio.php";
        }
        if ( tp.equals ( "8" ) ) {
            url = HOST + "/mapaParque.php";
        }
        if ( tp.equals ( "9" ) ) {
            url = HOST + "/mapaGastronomia.php";
        }
        if ( tp.equals ( "10" ) ) {
            url = HOST + "/mapaShow.php";
        }
        if ( tp.equals ( "10" ) ) {
            url = HOST + "/mapaTeatro.php";
        }
        if ( tp.equals ( "12" ) ) {
            url = HOST + "/mapaBeleza.php";
        }
        //   progresso.hide ();
        Ion.with ( getBaseContext () )

                .load ( url )
                .setBodyParameter ( "ID", id )
                .asJsonArray ()
                .setCallback ( new FutureCallback <JsonArray> () {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if ( result.size () > 0 ) {
                            for (int i = 0; i < result.size (); i++) {
                                JsonObject obj = result.get ( i ).getAsJsonObject ();

                                tabEvento c = new tabEvento ();

                                c.setLatitude ( obj.get ( "latitude" ).getAsString () );
                                c.setLongitude ( obj.get ( "longitude" ).getAsString () );

                                final String latit = c.getLatitude ();
                                final String longit = c.getLongitude ();

                                latitude = Double.parseDouble ( latit );
                                longitude = Double.parseDouble ( longit );
                            }
                            int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable ( getApplicationContext () );

                            if ( status == ConnectionResult.SUCCESS ) {
                                // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager ()
                                        .findFragmentById ( R.id.map );
                                mapFragment.getMapAsync ( MapsActivity.this );
                            } else {
                                Dialog dialog = GooglePlayServicesUtil.getErrorDialog ( status, (Activity) getApplicationContext (), 10 );
                                dialog.show ();
                            }



                        }


                    }
                } );

    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType ( GoogleMap.MAP_TYPE_NORMAL );
        UiSettings uiSettings = mMap.getUiSettings ();
        uiSettings.setZoomControlsEnabled ( true );
        // mMap = googleMap;
        // mMap.setMapType(4);
        // UiSettings uiSettings = mMap.getUiSettings ();
        // mMap.getUiSettings ().setZoomControlsEnabled ( true );

        //  mMap.setOnMapClickListener ( (GoogleMap.OnMapClickListener) MapsActivity.this );
        //  mMap.getUiSettings ().setZoomControlsEnabled ( true );


        // Add a marker in Sydney and move the camera
        //      LatLng sydney = new LatLng ( -23.4947605, -46.399744 );
        LatLng sydney = new LatLng ( latitude, longitude );
        mMap.addMarker ( new MarkerOptions ().position ( sydney ).title ( "Local do Evento" ) );
        mMap.moveCamera ( CameraUpdateFactory.newLatLng ( sydney ) );
    }
}
