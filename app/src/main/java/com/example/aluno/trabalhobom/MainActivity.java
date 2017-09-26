package com.example.aluno.trabalhobom;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLocalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLocalizar = (Button)findViewById(R.id.btnLocalizar);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);

        btnLocalizar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                GPSt g = new GPSt( getApplicationContext());
                Location l = g.getLocalizacao();
                if(l !=null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: "+lat+" \n LON:"+lon, Toast.LENGTH_LONG).show();
                }


            }
                                         }



        );

    }
}
