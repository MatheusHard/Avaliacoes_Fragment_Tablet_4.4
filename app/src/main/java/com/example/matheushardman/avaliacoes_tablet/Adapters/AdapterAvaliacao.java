package com.example.matheushardman.avaliacoes_tablet.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matheushardman.avaliacoes_tablet.R;
import com.example.matheushardman.avaliacoes_tablet.classes.Avaliacao;

import java.util.ArrayList;

public class AdapterAvaliacao extends ArrayAdapter<Avaliacao> {

    private Context context;
    private ArrayList<Avaliacao> lista;

    public AdapterAvaliacao(Context context, ArrayList<Avaliacao> lista){
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Avaliacao avaliacaoPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.avaliacao, null);

       // TextView textViewId = convertView.findViewById(R.id.textViewId);
        //textViewId.setText(avaliacaoPosicao.getIdAv());

        //TextView textViewData= convertView.findViewById(R.id.textViewData);
        //textViewData.setText(avaliacaoPosicao.getData());


        //ImageView imageView = convertView.findViewById(R.id.imageView);
        //imageView.setImageResource(avaliacaoPosicao.getImagem());

        return  convertView;
    }


}
