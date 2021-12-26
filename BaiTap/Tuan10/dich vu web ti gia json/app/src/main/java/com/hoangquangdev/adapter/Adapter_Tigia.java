package com.hoangquangdev.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hoangquangdev.R;
import com.hoangquangdev.model.Tigia_json;

import java.util.List;

public class Adapter_Tigia extends ArrayAdapter<Tigia_json> {
    // Màn hình sử dụng layout này (giao diện này)
    Activity context;
    // Layout cho từng dòng muốn hiện thị, chinh là item
    int resource;
    //danh sách nguồn dữ liệu muốn hiện thị trên màn hình
    List<Tigia_json> objects;
    public Adapter_Tigia(@NonNull Activity context, int resource, @NonNull List<Tigia_json> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        // Đây là một lớp để build layout bình thường thành 1 code java mà android sử dụng được
        // load file xml vào hệ thống và build thành code để chương tình có thể sử dụng
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        // Đối số this.resource chính là item.ml, ta sẽ truyền vào khi dọi Adapter_Tigia
        row = layoutInflater.inflate(this.resource,null);
        ImageView img = row.findViewById(R.id.id_img);
        TextView _kiHieu = row.findViewById(R.id.txt_KyHieu);
        TextView _MuaTM = row.findViewById(R.id.txt_MuaTM);
        TextView _MuaCK = row.findViewById(R.id.txt_MuaCK);
        TextView _BanTM = row.findViewById(R.id.txt_BanTM);
        TextView _BanCK = row.findViewById(R.id.txt_BanCK);

        Tigia_json tiGia = this.objects.get(position);

        img.setImageBitmap(tiGia.getBitmap());
        _kiHieu.setText(tiGia.getType());
        _MuaTM.setText(String.valueOf(tiGia.getMuatienmat()));
        _MuaCK.setText(String.valueOf(tiGia.getMuack()));
        _BanTM.setText(String.valueOf(tiGia.getBantienmat()));
        _BanCK.setText(String.valueOf(tiGia.getBanck()));
        return row;
    }
}
