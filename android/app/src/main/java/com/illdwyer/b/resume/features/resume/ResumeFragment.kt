package com.illdwyer.b.resume.features.resume

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.illdwyer.b.resume.R
import com.illdwyer.b.resume.data.ResumeModel
import com.illdwyer.b.resume.databinding.FragmentResumeBinding
import com.illdwyer.b.resume.features.resume.generalinfo.GeneralInfoFragment
import com.illdwyer.b.resume.util.File.Companion.readAsset
import java.io.IOException

@Suppress("unused")
class ResumeFragment : Fragment() {

  private val viewModel: ResumeViewModel by activityViewModels()



  //    override val education: EducationViewModel =
  //            EducationViewModel(
  //                    super.education
  //            )
  //
  //    class EducationViewModel(model: Education) : Education(model.college, model.start, model.end, model.location,
  //            model.degree, model.majors) {
  //        val duration: String = String.format("%s - %s", start, end)
  //        fun getMajorsAsString() = super.majors.joinToString()
  //    }


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    val resumeModel = loadResume()

    val view = setupDatabinding(inflater, container, resumeModel)
    setupPositionRecyclerView(view, resumeModel)

    viewModel.resume.value = resumeModel


    //    val resumeModel = loadResume()
//
//    val generalInfoFragment =
//      childFragmentManager.findFragmentById(R.id.generalInfo) as GeneralInfoFragment
//    generalInfoFragment.update(resumeModel.general)

    return view
  }

  private fun setupDatabinding(
    inflater: LayoutInflater,
    container: ViewGroup?,
    resumeViewModel: ResumeModel
  ): View {
    val binding = FragmentResumeBinding.inflate(inflater, container, false)
    binding.resume = resumeViewModel
    return binding.root
  }

  private fun setupPositionRecyclerView(
    view: View, resumeViewModel: ResumeModel
  ) {
    val recyclerViewLayoutManager: RecyclerView.LayoutManager =
      LinearLayoutManager(context)
    val recyclerViewAdapter: RecyclerView.Adapter<*> =
      PositionAdapter(resumeViewModel.experience)
    val recyclerView: RecyclerView = view.findViewById(R.id.positions)
    recyclerView.setHasFixedSize(true)
    recyclerView.isNestedScrollingEnabled = false
    recyclerView.layoutManager = recyclerViewLayoutManager
    recyclerView.adapter = recyclerViewAdapter
  }

  private fun loadResume(): ResumeModel {
    var json = "{}"
    try {
      json = readAsset(requireContext().assets, "resume.json")
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
