package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContacsRecViewAdapter extends RecyclerView.Adapter<ContacsRecViewAdapter.ViewHolder>{

    private ArrayList<Contact> contacts = new ArrayList<>();

    private Context context;

    public ContacsRecViewAdapter(Context context) {
        this.context= context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View Object muss erstellt werden
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacs_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        //Es wird festgelegt was in der View dargestellt wird

        holder.textView.setText(contacts.get(position).getName());

        //Jedes Item klickbar machen
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contacts.get(position).getName() + "selected", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
// In dieser Klasse wird die Stelle, das Layout festgelegt in der die Daten da gestellt
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private RelativeLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtName);
            parent = itemView.findViewById(R.id.parent);
        }
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;

        //Daten werden geupdated
        notifyDataSetChanged();
    }
}
