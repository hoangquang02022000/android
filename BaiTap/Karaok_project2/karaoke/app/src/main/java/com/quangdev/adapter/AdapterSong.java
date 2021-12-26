package com.quangdev.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.quangdev.LydricActivity;
import com.quangdev.MainActivity;
import com.quangdev.R;
import com.quangdev.model.Song;

import java.util.List;

public class AdapterSong extends ArrayAdapter<Song> {
    Activity context;
    int resource;
    List<Song> objects;

    public AdapterSong(@NonNull Activity context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
        this.context =context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        row = layoutInflater.inflate(this.resource, null);

        TextView _SongId = row.findViewById(R.id.txtSongId);
        TextView _SongName = row.findViewById(R.id.txtSongName);
        TextView _SongSinger = row.findViewById(R.id.txtSongSinger);
        TextView _SongCategory = row.findViewById(R.id.txtSongCategory);
        ImageButton _ibtnHeart = row.findViewById(R.id.ibtnHeart);

        Song song = this.objects.get(position);
        _SongId.setText(song.getId());
        _SongName.setText(song.getName());
        _SongSinger.setText(song.getSinger());
        _SongCategory.setText(song.getCategory());

        // Check heart | unheart
        if (song.getState() == 1) {
            _ibtnHeart.setImageResource(R.drawable.heart_30px);
        } else {
            _ibtnHeart.setImageResource(R.drawable.unheart_30px);
        }

        _ibtnHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (song.getState() == 1) {
                    _ibtnHeart.setImageResource(R.drawable.unheart_30px);
                    song.setState(0);
                    Toast.makeText(context, "Đã xóa " + song.getName() + " khỏi danh sách yêu thích!", Toast.LENGTH_SHORT).show();
                } else {
                    _ibtnHeart.setImageResource(R.drawable.heart_30px);
                    song.setState(1);
                    Toast.makeText(context, "Đã thêm " + song.getName() + " vào danh sách yêu thích!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, LydricActivity.class);
//                Bundle extras = new Bundle();
//                extras.putString("name", objects.get(position).getName());
//                extras.putString("lyric", objects.get(position).getLyric());
//                intent.putExtras(extras);
//                context.startActivity(intent);



//                Toast.makeText(context,"Ban chon" +song.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return row;
    }
}
