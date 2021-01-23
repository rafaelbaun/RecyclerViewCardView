package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts =  new ArrayList<>();
        contacts.add( new Contact("Margot Robbie", "Margot@gmail.com", "https://image.gala.de/21589264/t/hR/v4/w960/r0.6667/-/margot-robbie-sie-verarscht-harry.jpg"));
        contacts.add(new Contact("Cillian Murphy", "m Cilli@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg"));
        contacts.add(new Contact("Saoirse Ronan", "Saoise@gmail.com", "https://ifi.ie/wp-content/uploads/2020/01/saoirse-2-scaled.jpg"));
        contacts.add(new Contact("Emma Watson", "EmmaWw@gmail.com", "https://cache.net-a-porter.com/content/images/story-body-content-V1-0-1537350316166.jpeg/w1900_q65.jpeg"));
        contacts.add(new Contact("Christian Bale","ChristianB@gmail.com", "https://media.gq-magazin.de/photos/5e6643deb379200008952fed/16:9/w_1920,c_limit/christian-bale.jpg"));

        //Adapter erstellen
        ContacsRecViewAdapter adapter = new ContacsRecViewAdapter(this);

        //Dem Adapter die Liste übergeben
        adapter.setContacts(contacts);

        //Dem Recycler View die Liste mithilde des Adapters übergeben
        contactsRecView.setAdapter(adapter);

        //Muss aufgerufen werden, damit dargestellt werden kann, wie sich das Layout verhaltet
        //Entweder Gridlayoutmanager oder RelativeLayoutManager
        contactsRecView.setLayoutManager(new GridLayoutManager(this,2));





    }

}