package com.atlasrider.billdwyer.features.resume

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.atlasrider.billdwyer.R

class PositionAdapter(private val experience: Array<ResumeModel.Position>) : RecyclerView.Adapter<PositionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_resume_position_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = experience[position].title
        holder.company.text = experience[position].company
        holder.location.text = experience[position].location
        //        holder.duration.setText(experience[position].getDuration());
//        holder.description.setText(experience[position].getDescription());
    }

    override fun getItemCount(): Int {
        return experience.size
    }

    // TODO: Convert to use databinding
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var company: TextView
        var location: TextView

        //        TextView duration;
        //        TextView description;
        init {
            title = view.findViewById(R.id.position_title)
            company = view.findViewById(R.id.position_company)
            location = view.findViewById(R.id.position_location)
            //            duration = view.findViewById(R.id.position_duration);
//            description = view.findViewById(R.id.position_description);
        }
    }
}