package com.ddrssoft.mylocandmusic.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ddrssoft.mylocandmusic.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ServicioMusical.class);
                    getContext().startService(intent);
            }
        });

        binding.btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ServicioMusical.class);
                intent.setAction(ServicioMusical.ACTION_PAUSE); // Pausa la Musica
                getContext().startService(intent);
            }
        });

        binding.btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ServicioMusical.class);
                intent.setAction(ServicioMusical.ACTION_STOP); // Detiene la Musica
                getContext().startService(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}