package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.example.recyclerviewexample.R.id.image;

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
        holder.txtEmail.setText(contacts.get(position).getEmail());

        //Jedes Item klickbar machen
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contacts.get(position).getName() + "selected", Toast.LENGTH_SHORT).show();

            }
        });

        //Um Bilder aus dem Internet zu laden mit URL Adressen, die in der App festgelegt sind wird die Glide Bibliothek implementiert und genutzt
        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImageURL())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
// In dieser Klasse wird die Stelle, das Layout festgelegt in der die Daten da gestellt
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView, txtEmail;
        private CardView parent;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            image = itemView.findViewById(R.id.image);

            parent = itemView.findViewById(R.id.parent);
        }
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;

        //Daten werden geupdated...
        notifyDataSetChanged();
    }
}
