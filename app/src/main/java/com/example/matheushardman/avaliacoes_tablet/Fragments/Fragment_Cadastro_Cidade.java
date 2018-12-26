package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;
import com.example.matheushardman.avaliacoes_tablet.classes.Cidade;
import com.example.matheushardman.avaliacoes_tablet.classes.Uf;
import com.example.matheushardman.avaliacoes_tablet.db.Db_Avaliacao;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Cadastro_Cidade extends Fragment {

    private ArrayList<String> arrayListCidades;
    Db_Avaliacao db_avaliacao;
    private Context context;
    private Button buttonCadastrarCidadeUf;
    private EditText editTextCadastroCidade;
    private Spinner spinnerEstados;


    private String  descricaoUf = null;
    private int posicao = 0;
    private int cod_uf = 0;


    public Fragment_Cadastro_Cidade() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment__cadastro__cidade, container, false);

        editTextCadastroCidade = v.findViewById(R.id.editTextCadastroCidade);
        buttonCadastrarCidadeUf = v.findViewById(R.id.buttonCadastrarCidadeUf);

        spinnerEstados = v.findViewById(R.id.spinnerEstados);

        ArrayAdapter adapter = new ArrayAdapter(
                                                this.getActivity(),
                                                android.R.layout.simple_spinner_item,
                                                getUfs());

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerEstados.setAdapter(adapter);

        spinnerEstados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {

                Uf uf = (Uf) adapter.getItemAtPosition(position);
                //descricaoUf = adapter.getItemAtPosition(position).toString();
                descricaoUf = uf.getDescricao();
                cod_uf = uf.getId_uf();

                posicao = position;
                Toast.makeText(getContext(), descricaoUf + String.valueOf(cod_uf), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        buttonCadastrarCidadeUf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cidade c = new Cidade();

                if(cod_uf > 0){

                    //if((editTextCadastroCidade.getText().toString().equals("") || editTextCadastroCidade.getText().toString().equals(null))) {
                      if(editTextCadastroCidade.getText().toString().length() < 1){
                          editTextCadastroCidade.setError("Preenchimento obrigatório!!!");
                          editTextCadastroCidade.requestFocus();
                        //Toast.makeText(getContext(), "Preencha Campo Obrigatórios!!!", Toast.LENGTH_SHORT).show();

                    }else{



                        c.setDescricao(editTextCadastroCidade.getText().toString().toUpperCase());
                        c.setCod_uf(cod_uf);


                        validarCidade(c);
                        carregarUfId(cod_uf);

                        carregarCidadesUfs();

                    }}else{
                    Toast.makeText(getContext(), "Escolha um Estado!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        db_avaliacao = new Db_Avaliacao(context);
        super.onAttach(context);
    }
    private void carregarCidades() {

        arrayListCidades = db_avaliacao.getCidades();
        db_avaliacao.close();


        if (arrayListCidades !=  null) {

            for (String c: arrayListCidades) {

                Log.i("**********","***");
                Log.i("CIDADE - DESCRICAO", String.valueOf(c));

            }
        }
    }


    private void carregarUfs() {

    ArrayList<Uf> arrayListUfs = new ArrayList<>();

        arrayListUfs = db_avaliacao.getUfs();
        db_avaliacao.close();


        if (arrayListUfs !=  null) {

            for (Uf u: arrayListUfs) {

                Log.i("**********","***");
                Log.i("UF - ID", String.valueOf(u.getId_uf()));
                Log.i("UF - DESCRICAO", u.getDescricao());

            }
        }
    }


    private ArrayList<Uf> getUfs() {

        ArrayList<Uf> arrayListUfs = new ArrayList<>();

        arrayListUfs = db_avaliacao.getUfs();
        db_avaliacao.close();

        return arrayListUfs;
    }

    private void carregarCitys() {

        ArrayList<Cidade> arrayListCidades = new ArrayList<>();

        arrayListCidades = db_avaliacao.getCitys();
        db_avaliacao.close();


        if (arrayListCidades !=  null) {

            for (Cidade c: arrayListCidades) {

                Log.i("**********","***");
                Log.i("CITY - ID", String.valueOf(c.getId_cidade()));
                Log.i("CITY - DESCRICAO", c.getDescricao());
                Log.i("CITY - COD_UF", String.valueOf(c.getCod_uf()));

            }
        }
    }

    private void carregarCidadesUfs() {

        ArrayList<Uf> arrayListCidadesUfs = new ArrayList<>();

        arrayListCidadesUfs = db_avaliacao.getCidadesUf();
        db_avaliacao.close();

        if (arrayListCidadesUfs !=  null) {

            for (Uf u: arrayListCidadesUfs ) {

                Log.i("**********","***");
                Log.i("CIDADE - ID_CIDADE", String.valueOf(u.getCidade().getId_cidade()));
                Log.i("CIDADE - ID_UF", String.valueOf(u.getId_uf()));
                Log.i("CIDADE - DESC_CIDADE", u.getCidade().getDescricao());
                Log.i("CIDADE - DESC_UF", u.getDescricao());

            }
        }
    }


    private void validarCidade(Cidade cidade) {

        try{

            /*****PEGAR A UF ANTES PARA COMPARAR*****/
            Uf estado  = db_avaliacao.getUfId(cidade.getCod_uf());
            boolean sinalVerde = true;
            ArrayList<Uf> arrayListCidadesUfs = new ArrayList<>();
            arrayListCidadesUfs = db_avaliacao.getCidadesUf();
            db_avaliacao.close();

            if (arrayListCidadesUfs != null) {

                for (Uf uf : arrayListCidadesUfs) {
                    //Comparar cidade e uf do cadastro, para saber se ja existe essa cidade cadastrada nessa UF.
                    if(uf.getCidade().getDescricao().equals(cidade.getDescricao()) && cidade.getCod_uf() == uf.getId_uf()){
                        sinalVerde = false;
                    }}

                if(sinalVerde) {

                    Uf u = new Uf();
                    u.setCidade(cidade);
                    db_avaliacao.inserirCidade(u);

                    Toast.makeText(getContext(), "Cidade cadastrada com sucesso!!!", Toast.LENGTH_SHORT).show();
                    Fragment_Cidades someFragment = new Fragment_Cidades();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, someFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();

                }else{
                    Toast.makeText(getContext(), "Cidade já existe!!!", Toast.LENGTH_SHORT).show();
                }
            }

        }catch (Exception e){

            Toast.makeText(getContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }


    private void carregarUfId(int cod) {

        Uf uf  = db_avaliacao.getUfId(cod);
        db_avaliacao.close();

        if (uf !=  null) {

            Log.i("**********","***");
            Log.i("UF - ID", String.valueOf(uf.getId_uf()));
            Log.i("UF - DESCRICAO", String.valueOf(uf.getDescricao()));

        }
    }
}


