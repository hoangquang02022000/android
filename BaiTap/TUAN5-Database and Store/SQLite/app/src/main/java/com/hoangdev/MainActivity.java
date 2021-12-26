package com.hoangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_Them , btn_Sua , btn_Xoa;
    ListView lv_HienThi;
    ArrayList<String>ArrDanhBa;
    ArrayAdapter<String>adapterDB;
    String DB_Name = "dbnv.db";
    private String DB_path = "/databases/";
    SQLiteDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saochepCSDL();
        addcontroll();
        showdata();

        addevent();


    }

    private void showdata() {
        database=openOrCreateDatabase(DB_Name,MODE_PRIVATE,null);
        Cursor cursor = database.query("nhanvien",null,null,null,null,null,null);
        ArrDanhBa.clear();
        while (cursor.moveToNext()){
            int maNV = cursor.getInt(0);
            String tenNV = cursor.getString(1);
            String phone = cursor.getString(2);

            ArrDanhBa.add(maNV+"-"+tenNV+"-"+phone);
        }
        cursor.close();
        adapterDB.notifyDataSetChanged();
    }

    private void addevent() {
        btn_Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyXoa();
            }
        });
        btn_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulySua();
            }


        });
        btn_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyThem();
            }


        });
    }

    private void xulyXoa() {
        database.delete("nhanvien","maNV=?",new String[]{"6"});
        showdata();
    }
    private void xulySua() {
        ContentValues row = new ContentValues();
        row.put("tenNV","Quang nè");
        database.update("nhanvien",row,"maNV=?", new String[]{"2"});
        showdata();
    }
    private void xulyThem() {
        ContentValues row = new ContentValues();
        row.put("maNV","006");
        row.put("tenNV","văn thái");
        row.put("phone","096123388");
        long r = database.insert("nhanvien",null,row);
        Toast.makeText(this, "bạn vừa thêm", Toast.LENGTH_SHORT).show();
        showdata();
    }
    private void saochepCSDL() {
        File dBFile = getDatabasePath(DB_Name);

        if (!dBFile.exists()){
            coppDatabase();
        }
        else {
            dBFile.delete();
            coppDatabase();
        }
    }

    private void coppDatabase() {
        try {
            InputStream myInput = getAssets().open(DB_Name);
            String outFile = getApplicationInfo().dataDir+DB_path+DB_Name;
            File f = new File(getApplicationInfo().dataDir+DB_path);
            if (!f.exists()){
                f.mkdir();
            }

            OutputStream myOutputStream = new FileOutputStream(outFile);
            byte[] bytes= new byte[1024];
            int len;

            while ((len = myInput.read(bytes))>0){
                myOutputStream.write(bytes,0,len);
            }
            myOutputStream.flush();
            myInput.close();
            myOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("lỗi sao chép",e.toString());
        }
    }

    private void addcontroll() {
        btn_Them = (Button) findViewById(R.id.btn_Them);
        btn_Sua = (Button) findViewById(R.id.btn_Sua);
        btn_Xoa = (Button) findViewById(R.id.btn_Xóa);
        lv_HienThi =(ListView) findViewById(R.id.lv_HienThi);

        ArrDanhBa = new ArrayList<>();
        adapterDB = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,ArrDanhBa);
        lv_HienThi.setAdapter(adapterDB);
    }
}