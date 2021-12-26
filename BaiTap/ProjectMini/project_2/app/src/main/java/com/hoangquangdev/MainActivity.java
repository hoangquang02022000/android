package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import apdater.BaiHat_apdater;
import mode.BaiHat;

public class MainActivity extends AppCompatActivity {
    //

    ListView lv_dsBHLike,listView;
    ArrayList<BaiHat> lstbh , lstnhyt;
    BaiHat_apdater apdaterbh , apdaterbhyt ;

    String db_Name = "Arirang.sqlite";
    private String db_Path = "/databases/";
    SQLiteDatabase database = null;

    //
    TabHost tabHost;
    ImageButton img_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saochepCSDL();
        addcontroll();
        showdata();
    }

    private void addcontroll() {
        lstbh = new ArrayList<>();
        lstnhyt = new ArrayList<>();

        listView = findViewById(R.id.lv_hienthiBH);
        lv_dsBHLike = findViewById(R.id.lv_dsBHLike);
        img_btn =(ImageButton)findViewById(R.id.imageButton);
        tabHost = findViewById(R.id.TabHost);
        tabHost.setup();
        creatTab();
        createListView();

    }

    private void creatTab()
    {
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Bài Hát");
        tabHost.addTab(tabSpec1);
        //
        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Yêu Thích");
        tabHost.addTab(tabSpec2);
        //



    }

    private void createListView() {
        apdaterbh = new BaiHat_apdater(
                MainActivity.this, R.layout.view_bai_hat, lstbh
        );
        listView.setAdapter(apdaterbh);

        apdaterbhyt = new BaiHat_apdater(
                MainActivity.this, R.layout.view_bai_hat, lstnhyt
        );
        lv_dsBHLike.setAdapter(apdaterbhyt);
    }

    //
    private void saochepCSDL() {
        File dBFile = getDatabasePath(db_Name);

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
            InputStream myInput = getAssets().open(db_Name);
            String outFile = getApplicationInfo().dataDir+db_Path+db_Name;
            File f = new File(getApplicationInfo().dataDir+db_Path);
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
    // show dâta

    private void showdata() {
        database=openOrCreateDatabase(db_Name,MODE_PRIVATE,null);
        Cursor cursor = database.query("ArirangSongList", null, null, null, null, null, null);
        lstbh.clear();
        while (cursor.moveToNext()){
            String maBH = cursor.getString(0);
            String tenBH= cursor.getString(1);
            String loiBH = cursor.getString(2);
            String tenCS = cursor.getString(3);
            String theLoai = cursor.getString(4);
            int yeuThich = cursor.getInt(5);
            int stt = cursor.getInt(6);

            lstbh.add(new BaiHat(maBH, tenBH,loiBH,tenCS,theLoai,yeuThich,stt));
        }
        cursor.close();
        apdaterbh.notifyDataSetChanged();
    }
    public void updateFavouriteList() {
        lstnhyt.clear();
        for (BaiHat song : lstbh) {
            if (song.getYt() == 1) {
                lstnhyt.add(song);
            }
        }
        apdaterbhyt.notifyDataSetChanged();
        apdaterbh.notifyDataSetChanged();
    }


}