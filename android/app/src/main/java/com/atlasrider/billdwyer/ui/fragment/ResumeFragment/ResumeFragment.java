package com.atlasrider.billdwyer.ui.fragment.ResumeFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atlasrider.billdwyer.R;
import com.atlasrider.billdwyer.data.model.ResumeModel;
import com.atlasrider.billdwyer.data.viewmodel.ResumeViewModel;
import com.atlasrider.billdwyer.databinding.FragmentResumeBinding;
import com.atlasrider.billdwyer.util.File;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ResumeFragment extends Fragment {
    private static final String TAG = ResumeFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ResumeViewModel resumeViewModel = new ResumeViewModel(loadResume());
        View view = setupDatabinding(inflater, container, resumeViewModel);
        setupPositionRecyclerView(view, resumeViewModel);
        return view;
    }

    private View setupDatabinding(LayoutInflater inflater, ViewGroup container, ResumeViewModel resumeViewModel) {
        FragmentResumeBinding binding = FragmentResumeBinding.inflate(inflater, container, false);
        binding.setResume(resumeViewModel);
        return binding.getRoot();
    }

    private void setupPositionRecyclerView(View view, ResumeViewModel resumeViewModel) {
        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.Adapter recyclerViewAdapter = new PositionAdapter(resumeViewModel.getExperience());

        RecyclerView recyclerView = view.findViewById(R.id.positions);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private ResumeModel loadResume() {
        String json = "{}";
        try {
            //noinspection ConstantConditions
            json = File.Companion.readAsset(getContext().getAssets(), "resume.json");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Gson gson = new Gson();
        ResumeModel resumeModel = gson.fromJson(json, ResumeModel.class);

        // TODO: Add unit tests to verify this
        JsonElement source = JsonParser.parseString(json);
        JsonElement destination = JsonParser.parseString(gson.toJson(resumeModel));

        Log.d(TAG, String.valueOf(source.equals(destination)));
        Log.d(TAG, gson.toJson(resumeModel));

        return resumeModel;
    }
}
