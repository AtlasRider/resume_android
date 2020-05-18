package com.atlasrider.billdwyer.features.resume;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atlasrider.billdwyer.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PositionAdapter extends RecyclerView.Adapter<PositionAdapter.ViewHolder> {

    private final ResumeModel.Position[] experience;

    public PositionAdapter(ResumeModel.Position[] experience) {
        this.experience = experience;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_resume_position_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(experience[position].getTitle());
        holder.company.setText(experience[position].getCompany());
        holder.location.setText(experience[position].getLocation());
//        holder.duration.setText(experience[position].getDuration());
//        holder.description.setText(experience[position].getDescription());
    }

    @Override
    public int getItemCount() {
        return experience.length;
    }

    // TODO: Convert to use databinding
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView company;
        TextView location;
//        TextView duration;
//        TextView description;

        public ViewHolder(@NonNull View view) {
            super(view);

            title = view.findViewById(R.id.position_title);
            company = view.findViewById(R.id.position_company);
            location = view.findViewById(R.id.position_location);
//            duration = view.findViewById(R.id.position_duration);
//            description = view.findViewById(R.id.position_description);
        }
    }
}
