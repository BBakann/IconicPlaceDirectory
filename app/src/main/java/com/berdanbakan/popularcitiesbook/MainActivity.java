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
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //binding ekledik
        View view = binding.getRoot();
        setContentView(view);


        cityMarkArrayList=new ArrayList<>();
        filteredList=new ArrayList<>();



        //Kendi veri girişimiz internetten çekmeden.
        cityMark anitkabir = new cityMark("Anıtkabir", "Ankara", R.drawable.anitkabir,
                "Anıtkabir is the mausoleum of Mustafa Kemal Atatürk, the founder of the Republic of Turkey. " +
                        "Anıtkabir is located in Ankara and attracts millions of visitors every year. " +
                        "Anıtkabir is a symbol of the Turkish nation's struggle for independence and freedom.");
        cityMark egirdir = new cityMark("Eğirdir", "Isparta", R.drawable.egirdir,
                "Eğirdir is a district in the Isparta province of Turkey. " +
                        "Eğirdir Lake is the fourth largest freshwater lake in Turkey. " +
                        "Eğirdir is a popular destination for outdoor sports and camping.");
        cityMark kaleici = new cityMark("Kaleiçi", "Antalya", R.drawable.kaleici,
                "Kaleiçi is the historic city center of Antalya. " +
                        "Kaleiçi is famous for its narrow streets, historic houses, and ancient walls. " +
                        "Kaleiçi is one of Antalya's major tourist attractions.");
        cityMark kaunos = new cityMark("Kaunos", "Muğla", R.drawable.kaunos,
                "Kaunos is an ancient city located in the Dalyan district of Muğla province. " +
                        "Kaunos was a border city between the regions of Lycia and Caria. " +
                        "Kaunos is famous for its ancient theater, rock tombs, and harbor.");
        cityMark kizkulesi = new cityMark("Kız Kulesi", "İstanbul", R.drawable.kizkulesi,
                "Kız Kulesi (Maiden's Tower) is a historic tower located on a small islet in the Bosphorus Strait in Istanbul. " +
                        "Kız Kulesi is situated in the Üsküdar district and has been the subject of many legends. " +
                        "Kız Kulesi is one of Istanbul's landmarks and a popular tourist attraction.");
        cityMark ayasofya = new cityMark("Ayasofya", "İstanbul", R.drawable.ayasofya,
                "Hagia Sophia (Ayasofya) is a historic building in Istanbul that has served as both a mosque and a church. " +
                        "Hagia Sophia was originally built as a church during the Byzantine era and was converted into a mosque during the Ottoman period. " +
                        "Hagia Sophia is renowned for its magnificent architecture and historical significance and is a world-famous landmark.");
        cityMark topkapi = new cityMark("Topkapı Sarayı", "İstanbul", R.drawable.topkapi,
                "Topkapi Palace is located in Istanbul and is the first palace of the Ottoman Empire. " +
                        "The palace was built in the 15th century and served as the official residence and administrative center of the Ottoman sultans. " +
                        "Topkapi Palace is famous for its vast collections and historic buildings and now serves as a museum attracting visitors.");
        cityMark pamukkale = new cityMark("Pamukkale", "Denizli", R.drawable.pamukkale,
                "Pamukkale is a natural formation located in Denizli, famous for its white travertine terraces created by hot mineral springs. " +
                        "The mineral content of Pamukkale's waters has contributed to the formation of these terraces and was used for therapeutic purposes in ancient times. " +
                        "Pamukkale is listed as a UNESCO World Heritage Site due to its natural beauty and historical significance, including the ancient city of Hierapolis.");
        cityMark efes = new cityMark("Efes Antik Kenti", "İzmir", R.drawable.efes,
                "Ephesus is an ancient Roman city located in İzmir province and is one of the most significant cities of the Ancient World. " +
                        "Ephesus is famous for its impressive structures such as the Temple of Artemis, which was considered one of the Seven Wonders of the Ancient World. " +
                        "Ephesus offers visitors a rich historical heritage with its ancient theater, library, and baths.");
        cityMark cappadocia = new cityMark("Kapadokya", "Nevşehir", R.drawable.cappadocia,
                "Cappadocia is a unique natural formation and historical region located in Central Anatolia, Turkey. " +
                        "Cappadocia is famous for its fairy chimneys, underground cities, and rock-cut churches. " +
                        "The region is a popular tourist destination known for hot air balloon rides and its unique landscapes.");
        cityMark sumela = new cityMark("Sümela Manastırı", "Trabzon", R.drawable.sumela,
                "The Sumela Monastery is a historic Greek Orthodox monastery built on the side of a high mountain in the Maçka district of Trabzon. " +
                        "The monastery dates back to the Byzantine era and contains impressive frescoes and religious artworks. " +
                        "The Sumela Monastery is a popular tourist site known for its historical and natural beauty.");
        cityMark nemrut = new cityMark("Nemrut Dağı", "Adıyaman", R.drawable.nemrut,
                "Mount Nemrut is an ancient mountain in Adıyaman province, known for its massive statues. " +
                        "The mountain is a funerary mound built by Antiochus Theos, the king of the Commagene Kingdom, in the 1st century BC. " +
                        "Mount Nemrut is famous for its impressive statues and sunrise views and is listed as a UNESCO World Heritage Site.");
        cityMark alanya = new cityMark("Alanya Kalesi", "Antalya", R.drawable.alanya,
                "Alanya Castle is a historic fortress located in the Alanya district of Antalya province. " +
                        "The castle was built during the Seljuk period and was also used during the Ottoman period. " +
                        "Alanya Castle is known for its impressive walls and historic structures, making it a popular tourist attraction.");
        cityMark bergama = new cityMark("Bergama Asklepion", "İzmir", R.drawable.bergama,
                "The Pergamon Asklepion is an ancient health center located in the Bergama district of İzmir province. " +
                        "The Asklepion was known as a sacred site for medical and health practices in ancient times. " +
                        "The Pergamon Asklepion is an archaeological site famous for its impressive structures and historical significance.");
        cityMark bursa = new cityMark("Uludağ", "Bursa", R.drawable.uludag,
                "Uludağ is a mountain in Bursa province and is one of the highest peaks in Turkey. " +
                        "Uludağ is a popular destination for winter sports and is suitable for skiing and mountaineering activities. " +
                        "Uludağ is also a national park surrounded by rich flora and fauna, preserving its natural beauty.");


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