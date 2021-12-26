package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hoangquangdev.MainActivity;
import com.hoangquangdev.MainAppDanhBa;
import com.hoangquangdev.R;

import java.util.List;

import model.DanhBa;

public class DanhBaadapter extends ArrayAdapter<DanhBa>
{
    MainAppDanhBa context;
    int resource;@NonNull
    List<DanhBa> objects;

    public DanhBaadapter(@NonNull MainAppDanhBa context, int resource, @NonNull List<DanhBa> objects) {
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
        TextView name= row.findViewById(R.id.txtName);
        TextView phone = row.findViewById(R.id.txtNumberPhone);
        DanhBa danhBa = this.objects.get(position);
        name.setText(danhBa.getName());
        phone.setText(danhBa.getNumberPhone());
        return row;
    }
}
