package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;
import com.example.matheushardman.avaliacoes_tablet.db.Db_Avaliacao;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Resultado extends Fragment {


    private Context context;
    Db_Avaliacao db_avaliacao;
    private int posicao = 0;
    private Button buttonResultado, buttonListasAvaliacoes;
    private Spinner spinnerResultado;
    private FragmentTransaction transaction;

    private String cidade;
    public Fragment_Resultado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment__resultado, container, false);
        spinnerResultado = v.findViewById(R.id.spinnerResultado);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this.getActivity(),
                android.R.layout.simple_spinner_item,
                //arrayCidades);
                db_avaliacao.getCidades());
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerResultado.setAdapter(adapter);
        spinnerResultado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {

                posicao = position;
                cidade = (String) adapter.getItemAtPosition(position);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Vai para a Tela das Avaliações da Cidade
        buttonListasAvaliacoes = v.findViewById(R.id.buttonListasAvaliacoes);
        buttonListasAvaliacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(posicao > 0) {

                    Toast.makeText(getContext(), "Listando Avaliações..", Toast.LENGTH_LONG).show();
                    Fragment_Listar_Avaliacoes fragmentListarAvaliacoes = new Fragment_Listar_Avaliacoes();
                    Bundle bundle = new Bundle();
                    bundle.putString("cidadeNome", cidade);
                    bundle.putInt("cidadeId", posicao);
                    fragmentListarAvaliacoes.setArguments(bundle);
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, fragmentListarAvaliacoes); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();

                }else{

                    Toast.makeText(getContext(), "Escolha uma Cidade!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Exibir o Resultado da Soma das Avaliações da Cidade:
        buttonResultado = v.findViewById(R.id.buttonResultado);
        buttonResultado.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(posicao > 0) {

                    Toast.makeText(getContext(), "Acessando Exibindo Total Avaliações..", Toast.LENGTH_LONG).show();
                    Fragment_Exibir_Total_Excel fragmentExibirTotalExcel = new Fragment_Exibir_Total_Excel();
                    Bundle bundle = new Bundle();
                    bundle.putString("cidadeNome", cidade);
                    bundle.putInt("cidadeId", posicao);
                    fragmentExibirTotalExcel.setArguments(bundle);
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, fragmentExibirTotalExcel ); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();

                }else{

                    Toast.makeText(getContext(), "Escolha uma Cidade!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        db_avaliacao = new Db_Avaliacao(context);
        super.onAttach(context);
    }

}
