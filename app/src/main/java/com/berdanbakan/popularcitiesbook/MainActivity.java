package com.berdanbakan.popularcitiesbook;

import static java.util.Locale.filter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.berdanbakan.popularcitiesbook.databinding.ActivityInfoBinding;
import com.berdanbakan.popularcitiesbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private markAdapter markAdapter;

    private ActivityMainBinding binding;
    private ArrayList<cityMark> cityMarkArrayList;

    private ArrayList<cityMark> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        cityMarkArrayList=new ArrayList<>();
        filteredList=new ArrayList<>();



        //Kendi veri girişimiz
        cityMark anitkabir= new cityMark("Anıtkabir","Ankara",R.drawable.anitkabir);
        cityMark egirdir= new cityMark("Eğirdir","Isparta",R.drawable.egirdir);
        cityMark kaleici= new cityMark("Kaleiçi","Antalya",R.drawable.kaleici);
        cityMark kaunos= new cityMark("Kaunos","Muğla",R.drawable.kaunos);
        cityMark kizkulesi= new cityMark("Kız Kulesi","İstanbul",R.drawable.kizkulesi);
        cityMark ayasofya = new cityMark("Ayasofya", "İstanbul", R.drawable.ayasofya);
        cityMark topkapi = new cityMark("Topkapı Sarayı", "İstanbul", R.drawable.topkapi);
        cityMark pamukkale = new cityMark("Pamukkale", "Denizli", R.drawable.pamukkale);
        cityMark efes = new cityMark("Efes Antik Kenti", "İzmir", R.drawable.efes);
        cityMark cappadocia = new cityMark("Kapadokya", "Nevşehir", R.drawable.cappadocia);
        cityMark sumela = new cityMark("Sümela Manastırı", "Trabzon", R.drawable.sumela);
        cityMark nemrut = new cityMark("Nemrut Dağı", "Adıyaman", R.drawable.nemrut);
        cityMark alanya = new cityMark("Alanya Kalesi", "Antalya", R.drawable.alanya);
        cityMark bergama = new cityMark("Bergama Asklepion", "İzmir", R.drawable.bergama);
        cityMark bursa = new cityMark("Uludağ", "Bursa", R.drawable.uludag);


        cityMarkArrayList.add(anitkabir);
        cityMarkArrayList.add(kaleici);
        cityMarkArrayList.add(egirdir);
        cityMarkArrayList.add(kizkulesi);
        cityMarkArrayList.add(kaunos);
        cityMarkArrayList.add(ayasofya);
        cityMarkArrayList.add(topkapi);
        cityMarkArrayList.add(pamukkale);
        cityMarkArrayList.add(efes);
        cityMarkArrayList.add(cappadocia);
        cityMarkArrayList.add(sumela);
        cityMarkArrayList.add(nemrut);
        cityMarkArrayList.add(alanya);
        cityMarkArrayList.add(bergama);
        cityMarkArrayList.add(bursa);

        filteredList.addAll(cityMarkArrayList);



        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        markAdapter=new markAdapter(filteredList);
        binding.recyclerView.setAdapter(markAdapter);


        /*Adapter listView için.
       // ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
            //    cityMarkArrayList.stream().map(cityMark -> cityMark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);
         */

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });



        SharedPreferences preferences=getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        boolean firstRun=preferences.getBoolean("firstRun",true);

        if (firstRun){
            Toast.makeText(this,"Made by Berdan Bakan",Toast.LENGTH_LONG).show();
            SharedPreferences.Editor editor=preferences.edit();
            editor.putBoolean("firstRun",false);
            editor.apply();
        }
    }
        private void filter(String text){
        filteredList.clear();
        if (text.isEmpty()){
            filteredList.addAll(cityMarkArrayList);
        }else {
            for (cityMark item: cityMarkArrayList){
                if (item.name.toLowerCase().contains(text.toLowerCase())){
                    filteredList.add(item);

                }
            }
        }
        markAdapter.notifyDataSetChanged();
    }
}