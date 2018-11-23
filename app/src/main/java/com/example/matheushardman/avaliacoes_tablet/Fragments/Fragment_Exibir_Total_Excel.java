package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;
import com.example.matheushardman.avaliacoes_tablet.classes.Avaliacao;
import com.example.matheushardman.avaliacoes_tablet.db.Db_Avaliacao;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Exibir_Total_Excel extends Fragment {

    private String cidadeNome;
    private int cidadeId;
    private ArrayList<Avaliacao> arrayListAvaliacoes;
    Db_Avaliacao db_avaliacao;
    private Context context;

    private Button buttonGerarExcel;
    private TextView textViewSim1, textViewNao1, textViewClareza2, textViewAplicacao3, textViewCargaHoraria4,
            textViewConhecimentoInstrutor5, textViewClareza6, textViewDisponibilidade7, textViewConhecimento8,
            textViewClareza9, textViewDisponibilidade10, textViewNomeCidade;

    public Fragment_Exibir_Total_Excel() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment__exibir__total__excel, container, false);
        Bundle bundle = getArguments();

        cidadeNome = bundle.getString("cidadeNome");
        cidadeId = bundle.getInt("cidadeId");

        /*******************IDS*****************************/
        textViewSim1 = v.findViewById(R.id.textViewSim1);
        textViewNao1 = v.findViewById(R.id.textViewNao1);
        textViewClareza2 = v.findViewById(R.id.textViewClareza2);
        textViewAplicacao3 = v.findViewById(R.id.textViewAplicacao3);
        textViewCargaHoraria4 = v.findViewById(R.id.textViewCargaHoraria4);
        textViewConhecimentoInstrutor5 = v.findViewById(R.id.textViewConhecimentoInstrutor5);
        textViewClareza6 = v.findViewById(R.id.textViewClareza6);
        textViewDisponibilidade7 = v.findViewById(R.id.textViewDisponibilidade7);
        textViewConhecimento8 = v.findViewById(R.id.textViewConhecimento8);
        textViewClareza9 = v.findViewById(R.id.textViewClareza9);
        textViewDisponibilidade10 = v.findViewById(R.id.textViewDisponibilidade10);
        textViewNomeCidade = v.findViewById(R.id.textViewNomeCidade);

        textViewNomeCidade.setText(cidadeNome);

        carregarSomaAvaliacoesTextViews(cidadeId);

        return v;

    }


    @Override
    public void onAttach(Context context) {
        this.context = context;
        db_avaliacao = new Db_Avaliacao(context);
        super.onAttach(context);
    }

    private void carregarSomaAvaliacoesTextViews(int cod) {

        int sim1 = 0, nao1 = 0, muito2 = 0, bom2 = 0, regular2 = 0, ruim2 = 0, seguro3 = 0, poucoSeguro3 = 0, inseguro3 = 0,
                excessiva4 = 0, razoavel4 = 0, insuficiente4 = 0, muito5 = 0, bom5 = 0, regular5 = 0, ruim5 = 0,
                muito6 = 0, bom6 = 0, regular6 = 0, ruim6 = 0, muito7 = 0, bom7 = 0, regular7 = 0, ruim7 = 0,
                muito8 = 0, bom8 = 0, regular8 = 0, ruim8 = 0, muito9 = 0, bom9 = 0, regular9 = 0, ruim9 = 0,
                muito10 = 0, bom10 = 0, regular10 = 0, ruim10 = 0;

        arrayListAvaliacoes = db_avaliacao.getAvaliacoesCidade(cod);

        db_avaliacao.close();

        if (arrayListAvaliacoes !=  null) {

            for (Avaliacao a: arrayListAvaliacoes) {

                sim1 += a.getRadioSim_1();
                nao1 += a.getRadioNao_1();

                muito2 += a.getRadioMuito_2();
                bom2 += a.getRadiobom_2();
                regular2 += a.getRadioRegular_2();
                ruim2 += a.getRadioRuim_2();

                seguro3 += a.getRadioSeguro_3();
                poucoSeguro3 += a.getRadioPoucoSeguro_3();
                inseguro3 += a.getRadioInseguro_3();

                excessiva4 += a.getRadioExcessiva_4();
                razoavel4 += a.getRadioRazoavel_4();
                insuficiente4 += a.getRadioInsuficiente_4();


                muito5 += a.getRadioMuito_5();
                bom5 += a.getRadiobom_5();
                regular5 += a.getRadioRegular_5();
                ruim5 += a.getRadioRuim_5();

                muito6 += a.getRadioMuito_6();
                bom6 += a.getRadiobom_6();
                regular6 += a.getRadioRegular_6();
                ruim6 += a.getRadioRuim_6();

                muito7 += a.getRadioMuito_7();
                bom7 += a.getRadiobom_7();
                regular7 += a.getRadioRegular_7();
                ruim7 += a.getRadioRuim_7();

                muito8 += a.getRadioMuito_8();
                bom8 += a.getRadiobom_8();
                regular8 += a.getRadioRegular_8();
                ruim8 += a.getRadioRuim_8();

                muito9 += a.getRadioMuito_9();
                bom9 += a.getRadiobom_9();
                regular9 += a.getRadioRegular_9();
                ruim9 += a.getRadioRuim_9();

                muito10 += a.getRadioMuito_10();
                bom10 += a.getRadiobom_10();
                regular10 += a.getRadioRegular_10();
                ruim10 += a.getRadioRuim_10();


            }
            textViewSim1.setText(String.format(getResources().getString(R.string.sim) +" "+ sim1));
            textViewNao1.setText(String.format(getResources().getString(R.string.nao)+" "+ nao1));

            textViewClareza2.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+muito2+"\n"+
                    getResources().getString(R.string.bom2)+" "+bom2+"\n"+getResources().getString(R.string.regular2)+" "+regular2+"\n"+
                    getResources().getString(R.string.ruim2)+" "+ruim2 ));


            textViewAplicacao3.setText(String.format(getResources().getString(R.string.seguro)+" "+seguro3
                    +"\n"+getResources().getString(R.string.pouco_seguro) +" "+ poucoSeguro3+"\n"+getResources().getString(R.string.inseguro)+" "+inseguro3));

            textViewCargaHoraria4.setText(String.format(getResources().getString(R.string.excessiva)+" "+excessiva4+"\n"+
                    getResources().getString(R.string.razoavel)+" "+razoavel4+"\n"+getResources().getString(R.string.insuficiente)+" "+insuficiente4));

            textViewConhecimentoInstrutor5.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+muito5+"\n"+
                    getResources().getString(R.string.bom2)+" "+bom5+"\n"+getResources().getString(R.string.regular2)+" "+regular5+"\n"+
                    getResources().getString(R.string.ruim2)+" "+ruim5));

            textViewClareza6.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+muito6+"\n"+
                    getResources().getString(R.string.bom2)+" "+bom6+"\n"+getResources().getString(R.string.regular2)+" "+regular6+"\n"+
                    getResources().getString(R.string.ruim2)+" "+ruim6));

            textViewDisponibilidade7.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+muito7+"\n"+
                    getResources().getString(R.string.bom2)+" "+bom7+"\n"+getResources().getString(R.string.regular2)+" "+regular7+"\n"+
                    getResources().getString(R.string.ruim2)+" "+ruim7));

            textViewConhecimento8.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+muito8+"\n"+
                    getResources().getString(R.string.bom2)+" "+bom8+"\n"+getResources().getString(R.string.regular2)+" "+regular8+"\n"+
                    getResources().getString(R.string.ruim2)+" "+ruim8));

            textViewClareza9.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+muito9+"\n"+
                    getResources().getString(R.string.bom2)+" "+bom9+"\n"+getResources().getString(R.string.regular2)+" "+regular9+"\n"+
                    getResources().getString(R.string.ruim2)+" "+ruim9));

            textViewDisponibilidade10.setText(String.format(getResources().getString(R.string.muito_bom2)+" "+muito10+"\n"+
                    getResources().getString(R.string.bom2)+" "+bom10+"\n"+getResources().getString(R.string.regular2)+" "+regular10+"\n"+
                    getResources().getString(R.string.ruim2)+" "+ruim10));

        }
    }

}
