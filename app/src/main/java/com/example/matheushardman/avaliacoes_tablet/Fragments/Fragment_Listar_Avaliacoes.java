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
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.Adapters.AdapterAvaliacao;
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
    Avaliacao avaliacaoEscolhida = null;
    private AlertDialog alerta;
    private FragmentTransaction transaction;
    private TextView textViewSim1, textViewNao1, textViewClareza2, textViewAplicacao3, textViewCargaHoraria4,
            textViewConhecimentoInstrutor5, textViewClareza6, textViewDisponibilidade7, textViewConhecimento8,
            textViewClareza9, textViewDisponibilidade10, textViewNomeCidade, textViewSugestao11, textViewVazio;


    public Fragment_Listar_Avaliacoes() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment__listar__avaliacoes, container, false);

        textViewCidadeNome = v.findViewById(R.id.textViewCidadeNome);
        listViewAvaliacoes = v.findViewById(R.id.listViewAvaliacoes);
        textViewVazio = v.findViewById(R.id.textViewVazio);
        registerForContextMenu(listViewAvaliacoes);


        Bundle bundle = getArguments();

        cidadeNome = bundle.getString("cidadeNome");
        cidadeId = bundle.getInt("cidadeId");

        textViewCidadeNome.setText(cidadeNome);

        /****************FUNCIONANDO********************/
     /*  listViewAvaliacoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        });*/


        listViewAvaliacoes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                avaliacao = (Avaliacao) adapter.getItemAtPosition(position);
                avaliacaoEscolhida = (Avaliacao) adapter.getItemAtPosition(position);
                return false;
            }
        });


        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("MENU AVALIAÇÃO");


        //menu.setHeaderIcon(R.drawable.botao_add);
        MenuItem menuDelete = menu.add(Menu.NONE, 1, Menu.NONE, "DELETAR");
        MenuItem menuEditar = menu.add(Menu.NONE, 2, Menu.NONE, "EDITAR");
        MenuItem menuResumo = menu.add(Menu.NONE, 3, Menu.NONE, "RESUMO");



        menuEditar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Toast.makeText(getContext(), "Entrando Editar Avaliação!!!", Toast.LENGTH_SHORT).show();
                Fragment_Editar_Avaliacao fragmentEditarAvaliacoes = new Fragment_Editar_Avaliacao();
                Bundle bundle = new Bundle();
                bundle.putString("cidadeNome", cidadeNome);
                bundle.putSerializable("avaliacao-escolhida", avaliacaoEscolhida);
                fragmentEditarAvaliacoes.setArguments(bundle);
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, fragmentEditarAvaliacoes ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
                return false;
            }
        });
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                dialogExcluir();
                return true;
            }
        });
        menuResumo.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getContext(), "Entrando Resumo Avaliação!!!", Toast.LENGTH_SHORT).show();
                dialogResumo();
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

        if(arrayAvaliacoes != null && arrayAvaliacoes.size() > 0){
            //adapter = new ArrayAdapter<Avaliacao>(MainActivity_Listar_Avaliacoes.this, android.R.layout.simple_list_item_1, arrayAvaliacoes);
            adapter = new ArrayAdapter<Avaliacao>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, arrayAvaliacoes);
            listViewAvaliacoes.setAdapter(adapter);
            textViewVazio.setVisibility(TextView.INVISIBLE);

        } else{
            textViewVazio.setText("OPS!!!, não existem Avaliações...");
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
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity_Listar_Avaliacoes.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    private void dialogResumo(){

        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = li.inflate(R.layout.avaliacao, null);

        textViewSim1 = view.findViewById(R.id.textViewSim1);
        textViewSim1 = view.findViewById(R.id.textViewSim1);
        textViewNao1 = view.findViewById(R.id.textViewNao1);
        textViewClareza2 = view.findViewById(R.id.textViewClareza2);
        textViewAplicacao3 = view.findViewById(R.id.textViewAplicacao3);
        textViewCargaHoraria4 = view.findViewById(R.id.textViewCargaHoraria4);
        textViewConhecimentoInstrutor5 = view.findViewById(R.id.textViewConhecimentoInstrutor5);
        textViewClareza6 = view.findViewById(R.id.textViewClareza6);
        textViewDisponibilidade7 = view.findViewById(R.id.textViewDisponibilidade7);
        textViewConhecimento8 = view.findViewById(R.id.textViewConhecimento8);
        textViewClareza9 = view.findViewById(R.id.textViewClareza9);
        textViewDisponibilidade10 = view.findViewById(R.id.textViewDisponibilidade10);
        textViewSugestao11 = view.findViewById(R.id.textViewSugestao11);

        textViewSim1.setText(String.format(getResources().getString(R.string.sim) +" "+ avaliacao.getRadioSim_1()));
        textViewNao1.setText(String.format(getResources().getString(R.string.nao)+" "+ avaliacao.getRadioNao_1()));

        textViewClareza2.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+avaliacao.getRadioMuito_2()+"\n"+
                getResources().getString(R.string.bom2)+" "+avaliacao.getRadiobom_2()+"\n"+getResources().getString(R.string.regular2)+" "+avaliacao.getRadioRegular_2()+"\n"+
                getResources().getString(R.string.ruim2)+" "+avaliacao.getRadioRuim_2()));


        textViewAplicacao3.setText(String.format(getResources().getString(R.string.seguro)+" "+avaliacao.getRadioSeguro_3()
                +"\n"+getResources().getString(R.string.pouco_seguro) +" "+ avaliacao.getRadioPoucoSeguro_3()+"\n"+getResources().getString(R.string.inseguro)+" "+avaliacao.getRadioInseguro_3()));

        textViewCargaHoraria4.setText(String.format(getResources().getString(R.string.excessiva)+" "+avaliacao.getRadioExcessiva_4()+"\n"+
                getResources().getString(R.string.razoavel)+" "+avaliacao.getRadioRazoavel_4()+"\n"+getResources().getString(R.string.insuficiente)+" "+avaliacao.getRadioInsuficiente_4()));

        textViewConhecimentoInstrutor5.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+avaliacao.getRadioMuito_5()+"\n"+
                getResources().getString(R.string.bom2)+" "+avaliacao.getRadiobom_5()+"\n"+getResources().getString(R.string.regular2)+" "+avaliacao.getRadioRegular_5()+"\n"+
                getResources().getString(R.string.ruim2)+" "+avaliacao.getRadioRuim_5()));

        textViewClareza6.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+avaliacao.getRadioMuito_6()+"\n"+
                getResources().getString(R.string.bom2)+" "+avaliacao.getRadiobom_6()+"\n"+getResources().getString(R.string.regular2)+" "+avaliacao.getRadioRegular_6()+"\n"+
                getResources().getString(R.string.ruim2)+" "+avaliacao.getRadioRuim_6()));

        textViewDisponibilidade7.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+avaliacao.getRadioMuito_7()+"\n"+
                getResources().getString(R.string.bom2)+" "+avaliacao.getRadiobom_7()+"\n"+getResources().getString(R.string.regular2)+" "+avaliacao.getRadioRegular_7()+"\n"+
                getResources().getString(R.string.ruim2)+" "+avaliacao.getRadioRuim_7()));

        textViewConhecimento8.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+avaliacao.getRadiobom_8()+"\n"+
                getResources().getString(R.string.bom2)+" "+avaliacao.getRadiobom_8()+"\n"+getResources().getString(R.string.regular2)+" "+avaliacao.getRadioRegular_8()+"\n"+
                getResources().getString(R.string.ruim2)+" "+avaliacao.getRadioRuim_8()));

        textViewClareza9.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+avaliacao.getRadioMuito_9()+"\n"+
                getResources().getString(R.string.bom2)+" "+avaliacao.getRadiobom_9()+"\n"+getResources().getString(R.string.regular2)+" "+avaliacao.getRadioRegular_9()+"\n"+
                getResources().getString(R.string.ruim2)+" "+avaliacao.getRadioRuim_9()));

        textViewDisponibilidade10.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+avaliacao.getRadioMuito_10()+"\n"+
                getResources().getString(R.string.bom2)+" "+avaliacao.getRadiobom_10()+"\n"+getResources().getString(R.string.regular2)+" "+avaliacao.getRadioRegular_10()+"\n"+
                getResources().getString(R.string.ruim2)+" "+avaliacao.getRadioRuim_10()));

        textViewSugestao11.setText(avaliacao.getSugestoes());

        //definimos para o botão do layout um clickListener
        view.findViewById(R.id.buttonResumo).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //exibe um Toast informativo.
               // Toast.makeText(getContext(), "alerta.dismiss()", Toast.LENGTH_SHORT).show();
                //desfaz o alerta.
                alerta.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Titulo");
        builder.setView(view);
        builder.setCancelable(false);
        alerta = builder.create();
        alerta.show();
    }
}




