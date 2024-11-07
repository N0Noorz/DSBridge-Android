package wendu.jsbdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import wendu.jsbdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.callJs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CallJavascriptActivity.class)));
        binding.callNative.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, JavascriptCallNativeActivity.class)));
        binding.fly.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, WrokWithFlyioTestActivity.class)));
        binding.newki.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, NewkiMainActivity.class)));
    }
}
