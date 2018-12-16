package com.example.user.alpha3;

import android.content.ClipData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    EditText Name, Value;
    ListView list;

    DatabaseReference ref;
    List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.Name);
        Value = (EditText)findViewById(R.id.Value);
        list = (ListView)findViewById(R.id.list);
        ref= FirebaseDatabase.getInstance().getReference("items");

        itemList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

        ref.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemList.clear();
                for(DataSnapshot itemSnapshot : dataSnapshot.getChildren() ){
                    Item item = itemSnapshot.getValue(Item.class);
                    itemList.add(item);
                }

                ItemList adapter = new ItemList(Main.this, itemList);
                list.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }));
    }

    public void upload(View view) {
        String name= Name.getText().toString();
        String value= Value.getText().toString();

        if (!name.isEmpty() && !value.isEmpty()){
            String id = ref.push().getKey();
            Item item= new Item(id, name, Integer.parseInt(value));
            ref.child(id).setValue(item);
        }
    }

    public void next(View view) {
        Intent t= new Intent(this, XMLParsing.class);
        startActivity(t);
    }
}
