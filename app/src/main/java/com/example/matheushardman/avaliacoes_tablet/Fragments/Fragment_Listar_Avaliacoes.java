package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;
import com.example.matheushardman.avaliacoes_tablet.classes.Avaliacao;
import com.example.matheushardman.avaliacoes_tablet.db.Db_Avaliacao;

import java.util.ArrayList;


public class Fragment_Listar_Avaliacoes extends Fragment {

    Db_Avaliacao db_avaliacao;
    Context context;
    private String cidadeNome;
    private int cidadeId;
    private TextView textViewCidadeNome;
    private ListView listViewAvaliacoes;
    private ArrayList<Avaliacao> arrayAvaliacoes;
    private ArrayAdapter<Avaliacao> adapter;
    Avaliacao avaliacao = new Avaliacao();
    private AlertDialog alerta;
    private FragmentTransaction transaction;


    public Fragment_Listar_Avaliacoes() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment__listar__avaliacoes, container, false);

        textViewCidadeNome = v.findViewById(R.id.textViewCidadeNome);
        listViewAvaliacoes = v.findViewById(R.id.listViewAvaliacoes);
        registerForContextMenu(listViewAvaliacoes);


        Bundle bundle = getArguments();

        cidadeNome = bundle.getString("cidadeNome");
        cidadeId = bundle.getInt("cidadeId");

        textViewCidadeNome.setText(cidadeNome);


        listViewAvaliacoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                Avaliacao avaliacaoEscolhida = (Avaliacao) adapter.getItemAtPosition(position);
                Toast.makeText(getContext(), "Entrando Editar Avaliação!!!", Toast.LENGTH_SHORT).show();
                Fragment_Editar_Avaliacao fragmentEditarAvaliacoes = new Fragment_Editar_Avaliacao();
                Bundle bundle = new Bundle();
                bundle.putString("cidadeNome", cidadeNome);
                bundle.putSerializable("avaliacao-escolhida", avaliacaoEscolhida);
                fragmentEditarAvaliacoes .setArguments(bundle);
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, fragmentEditarAvaliacoes ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
                }
        });

        listViewAvaliacoes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                avaliacao= (Avaliacao) adapter.getItemAtPosition(position);
                return false;
            }
        });

        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Deletar Avaliação");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                dialogExcluir();

                return true;
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        db_avaliacao = new Db_Avaliacao(context);
        super.onAttach(context);
    }

    @Override
    public void onResume() {

        super.onResume();
        carregarAvalicoes(cidadeId);

    }
    public void carregarAvalicoes(int cidadeId){

        arrayAvaliacoes = db_avaliacao.getAvaliacoesCidade(cidadeId);

        db_avaliacao.close();

        if(arrayAvaliacoes != null){
            /*????????????????????*/
            //adapter = new ArrayAdapter<Avaliacao>(MainActivity_Listar_Avaliacoes.this, android.R.layout.simple_list_item_1, arrayAvaliacoes);
            adapter = new ArrayAdapter<Avaliacao>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, arrayAvaliacoes);
            listViewAvaliacoes.setAdapter(adapter);

        }
    }

    private void dialogExcluir() {

        //Cria o gerador do AlertDialog

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()); /*????????????????????*/
        //define o titulo
        builder.setTitle("Avaliação");
        //define a mensagem
        builder.setMessage("Deseja excuir esta avaliação ?");
        //define um botão como positivo
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                Toast.makeText(getContext(), "Avaliação excluida com sucesso!!!", Toast.LENGTH_SHORT).show();
                db_avaliacao.deletarAvaliacao(avaliacao);
                db_avaliacao.close();
                carregarAvalicoes(cidadeId);
                //Toast.makeText(MainActivity_Listar_Avaliacoes.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity_Listar_Avaliacoes.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }


}

