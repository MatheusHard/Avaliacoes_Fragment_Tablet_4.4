package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;
import com.example.matheushardman.avaliacoes_tablet.classes.Avaliacao;
import com.example.matheushardman.avaliacoes_tablet.db.Db_Avaliacao;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Editar_Avaliacao extends Fragment {

    Db_Avaliacao db_avaliacao;
    private Context context;
    private int radioChecado = 0;
    private RadioGroup radioGroupEdit1, radioGroupEdit2, radioGroupEdit3, radioGroupEdit4, radioGroupEdit5, radioGroupEdit6, radioGroupEdit7, radioGroupEdit8, radioGroupEdit9, radioGroupEdit10;
    private RadioButton radioButtonEditSim1, radioButtonNaoEdit1, radioButtonOtimoEdit2, radioButtonBomEdit2, radioButtonRegularEdit2,
            radioButtonRuimEdit2, radioButtonSeguroEdit3, radioButtonPoucoSeguroEdit3, radioButtonInseguroEdit3,
            radioButtonExcessivaEdit4, radioButtonRazoavelEdit4, radioButtonInsuficienteEdit4,
            radioButtonOtimoEdit5, radioButtonBomEdit5, radioButtonRegularEdit5, radioButtonRuimEdit5,
            radioButtonOtimoEdit6, radioButtonBomEdit6, radioButtonRegularEdit6, radioButtonRuimEdit6,
            radioButtonOtimoEdit7, radioButtonBomEdit7, radioButtonRegularEdit7, radioButtonRuimEdit7,
            radioButtonOtimoEdit8, radioButtonBomEdit8, radioButtonRegularEdit8, radioButtonRuimEdit8,
            radioButtonOtimoEdit9, radioButtonBomEdit9, radioButtonRegularEdit9, radioButtonRuimEdit9,
            radioButtonOtimoEdit10, radioButtonBomEdit10, radioButtonRegularEdit10, radioButtonRuimEdit10;
    private EditText editTextAvaliacaoEdit;
    private String cidadeNome;
    private TextView textViewNomeCidadeE;
    private Button buttonEditarAvaliacao;
    private ArrayList<Avaliacao> arrayListAvaliacoes;
    Avaliacao a = null;
    private FragmentTransaction transaction;
    private int type_agente = 1;

    public Fragment_Editar_Avaliacao() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment__editar__avaliacao, container, false);

        //Intent it = getIntent();
        //a = (Avaliacao) it.getSerializableExtra("avaliacao-escolhida");
        //cidadeNome = it.getStringExtra("cidadeNome");

        Bundle bundle = getArguments();
        a = (Avaliacao) bundle.getSerializable("avaliacao-escolhida");
        cidadeNome = bundle.getString("cidadeNome");

        //TODO
        /*********************MANUTENÇÃO************************/

        carregarAvaliacoes(a.getIdCidade(), type_agente);

        textViewNomeCidadeE = v.findViewById(R.id.textViewNomeCidadeE);

        /***********************RADIOS*********************************/

        radioGroupEdit1 = v.findViewById(R.id.radioGroupEdit1);
        radioGroupEdit2 = v.findViewById(R.id.radioGroupEdit2);
        radioGroupEdit3 = v.findViewById(R.id.radioGroupEdit3);
        radioGroupEdit4 = v.findViewById(R.id.radioGroupEdit4);
        radioGroupEdit5 = v.findViewById(R.id.radioGroupEdit5);
        radioGroupEdit6 = v.findViewById(R.id.radioGroupEdit6);
        radioGroupEdit7 = v.findViewById(R.id.radioGroupEdit7);
        radioGroupEdit8 = v.findViewById(R.id.radioGroupEdit8);
        radioGroupEdit9 = v.findViewById(R.id.radioGroupEdit9);
        radioGroupEdit10 = v.findViewById(R.id.radioGroupEdit10);


        /***********************RADIOS BUTTONS*********************************/

        radioButtonEditSim1 = v.findViewById(R.id.radioButtonSimEdit1);
        radioButtonNaoEdit1 = v.findViewById(R.id.radioButtonNaoEdit1);

        radioButtonOtimoEdit2 = v.findViewById(R.id.radioButtonOtimoEdit2);
        radioButtonBomEdit2 = v.findViewById(R.id.radioButtonBomEdit2);
        radioButtonRegularEdit2= v.findViewById(R.id.radioButtonRegularEdit2);
        radioButtonRuimEdit2 = v.findViewById(R.id.radioButtonRuimEdit2);

        radioButtonSeguroEdit3 = v.findViewById(R.id.radioButtonSeguroEdit3);
        radioButtonPoucoSeguroEdit3 = v.findViewById(R.id.radioButtonPoucoseguroEdit3);
        radioButtonInseguroEdit3 = v.findViewById(R.id.radioButtonInseguroEdit3);

        radioButtonExcessivaEdit4 = v.findViewById(R.id.radioButtonExcessivaEdit4);
        radioButtonRazoavelEdit4= v.findViewById(R.id.radioButtonRazoavelEdit4);
        radioButtonInsuficienteEdit4= v.findViewById(R.id.radioButtonInsuficienteEdit4);

        radioButtonOtimoEdit5 = v.findViewById(R.id.radioButtonOtimoEdit5);
        radioButtonBomEdit5 = v.findViewById(R.id.radioButtonBomEdit5);
        radioButtonRegularEdit5 = v.findViewById(R.id.radioButtonRegularEdit5);
        radioButtonRuimEdit5 = v.findViewById(R.id.radioButtonRuimEdit5);

        radioButtonOtimoEdit6 = v.findViewById(R.id.radioButtonOtimoEdit6);
        radioButtonBomEdit6 = v.findViewById(R.id.radioButtonBomEdit6);
        radioButtonRegularEdit6 = v.findViewById(R.id.radioButtonRegularEdit6);
        radioButtonRuimEdit6 = v.findViewById(R.id.radioButtonRuimEdit6);

        radioButtonOtimoEdit7 = v.findViewById(R.id.radioButtonOtimoEdit7);
        radioButtonBomEdit7 = v.findViewById(R.id.radioButtonBomEdit7);
        radioButtonRegularEdit7 = v.findViewById(R.id.radioButtonRegularEdit7);
        radioButtonRuimEdit7 = v.findViewById(R.id.radioButtonRuimEdit7);

        radioButtonOtimoEdit8 = v.findViewById(R.id.radioButtonOtimoEdit8);
        radioButtonBomEdit8 = v.findViewById(R.id.radioButtonBomEdit8);
        radioButtonRegularEdit8 = v.findViewById(R.id.radioButtonRegularEdit8);
        radioButtonRuimEdit8 = v.findViewById(R.id.radioButtonRuimEdit8);

        radioButtonOtimoEdit9 = v.findViewById(R.id.radioButtonOtimoEdit9);
        radioButtonBomEdit9 = v.findViewById(R.id.radioButtonBomEdit9);
        radioButtonRegularEdit9 = v.findViewById(R.id.radioButtonRegularEdit9);
        radioButtonRuimEdit9 = v.findViewById(R.id.radioButtonRuimEdit9);

        radioButtonOtimoEdit10 = v.findViewById(R.id.radioButtonOtimoEdit10);
        radioButtonBomEdit10 = v.findViewById(R.id.radioButtonBomEdit10);
        radioButtonRegularEdit10 = v.findViewById(R.id.radioButtonRegularEdit10);
        radioButtonRuimEdit10 = v.findViewById(R.id.radioButtonRuimEdit10);

        editTextAvaliacaoEdit = v.findViewById(R.id.editTextAvaliacaoEdit);

        buttonEditarAvaliacao = v.findViewById(R.id.buttonEditarAvaliacao);


        textViewNomeCidadeE.setText(cidadeNome);

        /***********************RADIOS*********************************/

        radioGroupEdit1 = v.findViewById(R.id.radioGroupEdit1);
        radioGroupEdit2 = v.findViewById(R.id.radioGroupEdit2);
        radioGroupEdit3 = v.findViewById(R.id.radioGroupEdit3);
        radioGroupEdit4 = v.findViewById(R.id.radioGroupEdit4);
        radioGroupEdit5 = v.findViewById(R.id.radioGroupEdit5);
        radioGroupEdit6 = v.findViewById(R.id.radioGroupEdit6);
        radioGroupEdit7 = v.findViewById(R.id.radioGroupEdit7);
        radioGroupEdit8 = v.findViewById(R.id.radioGroupEdit8);
        radioGroupEdit9 = v.findViewById(R.id.radioGroupEdit9);
        radioGroupEdit10 = v.findViewById(R.id.radioGroupEdit10);


        /***********************RADIOS BUTTONS*********************************/

        radioButtonEditSim1 = v.findViewById(R.id.radioButtonSimEdit1);
        radioButtonNaoEdit1 = v.findViewById(R.id.radioButtonNaoEdit1);

        radioButtonOtimoEdit2 = v.findViewById(R.id.radioButtonOtimoEdit2);
        radioButtonBomEdit2 = v.findViewById(R.id.radioButtonBomEdit2);
        radioButtonRegularEdit2= v.findViewById(R.id.radioButtonRegularEdit2);
        radioButtonRuimEdit2 = v.findViewById(R.id.radioButtonRuimEdit2);

        radioButtonSeguroEdit3 = v.findViewById(R.id.radioButtonSeguroEdit3);
        radioButtonPoucoSeguroEdit3 = v.findViewById(R.id.radioButtonPoucoseguroEdit3);
        radioButtonInseguroEdit3 = v.findViewById(R.id.radioButtonInseguroEdit3);

        radioButtonExcessivaEdit4 = v.findViewById(R.id.radioButtonExcessivaEdit4);
        radioButtonRazoavelEdit4= v.findViewById(R.id.radioButtonRazoavelEdit4);
        radioButtonInsuficienteEdit4= v.findViewById(R.id.radioButtonInsuficienteEdit4);

        radioButtonOtimoEdit5 = v.findViewById(R.id.radioButtonOtimoEdit5);
        radioButtonBomEdit5 = v.findViewById(R.id.radioButtonBomEdit5);
        radioButtonRegularEdit5 = v.findViewById(R.id.radioButtonRegularEdit5);
        radioButtonRuimEdit5 = v.findViewById(R.id.radioButtonRuimEdit5);

        radioButtonOtimoEdit6 = v.findViewById(R.id.radioButtonOtimoEdit6);
        radioButtonBomEdit6 = v.findViewById(R.id.radioButtonBomEdit6);
        radioButtonRegularEdit6 = v.findViewById(R.id.radioButtonRegularEdit6);
        radioButtonRuimEdit6 = v.findViewById(R.id.radioButtonRuimEdit6);

        radioButtonOtimoEdit7 = v.findViewById(R.id.radioButtonOtimoEdit7);
        radioButtonBomEdit7 = v.findViewById(R.id.radioButtonBomEdit7);
        radioButtonRegularEdit7 = v.findViewById(R.id.radioButtonRegularEdit7);
        radioButtonRuimEdit7 = v.findViewById(R.id.radioButtonRuimEdit7);

        radioButtonOtimoEdit8 = v.findViewById(R.id.radioButtonOtimoEdit8);
        radioButtonBomEdit8 = v.findViewById(R.id.radioButtonBomEdit8);
        radioButtonRegularEdit8 = v.findViewById(R.id.radioButtonRegularEdit8);
        radioButtonRuimEdit8 = v.findViewById(R.id.radioButtonRuimEdit8);

        radioButtonOtimoEdit9 = v.findViewById(R.id.radioButtonOtimoEdit9);
        radioButtonBomEdit9 = v.findViewById(R.id.radioButtonBomEdit9);
        radioButtonRegularEdit9 = v.findViewById(R.id.radioButtonRegularEdit9);
        radioButtonRuimEdit9 = v.findViewById(R.id.radioButtonRuimEdit9);

        radioButtonOtimoEdit10 = v.findViewById(R.id.radioButtonOtimoEdit10);
        radioButtonBomEdit10 = v.findViewById(R.id.radioButtonBomEdit10);
        radioButtonRegularEdit10 = v.findViewById(R.id.radioButtonRegularEdit10);
        radioButtonRuimEdit10 = v.findViewById(R.id.radioButtonRuimEdit10);

        editTextAvaliacaoEdit = v.findViewById(R.id.editTextAvaliacaoEdit);

        buttonEditarAvaliacao = v.findViewById(R.id.buttonEditarAvaliacao);

        textViewNomeCidadeE.setText(cidadeNome);

        /***********Setar Valores nos Radios Buttons****************/

        /****************1********************/

        if(a.getRadioSim_1() > 0){

            radioButtonEditSim1.setChecked(true);
        }else{
            radioButtonNaoEdit1.setChecked(true);
        }

        /****************2********************/

        if(a.getRadioMuito_2() > 0){
            radioButtonOtimoEdit2.setChecked(true);
        }else if(a.getRadiobom_2() > 0){
            radioButtonBomEdit2.setChecked(true);
        }else if(a.getRadioRegular_2() > 0){
            radioButtonRegularEdit2.setChecked(true);
        }else if(a.getRadioRuim_2() > 0){
            radioButtonRuimEdit2.setChecked(true);
        }

        /****************3********************/

        if(a.getRadioSeguro_3() > 0){
            radioButtonSeguroEdit3.setChecked(true);
        }else if(a.getRadioPoucoSeguro_3() > 0){
            radioButtonPoucoSeguroEdit3.setChecked(true);
        }else if(a.getRadioInseguro_3() > 0){
            radioButtonInseguroEdit3.setChecked(true);
        }

        /****************4********************/

        if(a.getRadioExcessiva_4() > 0){
            radioButtonExcessivaEdit4.setChecked(true);
        }else if(a.getRadioRazoavel_4() > 0){
            radioButtonRazoavelEdit4.setChecked(true);
        }else if(a.getRadioInsuficiente_4() > 0) {
            radioButtonInsuficienteEdit4.setChecked(true);
        }

        /****************5********************/

        if(a.getRadioMuito_5() > 0){
            radioButtonOtimoEdit5.setChecked(true);
        }else if(a.getRadiobom_5() > 0){
            radioButtonBomEdit5.setChecked(true);
        }else if(a.getRadioRegular_5() > 0){
            radioButtonRegularEdit5.setChecked(true);
        }else if(a.getRadioRuim_5() > 0){
            radioButtonRuimEdit5.setChecked(true);
        }

        /****************6********************/

        if(a.getRadioMuito_6() > 0){
            radioButtonOtimoEdit6.setChecked(true);
        }else if(a.getRadiobom_6() > 0){
            radioButtonBomEdit6.setChecked(true);
        }else if(a.getRadioRegular_6() > 0){
            radioButtonRegularEdit6.setChecked(true);
        }else if(a.getRadioRuim_6() > 0){
            radioButtonRuimEdit6.setChecked(true);
        }

        /****************7********************/

        if(a.getRadioMuito_7() > 0){
            radioButtonOtimoEdit7.setChecked(true);
        }else if(a.getRadiobom_7() > 0){
            radioButtonBomEdit7.setChecked(true);
        }else if(a.getRadioRegular_7() > 0){
            radioButtonRegularEdit7.setChecked(true);
        }else if(a.getRadioRuim_7() > 0){
            radioButtonRuimEdit7.setChecked(true);
        }

        /****************8********************/

        if(a.getRadioMuito_8() > 0){
            radioButtonOtimoEdit8.setChecked(true);
        }else if(a.getRadiobom_8() > 0){
            radioButtonBomEdit8.setChecked(true);
        }else if(a.getRadioRegular_8() > 0){
            radioButtonRegularEdit8.setChecked(true);
        }else if(a.getRadioRuim_8() > 0){
            radioButtonRuimEdit8.setChecked(true);
        }

        /****************9********************/

        if(a.getRadioMuito_9() > 0){
            radioButtonOtimoEdit9.setChecked(true);
        }else if(a.getRadiobom_9() > 0){
            radioButtonBomEdit9.setChecked(true);
        }else if(a.getRadioRegular_9() > 0){
            radioButtonRegularEdit9.setChecked(true);
        }else if(a.getRadioRuim_9() > 0){
            radioButtonRuimEdit9.setChecked(true);
        }

        /****************10********************/

        if(a.getRadioMuito_10() > 0){
            radioButtonOtimoEdit10.setChecked(true);
        }else if(a.getRadiobom_10() > 0){
            radioButtonBomEdit10.setChecked(true);
        }else if(a.getRadioRegular_10() > 0){
            radioButtonRegularEdit10.setChecked(true);
        }else if(a.getRadioRuim_10() > 0){
            radioButtonRuimEdit10.setChecked(true);
        }
        /****************11********************/

        if(a.getSugestoes() != null){
            editTextAvaliacaoEdit.setText(a.getSugestoes());
        }

        /***************************BUTTON EDIT********************************/

        buttonEditarAvaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Avaliacao editAvaliacao = new Avaliacao();

                /***********************************RADIOGROUP 1*****************************************/

                radioChecado = radioGroupEdit1.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonSimEdit1:
                            editAvaliacao.setRadioSim_1(1);
                            break;

                        case R.id.radioButtonNaoEdit1:
                            editAvaliacao.setRadioNao_1(1);
                            break;
                    }
                }

                /***********************************RADIOGROUP 2*****************************************/

                radioChecado = radioGroupEdit2.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonOtimoEdit2:
                            editAvaliacao.setRadioMuito_2(1);
                            break;

                        case R.id.radioButtonBomEdit2:
                            editAvaliacao.setRadiobom_2(1);
                            break;

                        case R.id.radioButtonRegularEdit2:
                            editAvaliacao.setRadioRegular_2(1);
                            break;

                        case R.id.radioButtonRuimEdit2:
                            editAvaliacao.setRadioRuim_2(1);
                            break;
                    }}

                /***********************************RADIOGROUP 3*****************************************/

                radioChecado = radioGroupEdit3.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonSeguroEdit3:
                            editAvaliacao.setRadioSeguro_3(1);
                            break;

                        case R.id.radioButtonPoucoseguroEdit3:
                            editAvaliacao.setRadioPoucoSeguro_3(1);
                            break;

                        case R.id.radioButtonInseguroEdit3:
                            editAvaliacao.setRadioInseguro_3(1);
                            break;

                    }}

                /***********************************RADIOGROUP 4*****************************************/

                radioChecado = radioGroupEdit4.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonExcessivaEdit4:
                            editAvaliacao.setRadioInsuficiente_4(1);
                            break;

                        case R.id.radioButtonRazoavelEdit4:
                            editAvaliacao.setRadioRazoavel_4(1);
                            break;

                        case R.id.radioButtonInsuficienteEdit4:
                            editAvaliacao.setRadioInsuficiente_4(1);
                            break;

                    }}

                /***********************************RADIOGROUP 5*****************************************/

                radioChecado = radioGroupEdit5.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonOtimoEdit5:
                            editAvaliacao.setRadioMuito_5(1);
                            break;

                        case R.id.radioButtonBomEdit5:
                            editAvaliacao.setRadiobom_5(1);
                            break;

                        case R.id.radioButtonRegularEdit5:
                            editAvaliacao.setRadioRegular_5(1);
                            break;

                        case R.id.radioButtonRuimEdit5:
                            editAvaliacao.setRadioRuim_5(1);
                            break;
                    }}

                /***********************************RADIOGROUP 6*****************************************/

                radioChecado = radioGroupEdit6.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonOtimoEdit6:
                            editAvaliacao.setRadioMuito_6(1);
                            break;

                        case R.id.radioButtonBomEdit6:
                            editAvaliacao.setRadiobom_6(1);
                            break;

                        case R.id.radioButtonRegularEdit6:
                            editAvaliacao.setRadioRegular_6(1);
                            break;

                        case R.id.radioButtonRuimEdit6:
                            editAvaliacao.setRadioRuim_6(1);
                            break;
                    }}

                /***********************************RADIOGROUP 7*****************************************/

                radioChecado = radioGroupEdit7.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonOtimoEdit7:
                            editAvaliacao.setRadioMuito_7(1);
                            break;

                        case R.id.radioButtonBomEdit7:
                            editAvaliacao.setRadiobom_7(1);
                            break;

                        case R.id.radioButtonRegularEdit7:
                            editAvaliacao.setRadioRegular_7(1);
                            break;

                        case R.id.radioButtonRuimEdit7:
                            editAvaliacao.setRadioRuim_7(1);
                            break;
                    }}

                /***********************************RADIOGROUP 8*****************************************/

                radioChecado = radioGroupEdit8.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonOtimoEdit8:
                            editAvaliacao.setRadioMuito_8(1);
                            break;

                        case R.id.radioButtonBomEdit8:
                            editAvaliacao.setRadiobom_8(1);
                            break;

                        case R.id.radioButtonRegularEdit8:
                            editAvaliacao.setRadioRegular_8(1);
                            break;

                        case R.id.radioButtonRuimEdit8:
                            editAvaliacao.setRadioRuim_8(1);
                            break;
                    }}

                /***********************************RADIOGROUP 9*****************************************/

                radioChecado = radioGroupEdit9.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonOtimoEdit9:
                            editAvaliacao.setRadioMuito_9(1);
                            break;

                        case R.id.radioButtonBomEdit9:
                            editAvaliacao.setRadiobom_9(1);
                            break;

                        case R.id.radioButtonRegularEdit9:
                            editAvaliacao.setRadioRegular_9(1);
                            break;

                        case R.id.radioButtonRuimEdit9:
                            editAvaliacao.setRadioRuim_9(1);
                            break;
                    }}

                /***********************************RADIOGROUP 10*****************************************/

                radioChecado = radioGroupEdit10.getCheckedRadioButtonId();

                if (radioChecado > 0) {

                    switch (radioChecado) {

                        case R.id.radioButtonOtimoEdit10:
                            editAvaliacao.setRadioMuito_10(1);
                            break;

                        case R.id.radioButtonBomEdit10:
                            editAvaliacao.setRadiobom_10(1);
                            break;

                        case R.id.radioButtonRegularEdit10:
                            editAvaliacao.setRadioRegular_10(1);
                            break;

                        case R.id.radioButtonRuimEdit10:
                            editAvaliacao.setRadioRuim_10(1);
                            break;
                    }}

                /**************************SUGESTÔES*************************/

                editAvaliacao.setSugestoes(editTextAvaliacaoEdit.getText().toString());

                editAvaliacao.setIdAv(a.getIdAv());

                /*******************UPDATE********************/

                db_avaliacao.updateAvaliacao(editAvaliacao);
                Toast.makeText(getContext(), "Editado com Sucesso!!!", Toast.LENGTH_SHORT).show();
               // Toast.makeText(getContext(), String.valueOf(a.getIdCidade()), Toast.LENGTH_SHORT).show();
                Fragment_Listar_Avaliacoes fragmentListarAvaliacoes= new Fragment_Listar_Avaliacoes();
                Bundle bundle = new Bundle();
                bundle.putString("cidadeNome", cidadeNome);
                bundle.putSerializable("cidadeId", a.getIdCidade());
                fragmentListarAvaliacoes.setArguments(bundle);
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, fragmentListarAvaliacoes); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();


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

    private void carregarAvaliacoes(int cod, int type_agente) {

        arrayListAvaliacoes = db_avaliacao.getAvaliacoesCidade(cod, type_agente);

        db_avaliacao.close();

        if (arrayListAvaliacoes !=  null) {

            for (Avaliacao a: arrayListAvaliacoes) {

                Log.i("AVALIACAO ********** ","***");
                Log.i("AVALIACAO - CITY", String.valueOf(a.getIdCidade()));
                Log.i("AVALIACAO - ID ", String.valueOf(a.getIdAv()));

                Log.i("AVALIACAO - RADIO SIM ", String.valueOf(a.getRadioSim_1()));
                Log.i("AVALIACAO - RADIO NAO ", String.valueOf(a.getRadioNao_1()));

                Log.i("AVALIACAO - OTIMO 2 ", String.valueOf(a.getRadioMuito_2()));
                Log.i("AVALIACAO - BOM 2 ", String.valueOf(a.getRadiobom_2()));
                Log.i("AVALIACAO - REGULAR 2 ", String.valueOf(a.getRadioRegular_2()));
                Log.i("AVALIACAO - RUIM 2 ", String.valueOf(a.getRadioRuim_2()));

                Log.i("AVALIACAO - SEGURO 3 ", String.valueOf(a.getRadioSeguro_3()));
                Log.i("AVALIACAO - P SEGURO 3 ", String.valueOf(a.getRadioPoucoSeguro_3()));
                Log.i("AVALIACAO - INSEGURO 3 ", String.valueOf(a.getRadioInseguro_3()));

                Log.i("AVALIACAO - EXCESSIVA 4", String.valueOf(a.getRadioExcessiva_4()));
                Log.i("AVALIACAO - RAZOAVEL 4 ", String.valueOf(a.getRadioRazoavel_4()));
                Log.i("AVALIACAO - INSUFICI 4", String.valueOf(a.getRadioInsuficiente_4()));

                Log.i("AVALIACAO - OTIMO 5 ", String.valueOf(a.getRadioMuito_5()));
                Log.i("AVALIACAO - BOM 5 ", String.valueOf(a.getRadiobom_5()));
                Log.i("AVALIACAO - REGULAR 5 ", String.valueOf(a.getRadioRegular_5()));
                Log.i("AVALIACAO - RUIM 5 ", String.valueOf(a.getRadioRuim_5()));

                Log.i("AVALIACAO - OTIMO 6 ", String.valueOf(a.getRadioMuito_6()));
                Log.i("AVALIACAO - BOM 6 ", String.valueOf(a.getRadiobom_6()));
                Log.i("AVALIACAO - REGULAR 6 ", String.valueOf(a.getRadioRegular_6()));
                Log.i("AVALIACAO - RUIM 6 ", String.valueOf(a.getRadioRuim_6()));

                Log.i("AVALIACAO - OTIMO 7 ", String.valueOf(a.getRadioMuito_7()));
                Log.i("AVALIACAO - BOM 7 ", String.valueOf(a.getRadiobom_7()));
                Log.i("AVALIACAO - REGULAR 7 ", String.valueOf(a.getRadioRegular_7()));
                Log.i("AVALIACAO - RUIM 7 ", String.valueOf(a.getRadioRuim_7()));

                Log.i("AVALIACAO - OTIMO 8 ", String.valueOf(a.getRadioMuito_8()));
                Log.i("AVALIACAO - BOM 8 ", String.valueOf(a.getRadiobom_8()));
                Log.i("AVALIACAO - REGULAR 8 ", String.valueOf(a.getRadioRegular_8()));
                Log.i("AVALIACAO - RUIM 8 ", String.valueOf(a.getRadioRuim_8()));

                Log.i("AVALIACAO - OTIMO 9 ", String.valueOf(a.getRadioMuito_9()));
                Log.i("AVALIACAO - BOM 9 ", String.valueOf(a.getRadiobom_9()));
                Log.i("AVALIACAO - REGULAR 9 ", String.valueOf(a.getRadioRegular_9()));
                Log.i("AVALIACAO - RUIM 9 ", String.valueOf(a.getRadioRuim_9()));

                Log.i("AVALIACAO - OTIMO 10 ", String.valueOf(a.getRadioMuito_10()));
                Log.i("AVALIACAO - BOM 10 ", String.valueOf(a.getRadiobom_10()));
                Log.i("AVALIACAO - REGULAR 10 ", String.valueOf(a.getRadioRegular_10()));
                Log.i("AVALIACAO - RUIM 10 ", String.valueOf(a.getRadioRuim_10()));

                Log.i("AVALIACAO - SUGESTÃO ", String.valueOf(a.getSugestoes()));
                Log.i("AVALIACAO - DATA ", a.getData());
                Log.i("AVALIACAO ********** ","***");
            }
        }
    }

}
