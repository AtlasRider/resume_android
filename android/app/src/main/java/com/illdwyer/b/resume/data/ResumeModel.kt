package com.illdwyer.b.resume.data

@Suppress("unused")
data class ResumeModel(
  val general: General,
  val education: Education,
  val experience: List<Position>,
  val skills: List<SkillCategory>,
  val recommendations: List<Recommendation>
) {

  data class General(
    val name: String = "",
    val currentTitle: String = "",
    val location: String = "",
    val intro: String = ""
  )

  data class Education(
    val college: String,
    val start: String,
    val end: String,
    val location: String,
    val degree: String,
    val majors: List<String>
  )

  data class SkillCategory(
    val category: String, val icon: String, val skills: List<Skill>
  ) {
    data class Skill(
      val label: String, val icon: String
    )
  }

  data class Position(
    val id: Int,
    val title: String,
    val company: String,
    val companyLogo: String,
    val location: String,
    val start: String,
    val end: String,
    val description: List<String>
  )

  data class Recommendation(
    val name: String,
    val title: String,
    val company: String,
    val date: String,
    val description: String
  )
}