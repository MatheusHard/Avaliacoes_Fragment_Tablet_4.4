package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;
import com.example.matheushardman.avaliacoes_tablet.classes.Uf;
import com.example.matheushardman.avaliacoes_tablet.db.Db_Avaliacao;
import com.example.matheushardman.avaliacoes_tablet.utils.Utils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Resultado extends Fragment {

    private RadioGroup radioGroupAgente;
    private RadioButton radioButtonACS, radioButtonACE;
    private int radioChecado = 0;
    private int type_agente = 0;
    private Context context;
    Db_Avaliacao db_avaliacao;
    private int posicao = 0;
    private Button buttonResultado, buttonListasAvaliacoes;
    private Spinner spinnerResultado;
    private FragmentTransaction transaction;
    private int id_cidade = 0;
    private String cidade;
    public Fragment_Resultado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment__resultado, container, false);

        spinnerResultado = v.findViewById(R.id.spinnerResultado);
        radioGroupAgente = v.findViewById(R.id.radioGroupAgente);
        radioButtonACS = v.findViewById(R.id.radioButtonACS);
        radioButtonACE = v.findViewById(R.id.radioButtonACE);

        /*ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this.getActivity(),
                android.R.layout.simple_spinner_item,
                //arrayCidades);
                db_avaliacao.getCidades());*/
        ArrayAdapter adapter = new ArrayAdapter(
                this.getActivity(),
                android.R.layout.simple_spinner_item,
                getCidadesUfs());
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerResultado.setAdapter(adapter);
        spinnerResultado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {

                Uf uf = (Uf) adapter.getItemAtPosition(position);
                posicao = position;
                cidade  = String.valueOf(uf.getCidade().getDescricao()+"-"+uf.getDescricao());
                id_cidade = uf.getCidade().getId_cidade();
                //cidade = (String) adapter.getItemAtPosition(position);
                //posicao = position

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


                /***********************************RADIOGROUP AGENTE*****************************************/

                radioChecado = radioGroupAgente.getCheckedRadioButtonId();
                if (radioChecado > 0) {
                    switch (radioChecado) {
                        case R.id.radioButtonACS:
                            type_agente = Utils.TIPO_ACS;
                            break;
                        case R.id.radioButtonACE:
                            type_agente = Utils.TIPO_ACE;
                            break;
                    }
                }

                if(id_cidade > 0 && type_agente > 0) {

                    Utils.showToast(context, "Listando Avaliações..");
                    Fragment_Listar_Avaliacoes fragmentListarAvaliacoes = new Fragment_Listar_Avaliacoes();
                    Bundle bundle = new Bundle();
                    bundle.putInt("agente", type_agente);
                    bundle.putString("cidadeNome", cidade);
                    bundle.putInt("cidadeId", id_cidade);
                    fragmentListarAvaliacoes.setArguments(bundle);
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, fragmentListarAvaliacoes); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();

                }else{
                    Utils.showToast(context, "Preencha todos os campos!!!");
                    }

            }
        });

        //Exibir o Resultado da Soma das Avaliações da Cidade:
        buttonResultado = v.findViewById(R.id.buttonResultado);
        buttonResultado.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /***********************************RADIOGROUP AGENTE*****************************************/

                radioChecado = radioGroupAgente.getCheckedRadioButtonId();
                if (radioChecado > 0) {
                    switch (radioChecado) {
                        case R.id.radioButtonACS:
                            type_agente = Utils.TIPO_ACS;
                            break;
                        case R.id.radioButtonACE:
                            type_agente = Utils.TIPO_ACE;
                            break;
                    }
                }
                if(id_cidade > 0 && type_agente > 0) {

                    Utils.showToast(context, "Acessando Exibindo Total Avaliações..");
                    Fragment_Exibir_Total_Excel fragmentExibirTotalExcel = new Fragment_Exibir_Total_Excel();
                    Bundle bundle = new Bundle();
                    bundle.putInt("agente", type_agente);
                    bundle.putString("cidadeNome", cidade);
                    bundle.putInt("cidadeId", id_cidade);
                    fragmentExibirTotalExcel.setArguments(bundle);
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, fragmentExibirTotalExcel ); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();

                }else{

                    Utils.showToast(context, "Preencha todos os campos!!!");
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

    private ArrayList<Uf> getCidadesUfs() {

        ArrayList<Uf> arrayListCidadesUfs = new ArrayList<>();

        arrayListCidadesUfs = db_avaliacao.getCidadesUf();
        db_avaliacao.close();

        return arrayListCidadesUfs;

    }

}
