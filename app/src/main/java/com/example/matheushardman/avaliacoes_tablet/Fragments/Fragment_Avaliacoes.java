package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Avaliacoes extends Fragment {

    FragmentTransaction transaction;
    FloatingActionButton floatingActionButtonCadastroAvaliacao;

    public Fragment_Avaliacoes() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment__avaliacoes, container, false);

        floatingActionButtonCadastroAvaliacao = v.findViewById(R.id.floatingActionButtonCadastroAvaliacao);
        floatingActionButtonCadastroAvaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Acessando Cadsatro Avaliação...", Toast.LENGTH_SHORT).show();
                Fragment_Cadastro_Avaliacao someFragment = new Fragment_Cadastro_Avaliacao();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, someFragment); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();

            }
        });

        setHasOptionsMenu(true);
        return v;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_avaliacao, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.menu_item_cadastro_avaliacao:

                Toast.makeText(getContext(), "ACESSANDO CADASTRO AVALIACAO", Toast.LENGTH_SHORT).show();
                Fragment_Cadastro_Avaliacao fragmentCadastroAvaliacao = new Fragment_Cadastro_Avaliacao();
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, fragmentCadastroAvaliacao ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
                break;

            case R.id.menu_item_listar_avaliacoes:

                Toast.makeText(getContext(), "LISTAR AVALIAÇÕES", Toast.LENGTH_SHORT).show();
                Fragment_Resultado fragmentResultado= new Fragment_Resultado();
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, fragmentResultado); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
                break;

            case R.id.menu_item_sair:
                Toast.makeText(getContext(), "SAINDO...", Toast.LENGTH_SHORT).show();
                getActivity().finish();
                break;
        }

        return false;
    }

}

