package com.atlasrider.billdwyer.model

@Suppress("unused")
class ResumeModel(
        val general: General,
        val education: Education,
        val experience: Array<Position>,
        val skills: Array<SkillCategory>,
        val recommendations: Array<Recommendation>) {

    class General(
            val name: String,
            val currentTitle: String,
            val location: String,
            val intro: String)
    class Education(
            val start: String,
            val end: String,
            val location: String,
            val degree: String,
            val majors: Array<String>)
    class Position(
            val id: Int,
            val title: String,
            val company: String,
            val companyLogo: String,
            val location: String,
            val start: String,
            val end: String,
            val description: Array<String>)
    class SkillCategory(
            val category: String,
            val icon: String,
            val skills: Array<Skill>)
    class Skill(
            val label: String,
            val icon: String)
    class Recommendation(
            val name: String,
            val title: String,
            val company: String,
            val date: String,
            val description: String)
}