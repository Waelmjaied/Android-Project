package tn.essat.miniprojetmjaiedwael;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapt extends BaseAdapter {

    private Context context;
    private List<Matiere> lm;

    public ListAdapt(Context context, List<Matiere> listMat) {
        this.context = context;
        this.lm = listMat;
    }

    @Override
    public int getCount() {
        return lm.size();
    }

    @Override
    public Object getItem(int position) {
        return lm.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lm.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_adapt, parent, false);
        }
        Matiere mat = lm.get(position);
        TextView titre = convertView.findViewById(R.id.tx1);
        TextView niveau = convertView.findViewById(R.id.tx2);

        titre.setText(mat.getTitre());
        niveau.setText(mat.getNiveau());
        return convertView;


    }
}