package com.hoangquangdev;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    SupportMapFragment mapFragment;
    Spinner sp_spinner;

    // Database
    String DB_NAME = "testt.db";
    private String DB_PATH = "/databases/";
    SQLiteDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        addControls();
        addEvents();
        processCopyDatabase2Assets();
    }

    private void addEvents() {
        sp_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        break;
                    case 1:
                        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        break;
                    case 2:
                        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        break;
                    case 3:
                        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void addControls() {
        sp_spinner = findViewById(R.id.spinner2);

        ArrayList<String> ds_StyleMap = new ArrayList<>();
        ds_StyleMap.add("Style 1");
        ds_StyleMap.add("Style 2");
        ds_StyleMap.add("Style 3");
        ds_StyleMap.add("Style 4");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ds_StyleMap);
        sp_spinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

//        //Bật nút zoomout/zoomin
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // Tạo vị  trí
        LatLng latLng1 = new LatLng(10.9530, 106.8022);
        LatLng latLng2 = new LatLng(10.9551, 106.8021);
        LatLng latLng3 = new LatLng(10.9551, 106.8021);
        LatLng latLng4 = new LatLng(10.9560, 106.7981);
        LatLng latLng5 = new LatLng(10.9544, 106.7970);
        // Vẽ polygon
        PolygonOptions polygonOptions= new PolygonOptions()
                .add(latLng1).add(latLng2).add(latLng3).add(latLng4).add(latLng5).add(latLng1)
                .strokeColor(Color.RED)
                .fillColor(Color.YELLOW)
                .strokeWidth(20);
        Polygon polygon = mMap.addPolygon(polygonOptions);
        //Phóng to bản đồ
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng1,15));
        dsViTri();
    }
    private void processCopyDatabase2Assets() {
        File dbFile = getDatabasePath(DB_NAME);
        // Check if exists
        if (!dbFile.exists()) {
            copyDatabase();
            Toast.makeText(this, "Dữ liệu được sao chép thành công!", Toast.LENGTH_SHORT).show();
        } else {
            dbFile.delete();
            copyDatabase();
        }
    }
    private void copyDatabase() {
        try {
            InputStream myInput = getAssets().open(DB_NAME);
            String outFileName = getApplicationInfo().dataDir + DB_PATH + DB_NAME;
            File f = new File(getApplicationInfo().dataDir + DB_PATH);
            if (!f.exists()) {
                f.mkdir();
            }

            OutputStream myOutPut = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = myInput.read(buffer)) > 0) {
                myOutPut.write(buffer, 0, len);
            }

            myOutPut.flush();
            myInput.close();
            myOutPut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.e("Lỗi sao chép:", ex.toString());
        }
    }

    private void dsViTri() {
        // Open database
        database = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        // Raw query
        Cursor cursor = database.query("db_vitri", null, null, null, null, null, null);
        // Clear data arrList
//        dsSong.clear();

        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String title = cursor.getString(1);
            String latitude = String.valueOf(cursor.getDouble(2));
            String longtitude = String.valueOf(cursor.getDouble(3));

            System.out.println("Tên: "+name+" - title: "+title+" - latitude: "+latitude+" - Longtitude: "+longtitude);
        }
        cursor.close();
//        adapterList = new AdapterList(getActivity(), R.layout.item, dsSong);
//        lv_item.setAdapter(adapterList);
//        adapterList.notifyDataSetChanged();
    }
}
