package tn.essat.miniprojetmjaiedwael;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mabase bd = new Mabase(getApplicationContext(), "mabase.db", null, 1);
        SQLiteDatabase table = bd.getWritableDatabase();

        List<Matiere> lm = new ArrayList<>();

        Cursor cr = table.query("Matiere", new String[]{"id", "titre", "niveau"}, null, null, null, null, null);
        cr.moveToFirst();

        while(!cr.isAfterLast()) {
            int id = Integer.parseInt(cr.getString(0));
            String titre = cr.getString(1);
            String niveau = cr.getString(2);
            Matiere matiere = new Matiere(id, titre, niveau);
            lm.add(matiere);
            cr.moveToNext();
        }
        cr.close();
        ListView lv = findViewById(R.id.listview1);
        ListAdapt adp= new ListAdapt(getApplicationContext(),lm);
        lv.setAdapter(adp);

        Button Ajout = findViewById(R.id.btnAdd);
        Ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), AjoutActivity.class);
                startActivity(i1);
            }
        });

    }

}



/*
*/