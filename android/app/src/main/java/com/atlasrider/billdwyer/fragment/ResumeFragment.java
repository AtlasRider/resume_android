package com.atlasrider.billdwyer.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atlasrider.billdwyer.R;
import com.atlasrider.billdwyer.util.File;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResumeFragment extends Fragment {
    private static final String TAG = ResumeFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resume, container, false);
    }

    private void loadResume() {
        String json = null;
        try {
            //noinspection ConstantConditions
            json = File.Companion.readAsset(getContext().getAssets(), "resume.json");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Log.d(TAG, json);
    }
}
