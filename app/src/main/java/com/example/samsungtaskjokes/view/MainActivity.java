package com.example.samsungtaskjokes.view;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.samsungtaskjokes.CallBack;
import com.example.samsungtaskjokes.R;

import com.example.samsungtaskjokes.databinding.ActivityMainBinding;
import com.example.samsungtaskjokes.viewmodel.MainActivityViewModel;
import com.firework.imageloading.glide.GlideImageLoaderFactory;

import java.util.Random;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainActivityViewModel viewModel;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getWindow().setStatusBarColor(getResources().getColor(R.color.blue));

        Glide
                .with(this)
                .load(R.drawable.white_noise)
                .into(binding.whiteShum);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getRandomJoke().observe(this, randomJoke -> {
            binding.setup.setText(randomJoke.getStp());
            binding.punchline.setText(randomJoke.getPn());
            String category = "Категория: " + randomJoke.getTp();
            String id = "ID: " + randomJoke.getId();
            binding.id.setText(id);
            binding.category.setText(category);
            switch (randomJoke.getTp()) {
                case "general":
                    binding.imageView.setImageResource(R.drawable.blue_gradient);
                    binding.generate.setTextColor(getResources().getColor(R.color.blue));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
                    break;
                case "programming":
                    binding.imageView.setImageResource(R.drawable.green_gradient);
                    binding.generate.setTextColor(getResources().getColor(R.color.green));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.green));
                    break;
                case "knock-knock":
                    binding.imageView.setImageResource(R.drawable.pink_gradient);
                    binding.generate.setTextColor(getResources().getColor(R.color.pink));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.pink));
                    break;
            }
        });

        binding.generate.setOnClickListener(v -> {
            binding.bg.setVisibility(View.VISIBLE);
            binding.smile.setVisibility(View.VISIBLE);
            viewModel.getRandomJokeFromServer(new CallBack() {
                @Override
                public void invoke() {
                    binding.bg.setVisibility(View.GONE);
                    binding.smile.setVisibility(View.GONE);
                    binding.punchline.setVisibility(View.GONE);
                    binding.blueBg.setVisibility(View.VISIBLE);
                    binding.whiteShum.setVisibility(View.VISIBLE);
                    binding.prikol.setVisibility(View.VISIBLE);
                }
            });
        });
        binding.blueBg.setOnClickListener(v -> {
            DisplayMetrics display = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(display);
            final KonfettiView konfettiView = findViewById(R.id.viewConfetti);
            konfettiView.build()
                    .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                    .setDirection(0.0, 359.0)
                    .setSpeed(1f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(2000L)
                    .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                    .addSizes(new Size(12, 5))
                    .setPosition(-50f, display.widthPixels + 50f, -50f, -50f)
                    .streamFor(300, 1500L);

            binding.punchline.setVisibility(View.VISIBLE);
            binding.blueBg.setVisibility(View.GONE);
            binding.whiteShum.setVisibility(View.GONE);
            binding.prikol.setVisibility(View.GONE);
            int randomNum = rand.nextInt(5);
            switch (randomNum){
                case (0):
                    Glide
                            .with(this)
                            .load(R.drawable.dance_emoji)
                            .skipMemoryCache(true)
                            .into(binding.mainGif);
                    break;
                case (1):
                    Glide
                            .with(this)
                            .load(R.drawable.danse_dance)
                            .skipMemoryCache(true)
                            .into(binding.mainGif);
                    break;
                case (2):
                    Glide
                            .with(this)
                            .load(R.drawable.kopgel_happy_dance)
                            .skipMemoryCache(true)
                            .into(binding.mainGif);
                    break;
                case (3):
                    Glide
                            .with(this)
                            .load(R.drawable.thinking_emoji)
                            .skipMemoryCache(true)
                            .into(binding.mainGif);
                    break;
                case (4):
                    Glide
                            .with(this)
                            .load(R.drawable.thinking_hmm)
                            .skipMemoryCache(true)
                            .into(binding.mainGif);
                    break;
            }
        });
        binding.bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}