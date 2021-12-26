package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import apdater.BaiHat_apdater;
import mode.BaiHat;

public class MainActivity extends AppCompatActivity {
    //

    ListView lv_dsBHLike;
    ArrayList<BaiHat> dsbaihatyt = new ArrayList<>();
//    ArrayAdapter<BaiHat> adapterBHYT ;
    //
    TabHost tabHost;
    ListView listView;
    ArrayList<BaiHat> dsBaiHat = new ArrayList<>();
    BaiHat_apdater apdater , apdaterLike;
    ImageButton img_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontroll();

        addbaiHatYeuthich();
    }

    private void addcontroll() {
        lv_dsBHLike = findViewById(R.id.lv_dsBHLike);
        img_btn =(ImageButton)findViewById(R.id.imageButton);
        tabHost = findViewById(R.id.TabHost);
        tabHost.setup();
        creatTab();
    }

    private void creatTab() {
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Bài Hát");
        tabHost.addTab(tabSpec1);

        listView = findViewById(R.id.lv_hienthiBH);
        dsBaiHat.add(new BaiHat(R.drawable.hoamay,"Họa Mây","Hoàng Quang",true));
        dsBaiHat.add(new BaiHat(R.drawable.yeulacuoi,"Yêu là cưới","Mạnh Hùng",false));
        dsBaiHat.add(new BaiHat(R.drawable.phuduyen,"Phụ duyên","Văn Thái",true));
        dsBaiHat.add(new BaiHat(R.drawable.phuduyen,"Yêu đơn phương","Thành Thắng",false));
        apdater= new BaiHat_apdater(
                this,R.layout.view_bai_hat,dsBaiHat
        );
        listView.setAdapter(apdater);
        apdater.notifyDataSetChanged();

        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Yêu Thích");
        tabHost.addTab(tabSpec2);


    }

    private void addbaiHatYeuthich() {
        dsbaihatyt.clear();
        for (BaiHat baiHat: dsBaiHat) {
            if (baiHat.isState()){
                dsbaihatyt.add(baiHat);
            }
        }
        lv_dsBHLike = findViewById(R.id.lv_dsBHLike);
        apdaterLike = new BaiHat_apdater(
                this,R.layout.view_bai_hat,dsbaihatyt
        );
        lv_dsBHLike.setAdapter(apdaterLike);

        apdaterLike.notifyDataSetChanged();
        apdater.notifyDataSetChanged();
    }

}