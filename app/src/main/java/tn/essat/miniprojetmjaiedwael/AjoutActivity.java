package tn.essat.miniprojetmjaiedwael;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AjoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        Button AjoutM = findViewById(R.id.btnAjout);
        AjoutM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ttr = findViewById(R.id.tx1);
                String matiere = ttr.getText().toString();
                EditText nv = findViewById(R.id.tx2);
                String classe = nv.getText().toString();
                TextView Message = findViewById(R.id.textViewMessage);

                if (matiere.equals("") || classe.equals("")){
                    Message.setText("Le Titre et le Niveau ne doivent pas etre vide !!! ");
                    return;
                }

                Mabase bd = new Mabase(getApplicationContext(), "mabase.db", null, 1);
                SQLiteDatabase table = bd.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("titre", matiere);
                values.put("niveau", classe);
                table.insert("Matiere", null, values);

                Intent i2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i2);
            }
        });

    }
}