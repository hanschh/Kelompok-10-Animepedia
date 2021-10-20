package com.dih.animepedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AnimeAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private String[] dataSynopsis;
    private TypedArray dataPhoto;
    private ArrayList<Anime> animes;
    int[] animeImages = {R.drawable.lapanenam, R.drawable.mushokutensei,R.drawable.onepiece,
            R.drawable.kimetsunoyaiba,R.drawable.komisanwa,R.drawable.holonogravity,
            R.drawable.ousama,R.drawable.detectiveconan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new AnimeAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),DescriptionActivity.class);
                intent.putExtra("name",dataName[i]);
                intent.putExtra("image",animeImages[i]);
                intent.putExtra("synops",dataSynopsis[i]);
                startActivity(intent);
            }
        });
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataSynopsis = getResources().getStringArray(R.array.data_synopsis);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem(){
        animes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            Anime anime = new Anime();
            anime.setPhoto(dataPhoto.getResourceId(i, -1));
            anime.setName(dataName[i]);
            anime.setDescription(dataDescription[i]);
            anime.setSynopsis(dataSynopsis[i]);
            animes.add(anime);
        }
        adapter.setAnimes(animes);
    }
}