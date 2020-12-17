package com.illdwyer.b.resume.features.resume

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.illdwyer.b.resume.data.ResumeModel

class ResumeViewModel : ViewModel() {
  val resume = MutableLiveData<ResumeModel>()
}