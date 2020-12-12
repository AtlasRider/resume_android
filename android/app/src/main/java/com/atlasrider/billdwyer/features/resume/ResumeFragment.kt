package com.atlasrider.billdwyer.features.resume

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atlasrider.billdwyer.R
import com.atlasrider.billdwyer.databinding.FragmentResumeBinding
import com.atlasrider.billdwyer.util.File.Companion.readAsset
import com.google.gson.Gson
import com.google.gson.JsonParser
import java.io.IOException

class ResumeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val resumeViewModel = ResumeViewModel(loadResume())
        val view = setupDatabinding(inflater, container, resumeViewModel)
        setupPositionRecyclerView(view, resumeViewModel)
        return view
    }

    private fun setupDatabinding(inflater: LayoutInflater, container: ViewGroup?, resumeViewModel: ResumeViewModel): View {
        val binding = FragmentResumeBinding.inflate(inflater, container, false)
        binding.resume = resumeViewModel
        return binding.root
    }

    private fun setupPositionRecyclerView(view: View, resumeViewModel: ResumeViewModel) {
        val recyclerViewLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        val recyclerViewAdapter: RecyclerView.Adapter<*> = PositionAdapter(resumeViewModel.experience)
        val recyclerView: RecyclerView = view.findViewById(R.id.positions)
        recyclerView.setHasFixedSize(true)
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.layoutManager = recyclerViewLayoutManager
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun loadResume(): ResumeModel {
        var json = "{}"
        try {
            json = readAsset(context!!.assets, "resume.json")
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        val gson = Gson()
        val resumeModel = gson.fromJson(json, ResumeModel::class.java)

        // TODO: Add unit tests to verify this
        val source = JsonParser.parseString(json)
        val destination = JsonParser.parseString(gson.toJson(resumeModel))
        Log.d(TAG, (source == destination).toString())
        Log.d(TAG, gson.toJson(resumeModel))
        return resumeModel
    }

    companion object {
        private val TAG = ResumeFragment::class.java.simpleName
    }
}