package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hoangquangdev.MainAppNhanVien;
import com.hoangquangdev.R;

import java.util.List;

import model.NhanVien;

public class NhanVien_Adapter extends ArrayAdapter<NhanVien> {
    Activity context;
    int resource ; @NonNull
    List<NhanVien>objects;
    public NhanVien_Adapter(@NonNull Activity context, int resource, @NonNull List<NhanVien> objects) {
        super(context, resource, objects);
        this.objects=objects;
        this.context =context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        row=layoutInflater.inflate(this.resource,null);
        ImageView _img = row.findViewById(R.id.img_NV);
        TextView _txt = row.findViewById(R.id.txt_NhanVien);
        CheckBox _cb = row.findViewById(R.id.checkBox);

        NhanVien nhanVien = this.objects.get(position);
        if (nhanVien.isGioTinh()==true){
            _img.setImageResource(R.drawable.male);
        }else {
            _img.setImageResource(R.drawable.female);
        }
        _txt.setText(nhanVien.getMaNV()+"-"+nhanVien.getTenNV());

        _cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (_cb.isChecked())
                    MainAppNhanVien.vitri.add(position);
                else {
                    for (int x : MainAppNhanVien.vitri){
                        if (x==position){
                            MainAppNhanVien.vitri.remove(x);
                        }
                    }
                }
            }
        });
        return row;
    }

}
