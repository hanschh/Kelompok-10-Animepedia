package com.dih.animepedia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import java.util.ArrayList;

public class DescriptionActivity extends AppCompatActivity {
TextView name;
TextView synops;
ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_anime);

        name = findViewById(R.id.txt_name);
        synops = findViewById(R.id.txt_synopsis);
        image = findViewById(R.id.img_photo);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        synops.setText(intent.getStringExtra("synops"));
        image.setImageResource(intent.getIntExtra("image",0));

    }
}
