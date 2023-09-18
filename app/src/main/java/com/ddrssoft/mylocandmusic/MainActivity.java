package com.ddrssoft.mylocandmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import com.ddrssoft.mylocandmusic.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.login(binding.etUsuario.getText().toString(), binding.etPassword.getText().toString());
            }
        });
    }

}
