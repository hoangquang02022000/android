package adapter;

import android.app.Activity;
import android.content.Context;
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

import model.Nation;

public class Person_Adapter extends ArrayAdapter<Nation> {
    Activity context;
    int resuorce;@NonNull
    List<Nation> objects;
    public Person_Adapter(@NonNull Activity context, int resource, @NonNull List<Nation> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resuorce =resource;
        this.objects =objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        row = layoutInflater.inflate(this.resuorce, null);
        ImageView img = row.findViewById(R.id.img_viewnation);
        TextView name = row.findViewById(R.id.txtNamenation);
        TextView number = row.findViewById(R.id.txtDanSo);

        Nation nation = this.objects.get(position);
        img.setImageResource(nation.getImg());
        name.setText(nation.getName_Nation());
        number.setText(String.valueOf(nation.getNumber_Person()));
//
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context , "Bạn Chọn : "+objects.get(position).getName_Nation()+" Dân số :"+objects.get(position).getNumber_Person(),Toast.LENGTH_SHORT).show();
            }
        });
        return row;
    }

}
