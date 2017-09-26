package com.example.aluno.trabalhobom;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by Aluno on 26/09/2017.
 */

public class GPSt implements LocationListener {
    Context context;



    public GPSt (Context c){
        context = c;


    }

    public Location getLocalizacao(){
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context, "Permissão não aceita", Toast.LENGTH_SHORT).show();
            return null;
        }
        LocationManager lm = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        boolean isGPSAtivado = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(isGPSAtivado){
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10,this);
            Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return l;

        }else {
            Toast.makeText(context, "Por favor. coloque a localização", Toast.LENGTH_LONG).show();
        }
        return null;

    }
    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
