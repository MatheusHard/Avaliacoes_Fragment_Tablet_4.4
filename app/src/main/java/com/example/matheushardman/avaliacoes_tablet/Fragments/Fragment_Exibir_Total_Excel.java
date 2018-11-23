package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;
import com.example.matheushardman.avaliacoes_tablet.classes.Avaliacao;
import com.example.matheushardman.avaliacoes_tablet.db.Db_Avaliacao;

import java.io.File;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

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

        buttonGerarExcel = v.findViewById(R.id.buttonGerarExcel);
        buttonGerarExcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cidadeId > 0) {

                    gerarExcel(cidadeId, cidadeNome);
                    Toast.makeText(getContext(), "Arquivo Excel Gerado!!!", Toast.LENGTH_LONG).show();
                    Fragment_Resultado someFragment = new Fragment_Resultado();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, someFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                    //carregarAvaliacao(posicao);

                }else {

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

    private void gerarExcel(int cod, String cidade){

        try {

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


                }}




            File file = new File(getActivity().getExternalFilesDir(null), cidade+".xls");
            // File file = new File(getFilesDir(),"Teste.xls");

            WritableWorkbook wb = null;

            wb = Workbook.createWorkbook(file);
            wb.createSheet("Planilha", 0);

            WritableSheet plan = wb.getSheet(0);
            plan.setColumnView(0, 20);
            plan.setColumnView(1, 20);
            plan.setColumnView(2, 20);
            plan.setColumnView(3, 20);

            //Titulo Principal
            Label titulo = new Label(0, 0, "AVALIAÇÕES", celulaTitulo());
            //Mesclagem das celulas do Titulo Principal
            plan.mergeCells(0,0,3,0);

            Label subTituloConteudoTeorico = new Label(0, 2, "Conteudo Teórico", celulaSubTitulo());
            plan.mergeCells(0,2,2,2);

            Label conhecimento1 = new Label(0, 4, "Proporcionou Algum Conhecimento", celulaAzul());
            plan.mergeCells(0,4,1,4);

            Label labe3 = new Label(0, 6, "SIM", celulaVerde());
            Label labe4 = new Label(1, 6, "NÃO", celulaVerde());
            Number _sim1 = new Number(0, 7, sim1 , celulaValores());
            Number _nao1 = new Number(1, 7, nao1, celulaValores());

            plan.addCell(titulo);
            plan.addCell(subTituloConteudoTeorico);
            plan.addCell(conhecimento1);
            plan.addCell(labe3);
            plan.addCell(_sim1);
            plan.addCell(labe4);
            plan.addCell(_nao1);

            Label subTituloConteudoPratico = new Label(0, 9, "Conteudo Prático", celulaSubTitulo());
            plan.mergeCells(0,9,2,9);

            Label pratico2 = new Label(0, 11, "Clareza/Facilidades de Trabalho", celulaAzul());
            plan.mergeCells(0,11,1,11);
            Label pratico2_1 = new Label(0, 13, "MUITO BOM", celulaVerde());
            Label pratico2_2 = new Label(1, 13, "BOM", celulaVerde());
            Label pratico2_3 = new Label(2, 13, "REGULAR", celulaVerde());
            Label pratico2_4 = new Label(3, 13, "RUIM", celulaVerde());

            Number muitoBom2 = new Number(0, 14, muito2, celulaValores());
            Number _bom2 = new Number(1, 14, bom2, celulaValores());
            Number _regular2 = new Number(2, 14, regular2, celulaValores());
            Number _ruim2 = new Number(3, 14, ruim2, celulaValores());

            plan.addCell(subTituloConteudoPratico);
            plan.addCell(pratico2);
            plan.addCell(pratico2_1);
            plan.addCell(pratico2_2);
            plan.addCell(pratico2_3);
            plan.addCell(pratico2_4);
            plan.addCell(muitoBom2);
            plan.addCell(_bom2);
            plan.addCell(_regular2);
            plan.addCell(_ruim2);

            Label aplicacao3 = new Label(0, 16, "Aplicação no Processo de Trabalho", celulaAzul());
            plan.mergeCells(0,16,1,16);
            Label aplicacao3_1 = new Label(0, 18, "SEGURO", celulaVerde());
            Label aplicacao3_2 = new Label(1, 18, "POUCO SEGURO", celulaVerde());
            Label aplicacao3_3 = new Label(2, 18, "INSEGURO", celulaVerde());
            Number _seguro3 = new Number(0, 19, seguro3, celulaValores());
            Number _poucoSeguro3 = new Number(1, 19, poucoSeguro3, celulaValores());
            Number _inseguro3 = new Number(2, 19, inseguro3, celulaValores());

            plan.addCell(aplicacao3);
            plan.addCell(aplicacao3_1);
            plan.addCell(aplicacao3_2);
            plan.addCell(aplicacao3_3);
            plan.addCell(_seguro3);
            plan.addCell(_poucoSeguro3);
            plan.addCell(_inseguro3);

            Label cargaHoraria4 = new Label(0, 21, "Carga Horária", celulaAzul());
            plan.mergeCells(0,21,1,21);
            Label cargaHoraria4_1 = new Label(0, 23, "EXCESSIVA", celulaVerde());
            Label cargaHoraria4_2 = new Label(1, 23, "RAZOAVEL", celulaVerde());
            Label cargaHoraria4_3 = new Label(2, 23, "INSUFICIENTE", celulaVerde());
            Number _excessiva4 = new Number(0, 24, excessiva4, celulaValores());
            Number _razoavel4 = new Number(1, 24, razoavel4, celulaValores());
            Number _insuficiente4 = new Number(2, 24, insuficiente4, celulaValores());

            plan.addCell(cargaHoraria4);
            plan.addCell(cargaHoraria4_1);
            plan.addCell(cargaHoraria4_2);
            plan.addCell(cargaHoraria4_3);
            plan.addCell(_excessiva4);
            plan.addCell(_razoavel4);
            plan.addCell(_insuficiente4);

            Label subTituloInstrutor = new Label(0, 26, "Instrutor", celulaSubTitulo());
            plan.mergeCells(0,26,2,26);
            Label conhecimentoConteudo5 = new Label(0, 28, "Conhecimento do Conteúdo", celulaAzul());
            plan.mergeCells(0,28,1,28);
            Label intrutor_5_1 = new Label(0, 30, "MUITO BOM", celulaVerde());
            Label intrutor_5_2 = new Label(1, 30, "BOM", celulaVerde());
            Label intrutor_5_3 = new Label(2, 30, "REGULAR", celulaVerde());
            Label intrutor_5_4 = new Label(3, 30, "RUIM", celulaVerde());
            Number muitoBom5 = new Number(0, 31, muito5, celulaValores());
            Number _bom5 = new Number(1, 31, bom5, celulaValores());
            Number _regular5 = new Number(2, 31, regular5, celulaValores());
            Number _ruim5 = new Number(3, 31, ruim5, celulaValores());

            plan.addCell(subTituloInstrutor);
            plan.addCell(conhecimentoConteudo5);
            plan.addCell(intrutor_5_1);
            plan.addCell(intrutor_5_2);
            plan.addCell(intrutor_5_3);
            plan.addCell(intrutor_5_4);
            plan.addCell(muitoBom5);
            plan.addCell(_bom5);
            plan.addCell(_regular5);
            plan.addCell(_ruim5);

            Label clareza6 = new Label(0, 33, "Clareza na Exposição", celulaAzul());
            plan.mergeCells(0,33,1,33);
            Label clareza_6_1 = new Label(0, 35, getResources().getString(R.string.muito_bom3), celulaVerde());
            Label clareza_6_2 = new Label(1, 35, getResources().getString(R.string.bom3), celulaVerde());
            Label clareza_6_3 = new Label(2, 35, getResources().getString(R.string.regular3), celulaVerde());
            Label clareza_6_4 = new Label(3, 35, getResources().getString(R.string.ruim3), celulaVerde());
            Number muitoBom6 = new Number(0, 36, muito6, celulaValores());
            Number _bom6 = new Number(1, 36, bom6 , celulaValores());
            Number _regular6 = new Number(2, 36, regular6);
            Number _ruim6 = new Number(3, 36, ruim6, celulaValores());

            plan.addCell(clareza6);
            plan.addCell(clareza_6_1);
            plan.addCell(clareza_6_2);
            plan.addCell(clareza_6_3);
            plan.addCell(clareza_6_4);
            plan.addCell(muitoBom6);
            plan.addCell(_bom6);
            plan.addCell(_regular6);
            plan.addCell(_ruim6);

            Label disponibilidade7 = new Label(0, 38, "Esclarecimento de Dúvidas", celulaAzul());
            plan.mergeCells(0,38,1,38);
            Label disponibilidade7_1 = new Label(0, 40, getResources().getString(R.string.muito_bom3), celulaVerde());
            Label disponibilidade7_2 = new Label(1, 40, getResources().getString(R.string.bom3), celulaVerde());
            Label disponibilidade7_3 = new Label(2, 40, getResources().getString(R.string.regular3), celulaVerde());
            Label disponibilidade7_4 = new Label(3, 40, getResources().getString(R.string.ruim3), celulaVerde());
            Number muitoBom7 = new Number(0, 41, muito7, celulaValores());
            Number _bom7 = new Number(1, 41, bom7, celulaValores());
            Number _regular7 = new Number(2, 41, regular7, celulaValores());
            Number _ruim7 = new Number(3, 41, ruim7, celulaValores());

            plan.addCell(disponibilidade7);
            plan.addCell(disponibilidade7_1);
            plan.addCell(disponibilidade7_2);
            plan.addCell(disponibilidade7_3);
            plan.addCell(disponibilidade7_4);
            plan.addCell(muitoBom7);
            plan.addCell(_bom7);
            plan.addCell(_regular7);
            plan.addCell(_ruim7);

            Label subTituloEquipeApoio = new Label(0, 43, "Equipe de Apoio", celulaSubTitulo());
            plan.mergeCells(0,43,2,43);
            Label equipe8 = new Label(0, 45, "Conhecimento do Conteúdo", celulaAzul());
            plan.mergeCells(0,45,1,45);
            Label equipe8_1 = new Label(0, 47, getResources().getString(R.string.muito_bom3), celulaVerde());
            Label equipe8_2 = new Label(1, 47, getResources().getString(R.string.bom3), celulaVerde());
            Label equipe8_3 = new Label(2, 47, getResources().getString(R.string.regular3), celulaVerde());
            Label equipe8_4 = new Label(3, 47, getResources().getString(R.string.ruim3), celulaVerde());
            Number muitoBom8 = new Number(0, 48, muito8, celulaValores());
            Number _bom8 = new Number(1, 48, bom8, celulaValores());
            Number _regular8 = new Number(2, 48, regular8, celulaValores());
            Number _ruim8 = new Number(3, 48, ruim8, celulaValores());

            plan.addCell(subTituloEquipeApoio);
            plan.addCell(equipe8);
            plan.addCell(equipe8_1);
            plan.addCell(equipe8_2);
            plan.addCell(equipe8_3);
            plan.addCell(equipe8_4);
            plan.addCell(muitoBom8);
            plan.addCell(_bom8);
            plan.addCell(_regular8);
            plan.addCell(_ruim8);

            Label clareza9 = new Label(0, 50, "Clareza na Exposição", celulaAzul());
            plan.mergeCells(0,50,1,50);
            Label clareza_9_1 = new Label(0, 52, getResources().getString(R.string.muito_bom3), celulaVerde());
            Label clareza_9_2 = new Label(1, 52, getResources().getString(R.string.bom3), celulaVerde());
            Label clareza_9_3 = new Label(2, 52, getResources().getString(R.string.regular3), celulaVerde());
            Label clareza_9_4 = new Label(3, 52, getResources().getString(R.string.ruim3), celulaVerde());
            Number muitoBom9 = new Number(0, 53, muito9, celulaValores());
            Number _bom9 = new Number(1, 53, bom9, celulaValores());
            Number _regular9 = new Number(2, 53, regular9,  celulaValores());
            Number _ruim9 = new Number(3, 53, ruim9, celulaValores());

            plan.addCell(clareza9);
            plan.addCell(clareza_9_1);
            plan.addCell(clareza_9_2);
            plan.addCell(clareza_9_3);
            plan.addCell(clareza_9_4);
            plan.addCell(muitoBom9);
            plan.addCell(_bom9);
            plan.addCell(_regular9);
            plan.addCell(_ruim9);

            Label disponibilidade10 = new Label(0, 55, "Esclarecimento de Dúvidas", celulaAzul());
            plan.mergeCells(0,55,1,55);
            Label disponibilidade10_1 = new Label(0, 57, getResources().getString(R.string.muito_bom3), celulaVerde());
            Label disponibilidade10_2 = new Label(1, 57, getResources().getString(R.string.bom3), celulaVerde());
            Label disponibilidade10_3 = new Label(2, 57, getResources().getString(R.string.regular3), celulaVerde());
            Label disponibilidade10_4 = new Label(3, 57, getResources().getString(R.string.ruim3), celulaVerde());
            Number muitoBom10 = new Number(0, 58, muito10, celulaValores());
            Number _bom10 = new Number(1, 58, bom10, celulaValores());
            Number _regular10 = new Number(2, 58, regular10, celulaValores());
            Number _ruim10 = new Number(3, 58, ruim10, celulaValores());

            plan.addCell(disponibilidade10);
            plan.addCell(disponibilidade10_1);
            plan.addCell(disponibilidade10_2);
            plan.addCell(disponibilidade10_3);
            plan.addCell(disponibilidade10_4);
            plan.addCell(muitoBom10);
            plan.addCell(_bom10);
            plan.addCell(_regular10);
            plan.addCell(_ruim10);

            Label cidadeLabel = new Label(0, 60, "Cidade", celulaSubTitulo());
            Label cidadeValue= new Label(0, 61, cidade, celulaValores());

            plan.addCell(cidadeLabel);
            plan.addCell(cidadeValue);

            wb.write();
            wb.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private WritableCellFormat celulaAzul(){

        WritableCellFormat cellFormatAzul = null;

        try {
            Colour bckcolor = Colour.DARK_BLUE; // Cor do fundo do cabeçalho
            cellFormatAzul = new WritableCellFormat();
            cellFormatAzul.setBackground(bckcolor);
            /*****Fonte****/
            WritableFont fonte = new WritableFont(WritableFont.ARIAL); // Formato da fonte do cabeçalho
            fonte.setColour(Colour.WHITE); // Cor da fonte do cabeçalho
            fonte.setPointSize(12);
            fonte.setBoldStyle(WritableFont.BOLD);
            cellFormatAzul.setFont(fonte);
            /****Centralizar****/
            cellFormatAzul.setAlignment(Alignment.CENTRE);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cellFormatAzul;
    }
    private WritableCellFormat celulaVerde(){

        WritableCellFormat cellFormatVerde = null;

        try {

            Colour bckcolorV = Colour.DARK_GREEN; // Cor do fundo do cabeçalho
            cellFormatVerde = new WritableCellFormat();
            cellFormatVerde.setBackground(bckcolorV);
            /*****Fonte****/
            WritableFont fonteV = new WritableFont(WritableFont.ARIAL); // Formato da fonte do cabeçalho
            fonteV.setColour(Colour.WHITE); // Cor da fonte do cabeçalho
            fonteV.setPointSize(10);
            cellFormatVerde.setFont(fonteV);
            /****Centralizar****/
            cellFormatVerde.setAlignment(Alignment.CENTRE);

        }catch (Exception e){
            e.printStackTrace();
        }
        return cellFormatVerde;
    }

    private WritableCellFormat celulaValores(){

        WritableCellFormat cellFormatValores = null;

        try {

            cellFormatValores = new WritableCellFormat();
            cellFormatValores.setAlignment(Alignment.CENTRE);

        }catch (Exception e){
            e.printStackTrace();
        }
        return cellFormatValores;
    }

    private WritableCellFormat celulaSubTitulo(){

        WritableCellFormat cellFormatSubTitulo = null;

        try {

            Colour bckcolorSubTitulo = Colour.DARK_RED; // Cor do fundo do cabeçalho
            cellFormatSubTitulo = new WritableCellFormat();
            cellFormatSubTitulo.setBackground(bckcolorSubTitulo);
            /*****Fonte****/
            WritableFont fonteSubTitulo = new WritableFont(WritableFont.ARIAL); // Formato da fonte do cabeçalho
            fonteSubTitulo.setColour(Colour.WHITE); // Cor da fonte do cabeçalho
            fonteSubTitulo.setPointSize(14);
            fonteSubTitulo.setBoldStyle(WritableFont.BOLD);
            cellFormatSubTitulo.setFont(fonteSubTitulo);

            /****Centralizar****/
            cellFormatSubTitulo.setAlignment(Alignment.CENTRE);

        }catch (Exception e){
            e.printStackTrace();
        }
        return cellFormatSubTitulo;
    }

    private WritableCellFormat celulaTitulo() {

        WritableCellFormat cellFormatTitulo  = null;

        try {

            Colour bckcolorTitulo = Colour.BLUE_GREY; // Cor do fundo do cabeçalho
            cellFormatTitulo = new WritableCellFormat();
            cellFormatTitulo.setBackground(bckcolorTitulo);
            /*****Fonte****/
            WritableFont fonteTitulo = new WritableFont(WritableFont.ARIAL); // Formato da fonte do cabeçalho
            fonteTitulo.setColour(Colour.WHITE); // Cor da fonte do cabeçalho
            fonteTitulo.setPointSize(17);
            fonteTitulo.setBoldStyle(WritableFont.BOLD);
            cellFormatTitulo.setFont(fonteTitulo);
            /****Centralizar****/
            cellFormatTitulo.setAlignment(Alignment.CENTRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellFormatTitulo;
    }

}
