package com.example.learnactivity3;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ShowCustomizeDialog {
    private void cityDialog() {
        AlertDialog.Builder customizeDialog =
                new AlertDialog.Builder(MainActivity.this);

        final View dialogView = LayoutInflater.from(MainActivity.this)
                .inflate(R.layout.dialog_customize, null);
        customizeDialog.setView(dialogView);
        customizeDialog.show();
        /**
         * 设置recyclerView，存储City选项
         * */
        cRecyclerView =dialogView.findViewById(R.id.rv_city);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);

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
