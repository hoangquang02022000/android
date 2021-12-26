package adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hoangquangdev.R;

import java.util.List;

import model.TiGia;

public class TiGia_Adapter extends ArrayAdapter<TiGia> {
    Activity context;
    int resource ;@NonNull
    List<TiGia>objects;

    public TiGia_Adapter(@NonNull Activity context, int resource, @NonNull List<TiGia> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        row = layoutInflater.inflate(this.resource,null);
        ImageView img = row.findViewById(R.id.img_TiGia);
        TextView kihieu = row.findViewById(R.id.txt_KyHieu);
        TextView giabantm = row.findViewById(R.id.txt_giabanTM);
        TextView giamuatm = row.findViewById(R.id.txt_giamuaTM);
        TextView giamuack = row.findViewById(R.id.txt_giaMuaCK);
        TextView giabanck = row.findViewById(R.id.txt_giaBanCK);

        TiGia tiGia = this.objects.get(position);
        img.setImageResource(tiGia.getImg());
        kihieu.setText(tiGia.getKyHieu());
        giamuatm.setText(String.valueOf(tiGia.getGiamauTM()));
        giabantm.setText(String.valueOf(tiGia.getGiabanTM()));
        giabanck.setText(String.valueOf(tiGia.getGiabanCK()));
        giamuack.setText(String.valueOf(tiGia.getGiamauTM()));

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Bạn chọn "+objects.get(position).getKyHieu(),Toast.LENGTH_SHORT).show();
            }
        });

        return row;
    }
}
