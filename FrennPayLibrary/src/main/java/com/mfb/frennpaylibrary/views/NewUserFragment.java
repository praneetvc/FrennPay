package com.mfb.frennpaylibrary.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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

        binding.buttonProceed.setOnClickListener(view1 -> {
            if (getActivity() != null) {
                ((HomeActivity) getActivity()).loadFragment(new OtpFragment());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}