package com.hoangquangdev;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.NhanVien_Adapter;
import model.NhanVien;

public class MainAppNhanVien extends AppCompatActivity {
    ListView lvHienThi;
    ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
    NhanVien_Adapter nhanVien_adapter;
    Button btnThem, btnXoa;
    EditText txtTen,txtMa;
    RadioButton rbNam;
    boolean gioTinh = true;


    public static ArrayList<Integer>vitri = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_quanlynhanvien);
        addcontroll();
        addevent();

    }

    private void addcontroll() {
        btnThem = (Button)findViewById(R.id.btn_Them);
        btnXoa = (Button)findViewById(R.id.btn_Xoa);
        txtMa = (EditText)findViewById(R.id.txt_NhapMaNV);
        txtTen = (EditText)findViewById(R.id.txt_NhapTenNV);
        rbNam = (RadioButton)findViewById(R.id.rbtn_Nam);

        lvHienThi=findViewById(R.id.lv_HienThi);

        dsNhanVien.add(new NhanVien(01,"Nguyễn Hoàng Quang",true));
        dsNhanVien.add(new NhanVien(02,"Lê Văn Thái",true));
        dsNhanVien.add(new NhanVien(03,"Phạm Thành Thắng",true));
        dsNhanVien.add(new NhanVien(04,"Lê Thị Kiều Quanh",false));
        dsNhanVien.add(new NhanVien(05,"Hoàng Mạnh Hùng",true));
        dsNhanVien.add(new NhanVien(06,"Nguyễn Thị BƯỞI",false));
        nhanVien_adapter = new NhanVien_Adapter(
                MainAppNhanVien.this,R.layout.view_nhanvien,dsNhanVien
        );
        lvHienThi.setAdapter(nhanVien_adapter);
    }
    private void addevent(){
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!vitri.isEmpty()){
                    for (int k :vitri){
                        dsNhanVien.remove(k);
                    }
                    vitri.clear();
                    nhanVien_adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(MainAppNhanVien.this, "Chưa chọn nhân viên để xóa", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbNam.isChecked()) {
                    gioTinh = true;
                }else {
                    gioTinh = false;
                }
                dsNhanVien.add(new NhanVien(Integer.parseInt(txtMa.getText().toString()),txtTen.getText().toString(),gioTinh));
                nhanVien_adapter.notifyDataSetChanged();
                txtMa.setText("");
                txtTen.setText("");


            }
        });
    }
//mã t kieur int

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Quản Lý Nhân Viên");

        return super.onCreateOptionsMenu(menu);
    }
}