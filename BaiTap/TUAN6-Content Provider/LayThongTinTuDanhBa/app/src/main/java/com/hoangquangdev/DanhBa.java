package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.hoangquangdev.moder.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSIONS =1001;

    ListView lv_danhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        addcontroll();
        showallContacFromDevice();
    }

    private void showallContacFromDevice() {
//Thông qua Contacscontract dể lấy conTract trong điện thoại
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
//Trả về 1 cursor - quản lý dữ liểu contract trong điện thoại
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        dsDanhBa.clear();
        while (cursor.moveToNext()){
            //lấy thông tin tên trong danh bạ
            String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
            //lấy thông tiên sdt trong danh bạ
            String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            //lấy vtri cột trong dữ liệu
            int viTricotName = cursor.getColumnIndex(tenCotName);
            int viTriCotPhone = cursor.getColumnIndex(tenCotPhone);
            // lấy dữ liệu trong các côt ra
            String name = cursor.getString(viTricotName);
            String phone = cursor.getString(viTriCotPhone);
            //đưa vảo mảng
            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
            adapterDanhBa.notifyDataSetChanged();
        }
    }

    private void addcontroll() {
        lv_danhBa = findViewById(R.id.lv_danhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(DanhBa.this, android.R.layout.simple_list_item_1 , dsDanhBa);
        lv_danhBa.setAdapter(adapterDanhBa);
    }



}