package com.example.redditclient.ui.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.redditclient.AppDelegate;
import com.example.redditclient.R;
import com.example.redditclient.databinding.ImageBinding;
import com.example.redditclient.utils.ImageSaver;

import javax.inject.Inject;

import toothpick.Toothpick;

public class ImageFragment extends Fragment {
    public static final String FRAGMENT_KEY = "FRAGMENT_KEY";
    Button button;
    @Inject
    ImageViewModel imageViewModel;
    private String url;

    public static ImageFragment newInstance(Bundle args) {
        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        url = getArguments().getString(FRAGMENT_KEY);
        Toothpick.inject(this, AppDelegate.getAppScope());
        imageViewModel.onAttach(url);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ImageBinding imageBinding = ImageBinding.inflate(inflater, container, false);
        imageBinding.setImage(imageViewModel);
        imageBinding.setLifecycleOwner(this);
        return imageBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.image_save);
        button.setOnClickListener(v -> {
            saveImageToGallery();
        });
    }

    @SuppressLint("ShowToast")
    private void saveImageToGallery() {
        new ImageSaver(getActivity().getApplication()).execute(url);
        Toast.makeText(getContext(), "Image saved to gallery", Toast.LENGTH_SHORT).show();
    }
}
