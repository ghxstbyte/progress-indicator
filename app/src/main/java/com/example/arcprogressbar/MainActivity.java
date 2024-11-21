package com.example.arcprogressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.arcprogressbar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());

        binding.progressCircular.setCenterText("50%");
        binding.progressCircular.setProgress(50);

        binding.progressArc.setCenterText("70%");
        binding.progressArc.setProgress(70);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
