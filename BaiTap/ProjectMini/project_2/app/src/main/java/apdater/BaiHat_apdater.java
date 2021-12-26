package apdater;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hoangquangdev.MainActivity;
import com.hoangquangdev.R;

import java.util.List;

import mode.BaiHat;

public class BaiHat_apdater extends ArrayAdapter<BaiHat> {
    Activity context;
    int resource ; @NonNull
    List<BaiHat> objects;
    public BaiHat_apdater(@NonNull Activity context, int resource, @NonNull List<BaiHat> objects) {
        super(context, resource, objects);
        this.objects=objects;
        this.context= context;
        this.resource= resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        row = layoutInflater.inflate(this.resource,null);
        TextView _maBH = row.findViewById(R.id.maBH);
        TextView _txtBH = row.findViewById(R.id.txt_Ten);
        TextView _txtCS = row.findViewById(R.id.txt_Casi);
        TextView _txtTL =row.findViewById(R.id.txt_tl);

        BaiHat baiHat = this.objects.get(position);
        _maBH.setText(baiHat.getMaBH());
        _txtBH.setText(baiHat.getTenBH());
        _txtCS.setText(baiHat.getTenCS());
        _txtTL.setText(baiHat.getCategory());
        // kiểm tra like/nolike
        ImageButton imageButton = row.findViewById(R.id.imageButton);
        if (baiHat.getYt() == 1){
            imageButton.setImageResource(R.drawable.like);
        }else{
            imageButton.setImageResource(R.drawable.unlike);
        }
//         thêm ds bài hát yêu thích
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baiHat.getYt()==1){
                    imageButton.setImageResource(R.drawable.unlike);
                    baiHat.setYt(0);
                    Toast.makeText(context, "Bạn đã bỏ thích bài : " + objects.get(position).getTenBH(), Toast.LENGTH_SHORT).show();

                }else
                    imageButton.setImageResource(R.drawable.like);
                    baiHat.setYt(1);
                    Toast.makeText(context, "Bạn đã thích : " + objects.get(position).getTenBH(),Toast.LENGTH_SHORT).show();
            }
        });
        return row;
    }
}
