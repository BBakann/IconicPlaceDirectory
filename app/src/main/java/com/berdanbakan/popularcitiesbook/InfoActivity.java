package com.berdanbakan.popularcitiesbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.berdanbakan.popularcitiesbook.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {
    private ActivityInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // inflate bağlama işlemleri için kullanılır.
        binding = ActivityInfoBinding.inflate(getLayoutInflater()); //normalde burda ResultProfileBinding yazar buraya kendi aktivitemizi yazarız. ALT+ ENTER sonra.
        View view = binding.getRoot();
        setContentView(view);
        //findviewbyId ile yaptığımızı böyle yapıyoruz daha efektif.
        cityMark selectedCityMark = (cityMark) getIntent().getSerializableExtra("cityMark");

        if (selectedCityMark != null) {
            binding.nameText.setText("Name: " + selectedCityMark.name);
            binding.countryText.setText("City: " + selectedCityMark.city);
            binding.imageView.setImageResource(selectedCityMark.image);


        }

        binding.backToMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}