package com.example.learnactivity3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.activity_main);
        cityList.addAll(City.getList());

        //实例化myAdapter并调用带参数的构造方法传一个fruitList的列表
        MyAdapter = new MyAdapter(cityList);
        //实例化mRecycler
        mRecycler = findViewById(R.id.recycler);
        //定义布局管理器为Grid管理器，设置一行放3个
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        //设置布局管理器为线性布局管理器
        mRecycler.setLayoutManager(layoutManager);
        //设置适配器
        mRecycler.setAdapter(myAdapter);

        //设置分隔线
        mRecycler.addItemDecoration(new MyDecoration());
        class MyDecoration extends RecyclerView.ItemDecoration{
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                //outRect.set()中的参数分别对应左、上、右、下的间隔
                outRect.set(10,10,10,10);
            }



        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Rl_city_name);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomizeDialog();
            }
        });
    }

    private void showCustomizeDialog() {
        AlertDialog.Builder customizeDialog =
                new AlertDialog.Builder(MainActivity.this);

        final View dialogView = LayoutInflater.from(MainActivity.this)
                .inflate(R.layout.dialog_customize, null);
        customizeDialog.setView(dialogView);
        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 获取EditView中的输入内容
                TextView textView =
                        (TextView) dialogView.findViewById(R.id.tv_city);
                Toast.makeText(MainActivity.this,
                        textView.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        };
    }

}