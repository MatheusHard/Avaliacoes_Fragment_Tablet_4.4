package com.example.matheushardman.avaliacoes_tablet.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.matheushardman.avaliacoes_tablet.R;


public class Fragment_Cidades extends Fragment {

    FloatingActionButton floatingActionButtonCadastroCidade;


    public Fragment_Cidades() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment__cidades, container, false);

        floatingActionButtonCadastroCidade= v.findViewById(R.id.floatingActionButtonCadastroCidade);
        floatingActionButtonCadastroCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Acessando Cadastro Cidade", Toast.LENGTH_SHORT).show();
                Fragment_Cadastro_Cidade someFragment = new Fragment_Cadastro_Cidade();
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
        inflater.inflate(R.menu.menu_cidade, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.menu_item_cadastro_cidade:
                Toast.makeText(getContext(), "ACESSANDO CADASTRO CIDADE...", Toast.LENGTH_SHORT).show();
                Fragment_Cadastro_Cidade someFragment = new Fragment_Cadastro_Cidade();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, someFragment); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
                break;

            case R.id.menu_item_listar_cidades:
                Toast.makeText(getContext(), "LISTAR CIDADES", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_item_sair:
                Toast.makeText(getContext(), "SAINDO...", Toast.LENGTH_SHORT).show();
                getActivity().finish();
                break;
        }

        return false;
    }

}

