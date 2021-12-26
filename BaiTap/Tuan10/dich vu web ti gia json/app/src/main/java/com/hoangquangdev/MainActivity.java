package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.hoangquangdev.adapter.Adapter_Tigia;
import com.hoangquangdev.model.Tigia_json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv_tigia;
    Adapter_Tigia adapter_tigia;
    ArrayList<Tigia_json> dsTigia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }
    private void addControls(){
        lv_tigia = findViewById(R.id.lv_tigia);
        dsTigia = new ArrayList<Tigia_json>();
        adapter_tigia = new Adapter_Tigia(
                MainActivity.this,R.layout.item,dsTigia
        );
        lv_tigia.setAdapter(adapter_tigia);

        TigiaTask tigiaTask = new TigiaTask();
        tigiaTask.execute();
    }
    class TigiaTask extends AsyncTask<Void,Void,List<Tigia_json>>{

        @Override
        protected List<Tigia_json> doInBackground(Void... voids) {
            ArrayList<Tigia_json> ds = new ArrayList<>();
            //Mở kết nối URL
            try {
                URL url = new URL("https://www.dongabank.com.vn/exchange/export");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type","application/json; charset-utf-8");
                connection.setRequestProperty("User-Agent","Mozilla/5.0 (compatible)");
                connection.setRequestProperty("Accept","*/*");
                //Đọc dữ liệu server gửi về
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(),
                        StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                StringBuilder stringBuilder = new StringBuilder();
                while (line!=null){
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                }
                inputStreamReader.close();
                String stringjson = stringBuilder.toString();
                stringjson = stringjson.replace("(","");
                stringjson = stringjson.replace(")","");
                JSONObject jsonObject = new JSONObject(stringjson);
                JSONArray jsonArray = jsonObject.getJSONArray("items");
                //Duyệt các dòng dữ liệu trong item
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject item = jsonArray.getJSONObject(i);
                    Tigia_json tigia_json = new Tigia_json();
                    tigia_json.setType(item.getString("type"));
                    //Vì hình là một link nên mình phải mở kết nối
                    if (item.has("imageurl")){
                        tigia_json.setImageurl(item.getString("imageurl"));
                        url = new URL(tigia_json.getImageurl());
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("Content-Type","application/json; charset-utf-8");
                        connection.setRequestProperty("User-Agent","Mozilla/5.0 (compatible)");
                        connection.setRequestProperty("Accept","*/*");
                        Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                        Bitmap bitmapScaled = Bitmap.createScaledBitmap(bitmap,100,80,true);
                        tigia_json.setBitmap(bitmapScaled);
                    }
                    tigia_json.setMuatienmat(item.getString("muatienmat"));
                    tigia_json.setMuack(item.getString("muack"));
                    tigia_json.setBantienmat(item.getString("bantienmat"));
                    tigia_json.setBanck(item.getString("banck"));
                    ds.add(tigia_json);
                }
            } catch (Exception e) {
                Log.e("Error: ",e.toString());
            }
            return ds;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            adapter_tigia.clear();
        }

        @Override
        protected void onPostExecute(List<Tigia_json> tigia_jsons) {
            super.onPostExecute(tigia_jsons);
            adapter_tigia.clear();
            adapter_tigia.addAll(tigia_jsons);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}