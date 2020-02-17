package com.example.nodo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nodo.R;
import com.example.nodo.model.NoDo;
import java.util.List;

public class NoDoListAdapter extends RecyclerView.Adapter<NoDoListAdapter.NoDoViewHolder> {


    private final LayoutInflater noDoInflater;
    private List<NoDo> noDoList; //cached copy of nodo items


    public NoDoListAdapter(Context context) {
        noDoInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoDoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = noDoInflater.inflate(R.layout.recyclerview ,viewGroup, false);

        return new NoDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoDoViewHolder noDoViewHolder, int position) {

        if (noDoList != null) {
            NoDo current = noDoList.get(position);
            noDoViewHolder.noDoTextView.setText(current.getNodo());
        } else {
            noDoViewHolder.noDoTextView.setText(R.string.No_item);
        }
    }

    public void setNoDos(List<NoDo> noDos) {
        noDoList = noDos;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (noDoList != null)
            return noDoList.size();
        else return 0;
    }

    public class NoDoViewHolder extends RecyclerView.ViewHolder {
        public TextView noDoTextView;

        public NoDoViewHolder(@NonNull View itemView) {
            super(itemView);
            noDoTextView = itemView.findViewById(R.id.textView);
        }
    }
}
