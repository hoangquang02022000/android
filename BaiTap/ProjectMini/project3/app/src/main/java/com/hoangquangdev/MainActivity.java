package com.hoangquangdev;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    int score=0;
    Random random = new Random();
    TextView txtScore;
    ViewGroup.LayoutParams params;
    RelativeLayout layoutBubble;
    Button lv1,lv2,lv3,lv4;
    // Tao objectAnimation de truy xuat file xml hieu ung
    ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        txtScore = findViewById(R.id.txtScore);
        layoutBubble = findViewById(R.id.layoutBubble);
        lv1 = findViewById(R.id.btn_lv1);
        lv2 = findViewById(R.id.btn_lv2);
        lv3 = findViewById(R.id.btn_lv3);
        lv4 = findViewById(R.id.btn_lv4);

        params = new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
    }

    private void addEvents() {
        lv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = random.nextInt(5);

//                Toast.makeText(MainActivity.this, "So bong" + n, Toast.LENGTH_SHORT).show();
                for (int i = 0; i <= n; i++) {
                    //Vẽ quả bóng
                        processAnim();
                }
            }
        });
        lv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = 5 + random.nextInt(10);

//                Toast.makeText(MainActivity.this, "So bong" + n, Toast.LENGTH_SHORT).show();
                for (int i = 0; i <= n; i++) {
                    //Vẽ quả bóng
                    processAnim();
                }
            }
        });
        lv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n =10+ random.nextInt(20);

//                Toast.makeText(MainActivity.this, "So bong" + n, Toast.LENGTH_SHORT).show();
                for (int i = 0; i <= n; i++) {
                    //Vẽ quả bóng
                    processAnim();
                }
            }
        });
        lv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = 20+ random.nextInt(30);

//                Toast.makeText(MainActivity.this, "So bong" + n, Toast.LENGTH_SHORT).show();
                for (int i = 0; i <= n; i++) {
                    //Vẽ quả bóng
                    processAnim();
                }
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void processAnim() {
        ImageView img = getImageView();
        img.setBackground(getDrawable());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xoa layout khi click trung
                layoutBubble.removeView(view);
                //Thay doi diem so
                txtScore.setText("SCORE: "+(score+=3));
            }
        });
        // Lấy hiệu ứng đã tạo gán vào objectAnimator
        objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this,
                R.animator.bubbleanimation);
        //set Thoi gian hieu ung chay ngau nhien
        objectAnimator.setDuration(3000);
        objectAnimator.setTarget(img);
        layoutBubble.addView(img,params);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                // Khi trai bong cham day se game over
                layoutBubble.removeAllViews();
                score = 0;
                Toast.makeText(MainActivity.this, "GAME OVER", Toast.LENGTH_SHORT).show();
                txtScore.setText("Score: 0");
//                layoutBubble.removeView((View) ((ObjectAnimator)animator).getTarget());

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
            objectAnimator.start();


    }
    private Drawable getDrawable() {
        Drawable drawable;

            int i = random.nextInt(5);
            switch (i) {
                case 0:
                    drawable = getResources().getDrawable(R.drawable.hmh);
                    break;
                case 1:
                    drawable = getResources().getDrawable(R.drawable.lvt);
                    break;
                case 2:
                    drawable = getResources().getDrawable(R.drawable.ptt);
                    break;
                case 3:
                    drawable = getResources().getDrawable(R.drawable.hmh);
                    break;
                case 4:
                    drawable = getResources().getDrawable(R.drawable.lvt);
                    break;
                case 5:
                    drawable = getResources().getDrawable(R.drawable.ptt);
                    break;
                default:
                    drawable = getResources().getDrawable(R.drawable.hmh);
                    break;
            }
            return drawable;
    }
    public ImageView getImageView(){
        ImageView img = new ImageView(MainActivity.this);
        img.setX(random.nextInt(1000));
        return img;
    }
}