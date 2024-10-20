package com.example.bottomnavigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {

    private SharedViewModel sharedViewModel;
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        editText = view.findViewById(R.id.editText);
        Button sendButton = view.findViewById(R.id.sendButton);

        // Mendapatkan ViewModel
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Mengirim data ke ViewModel saat tombol ditekan
        sendButton.setOnClickListener(v -> {
            String data = editText.getText().toString();
            sharedViewModel.selectData(data);

            // Beralih ke FragmentB
            Fragment fragmentB = new FragmentB();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, fragmentB); // Pastikan ID ini sesuai dengan layout ID di MainActivity
            fragmentTransaction.addToBackStack(null); // Menambahkan transaksi ke back stack agar bisa kembali
            fragmentTransaction.commit();
        });

        return view;
    }
}
