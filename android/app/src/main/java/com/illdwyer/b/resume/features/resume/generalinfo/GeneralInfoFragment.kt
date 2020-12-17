package com.illdwyer.b.resume.features.resume.generalinfo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.illdwyer.b.resume.R
import com.illdwyer.b.resume.data.ResumeModel
import com.illdwyer.b.resume.databinding.GeneralInfoFragmentBinding
import com.illdwyer.b.resume.features.resume.ResumeViewModel

class GeneralInfoFragment : Fragment(R.layout.general_info_fragment) {

  private var binding: GeneralInfoFragmentBinding? = null
  private val viewModel: ResumeViewModel by activityViewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding = GeneralInfoFragmentBinding.bind(view)
    viewModel.resume.observe(viewLifecycleOwner) { update(it) }
  }

  private fun update(resumeModel: ResumeModel) {
    binding?.let {
      it.name.text = resumeModel.general.name
      it.currentTitle.text = resumeModel.general.currentTitle
      it.location.text = resumeModel.general.location
      it.intro.text = resumeModel.general.intro
    }
  }
}