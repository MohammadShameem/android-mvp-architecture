package io.left.core.assignmentone.ui.assignment_one;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.left.core.assignmentone.data.local.assignment.Assigment;
import io.left.core.util.R;

/**
 * Created by shameem on 16/01/2018.
 */



public class AssigmentAdapter extends RecyclerView.Adapter<AssigmentAdapter.MyViewHolder> {

    private List<Assigment> assigmentList;



    public AssigmentAdapter(List<Assigment> assigmentList) {
        this.assigmentList = assigmentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_assignmet, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Assigment assigment = assigmentList.get(position);
        holder.textviewDes.setText(assigment.getmDescription());

    }

    @Override
    public int getItemCount() {
        return assigmentList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textviewDes, textviewDesignation;

        public MyViewHolder(View view) {
            super(view);
            textviewDes = (TextView) view.findViewById(R.id.textview_des);

        }
    }

}
