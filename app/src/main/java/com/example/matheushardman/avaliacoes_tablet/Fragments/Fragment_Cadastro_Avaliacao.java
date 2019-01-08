package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.content.Context;
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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;
import com.example.matheushardman.avaliacoes_tablet.classes.Avaliacao;
import com.example.matheushardman.avaliacoes_tablet.classes.Cidade;
import com.example.matheushardman.avaliacoes_tablet.classes.Uf;
import com.example.matheushardman.avaliacoes_tablet.db.Db_Avaliacao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Cadastro_Avaliacao extends Fragment {


    private Context context;
    Db_Avaliacao db_avaliacao;
    private ArrayList<String> arrayListCidades;

    private RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6, radioGroup7, radioGroup8, radioGroup9, radioGroup10;
    private int radioChecado = 0;
    private EditText editTextAvaliacao;
    private Button buttonCadastrar;
    private ArrayList<Avaliacao> arrayListAvaliacoes;
    private Spinner spinnerCidadesFragment;
    private int id_cidade = 0;

    String [] arrayCidades = new String [] {"escolha uma opção","AGUA PRETA-PE", "ALHANDRA-PB", "ARAPONGA-MG","ARES-RN",
            "BERNARDINO BATISTA-PB", "BRUMADO-BA", "CAJURI-MG", "CANAÃ-MG", "CONDADO-PE", "ESPERA FELIZ-MG", "EUNAPOLIS-BA", "FREI MARTINHO-PB",
            "GOIANINHA-RN", "GUAMARÉ-RN", "GUARACIABA-MG", "GURINHÉM-PB", "ITAPOROROCA-PB", "ITATUBA-PB", "JABOATÃO DOS GUARARAPES-PE",
            "JOCA CLAUDINO-PB(SANTAREM)", "MOSSORÓ-RN", "PAULA CANDIDO-MG", "PAULISTA-PE", "PEDRA LAVRADA-PB", "PIRAÍ - RJ","PORTO DO MANGUE-RN",
            "REMIGIO-PB", "SANTA LUZIA-PB", "SÃO JOSÉ DE UBA-RJ", "SÃO JOSÉ DO MIPIBU-RN", "SERRA DO MEL-RN", "SERTANEA-PE", "TAIPU-RN",
            "TAPEROÁ-PB", "TIBAU-RN", "TIBAU DO SUL-RN", "TIBAU DO SUL-RN (EDEIMAS)"};



    private int posicao = 0;

    public Fragment_Cadastro_Avaliacao() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment__cadastro__avaliacao, container, false);

        radioGroup1 = v.findViewById(R.id.radioGroup1);
        radioGroup2 = v.findViewById(R.id.radioGroup2);
        radioGroup3 = v.findViewById(R.id.radioGroup3);
        radioGroup4 = v.findViewById(R.id.radioGroup4);
        radioGroup5 = v.findViewById(R.id.radioGroup5);
        radioGroup6 = v.findViewById(R.id.radioGroup6);
        radioGroup7 = v.findViewById(R.id.radioGroup7);
        radioGroup8 = v.findViewById(R.id.radioGroup8);
        radioGroup9 = v.findViewById(R.id.radioGroup9);
        radioGroup10 = v.findViewById(R.id.radioGroup10);

        editTextAvaliacao = v.findViewById(R.id.editTextAvaliacao);


        spinnerCidadesFragment = v.findViewById(R.id.spinnerCidadesFragment);
       /* ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this.getActivity(),
                android.R.layout.simple_spinner_item,
                //arrayCidades);
                db_avaliacao.getCidades());*/

         ArrayAdapter adapter = new ArrayAdapter(
                this.getActivity(),
                android.R.layout.simple_spinner_item,
                getCidadesUfs());
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerCidadesFragment.setAdapter(adapter);
        spinnerCidadesFragment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {

                Uf uf = (Uf) adapter.getItemAtPosition(position);
                //descricaoUf = adapter.getItemAtPosition(position).toString();
                posicao = position + 1;
                id_cidade = uf.getCidade().getId_cidade();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        buttonCadastrar = v.findViewById(R.id.buttonCadastrar);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Avaliacao a = new Avaliacao();

                int r1 = radioGroup1.getCheckedRadioButtonId();
                int r2 = radioGroup2.getCheckedRadioButtonId();
                int r3 = radioGroup3.getCheckedRadioButtonId();
                int r4 = radioGroup4.getCheckedRadioButtonId();
                int r5 = radioGroup5.getCheckedRadioButtonId();
                int r6 = radioGroup6.getCheckedRadioButtonId();
                int r7 = radioGroup7.getCheckedRadioButtonId();
                int r8 = radioGroup8.getCheckedRadioButtonId();
                int r9 = radioGroup9.getCheckedRadioButtonId();
                int r10 = radioGroup10.getCheckedRadioButtonId();

                //Verifica a posição do Spinner(Tem que ser maior que 0):
                if(posicao > 0) {

                    //Verifica se existe algum radio Group sem ter sido clicado:
                    if (r1 > 0 && r2 > 0 && r3 > 0 && r4 > 0 && r5 > 0 && r6 > 0 && r7 > 0 && r8 > 0 && r9 > 0 && r10 > 0) {

                        //***********************************RADIOGROUP 1*****************************************

                        radioChecado = radioGroup1.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonSim1:
                                    a.setRadioSim_1(1);
                                    break;

                                case R.id.radioButtonNao1:
                                    a.setRadioNao_1(1);
                                    break;

                            }
                        }

                        //***********************************RADIOGROUP 2*****************************************

                        radioChecado = radioGroup2.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonOtimo2:
                                    a.setRadioMuito_2(1);
                                    break;

                                case R.id.radioButtonBom2:
                                    a.setRadiobom_2(1);
                                    break;

                                case R.id.radioButtonRegular2:
                                    a.setRadioRegular_2(1);
                                    break;

                                case R.id.radioButtonRuim2:
                                    a.setRadioRuim_2(1);
                                    break;
                            }}

                        //***********************************RADIOGROUP 3*****************************************

                        radioChecado = radioGroup3.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonseguro3:
                                    a.setRadioSeguro_3(1);
                                    break;

                                case R.id.radioButtonpoucoseguro3:
                                    a.setRadioPoucoSeguro_3(1);
                                    break;

                                case R.id.radioButtonInseguro3:
                                    a.setRadioInseguro_3(1);
                                    break;

                            }}

                        //***********************************RADIOGROUP 4*****************************************

                        radioChecado = radioGroup4.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonExcessiva4:
                                    a.setRadioExcessiva_4(1);
                                    break;

                                case R.id.radioButtonRazoavel4:
                                    a.setRadioRazoavel_4(1);
                                    break;

                                case R.id.radioButtonInsuficiente4:
                                    a.setRadioInsuficiente_4(1);
                                    break;

                            }}

                        //***********************************RADIOGROUP 5*****************************************

                        radioChecado = radioGroup5.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonOtimo5:
                                    a.setRadioMuito_5(1);
                                    break;

                                case R.id.radioButtonBom5:
                                    a.setRadiobom_5(1);
                                    break;

                                case R.id.radioButtonRegular5:
                                    a.setRadioRegular_5(1);
                                    break;

                                case R.id.radioButtonRuim5:
                                    a.setRadioRuim_5(1);
                                    break;
                            }}

                        //***********************************RADIOGROUP 6*****************************************

                        radioChecado = radioGroup6.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonOtimo6:
                                    a.setRadioMuito_6(1);
                                    break;

                                case R.id.radioButtonBom6:
                                    a.setRadiobom_6(1);
                                    break;

                                case R.id.radioButtonRegular6:
                                    a.setRadioRegular_6(1);
                                    break;

                                case R.id.radioButtonRuim6:
                                    a.setRadioRuim_6(1);
                                    break;
                            }}
                        //***********************************RADIOGROUP 7*****************************************

                        radioChecado = radioGroup7.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonOtimo7:
                                    a.setRadioMuito_7(1);
                                    break;

                                case R.id.radioButtonBom7:
                                    a.setRadiobom_7(1);
                                    break;

                                case R.id.radioButtonRegular7:
                                    a.setRadioRegular_7(1);
                                    break;

                                case R.id.radioButtonRuim7:
                                    a.setRadioRuim_7(1);
                                    break;
                            }}

                        //***********************************RADIOGROUP 8*****************************************

                        radioChecado = radioGroup8.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonOtimo8:
                                    a.setRadioMuito_8(1);
                                    break;

                                case R.id.radioButtonBom8:
                                    a.setRadiobom_8(1);
                                    break;

                                case R.id.radioButtonRegular8:
                                    a.setRadioRegular_8(1);
                                    break;

                                case R.id.radioButtonRuim8:
                                    a.setRadioRuim_8(1);
                                    break;
                            }}

                        //***********************************RADIOGROUP 6*****************************************

                        radioChecado = radioGroup9.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonOtimo9:
                                    a.setRadioMuito_9(1);
                                    break;

                                case R.id.radioButtonBom9:
                                    a.setRadiobom_9(1);
                                    break;

                                case R.id.radioButtonRegular9:
                                    a.setRadioRegular_9(1);
                                    break;

                                case R.id.radioButtonRuim9:
                                    a.setRadioRuim_9(1);
                                    break;
                            }}

                        //***********************************RADIOGROUP 10*****************************************

                        radioChecado = radioGroup10.getCheckedRadioButtonId();

                        if (radioChecado > 0) {

                            switch (radioChecado) {

                                case R.id.radioButtonOtimo10:

                                    a.setRadioMuito_10(1);
                                    break;

                                case R.id.radioButtonBom10:

                                    a.setRadiobom_10(1);
                                    break;

                                case R.id.radioButtonRegular10:

                                    a.setRadioRegular_10(1);
                                    break;

                                case R.id.radioButtonRuim10:

                                    a.setRadioRuim_10(1);
                                    break;
                            }}

                        /**********************************SUGESTÃO*******************************************/

                        a.setSugestoes(editTextAvaliacao.getText().toString());

                        /**********************************ID CIDADE*******************************************/

                       // a.setIdCidade(posicao);
                        a.setIdCidade(id_cidade);

                        /**********************************ID CIDADE*******************************************/

                        a.setData(pegarData());

                        /**********************************DATABASE*******************************************/

                        db_avaliacao.inserirAvaliacao(a);

                        //carregarAvaliacao(posicao);
                        //carregarAvaliacoes(posicao);
                        //carregarCidades();



                        //Caso de tudo certo, cadastra e volta para o Fragment Avaliações:

                        Toast.makeText(getContext(), "Cadastro realizado com sucesso!!!", Toast.LENGTH_SHORT).show();
                        Fragment_Avaliacoes someFragment = new Fragment_Avaliacoes();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment, someFragment); // give your fragment container id in first parameter
                        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                        transaction.commit();

                    }else{

                        Toast.makeText(getContext(), "Opções obrigatórias não preenchidas!!!", Toast.LENGTH_SHORT).show();

                    }//Fim if-else RadioGroup

                }else{

                    Toast.makeText(getContext(), "Escolha uma Cidade!!!", Toast.LENGTH_SHORT).show();

                }//Fim if-else - Escolha Cidade (Spinner)
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

    private void carregarAvaliacoes(int cod) {

        arrayListAvaliacoes = db_avaliacao.getAvaliacoesCidade(cod);

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


    private void carregarAvaliacao(int cod) {

        Avaliacao  a = db_avaliacao.getSomaAvaliacoesCidade(cod);
        db_avaliacao.close();


        if (a != null) {

            Log.i("AVALIACAO ******SOMA","***");

            Log.i("AVALIACAO - CITY", String.valueOf(a.getIdCidade()));

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

        }
    }

    private String pegarData(){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String data = sdf.format(tm);
        return data;

    }

    private void carregarCidades() {

        arrayListCidades = db_avaliacao.getCidades();
        db_avaliacao.close();


        if (arrayListCidades !=  null) {

            for (String c: arrayListCidades) {

                Log.i("AVALIACAO ******SOMA","***");

                Log.i("CIDADE- DESCRICAO", String.valueOf(c));


            }
        }
    }

    private ArrayList<Uf> getCidadesUfs() {

        ArrayList<Uf> arrayListCidadesUfs = new ArrayList<>();

        arrayListCidadesUfs = db_avaliacao.getCidadesUf();
        db_avaliacao.close();

        return arrayListCidadesUfs;

    }
}



