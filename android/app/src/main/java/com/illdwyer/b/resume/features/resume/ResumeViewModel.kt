package com.illdwyer.b.resume.features.resume

class ResumeViewModel(model: ResumeModel)
    : ResumeModel(model.general,
        model.education,
        model.experience,
        model.skills,
        model.recommendations) {

    override val education: EducationViewModel =
            EducationViewModel(
                    super.education
            )

    class EducationViewModel(model: Education) : Education(model.college, model.start, model.end, model.location,
            model.degree, model.majors) {
        val duration: String = String.format("%s - %s", start, end)
        fun getMajorsAsString() = super.majors.joinToString()
    }
}