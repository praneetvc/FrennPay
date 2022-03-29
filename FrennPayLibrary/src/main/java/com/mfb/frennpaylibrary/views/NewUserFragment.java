package com.mfb.frennpaylibrary.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.mfb.frennpaylibrary.R;
import com.mfb.frennpaylibrary.databinding.FragmentNewUserBinding;

public class NewUserFragment extends Fragment {

    private FragmentNewUserBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentNewUserBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.proceedButton.setOnClickListener(view1 -> NavHostFragment.findNavController(NewUserFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}