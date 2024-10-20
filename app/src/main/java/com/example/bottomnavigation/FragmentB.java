package com.example.bottomnavigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

public class FragmentB extends Fragment {

    private SharedViewModel sharedViewModel;
    private TextView textView;
    private Button backButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        textView = view.findViewById(R.id.textView);
        backButton = view.findViewById(R.id.backButton);
        // Mendapatkan ViewModel
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Mengamati data dari ViewModel
        sharedViewModel.getSelectedData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                textView.setText(data);
            }
        });

        // Mengatur klik pada tombol Back
        backButton.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack(); // Kembali ke Fragment sebelumnya
        });

        return view;
    }
}