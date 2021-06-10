package com.ppc.ejercicios.EJ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.jakewharton.rxbinding4.view.RxView;
import com.ppc.ejercicios.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentPrincipal extends Fragment {

    @BindView(R.id.button_grupo_riesgo)
    Button grupoRiesgo;
    @BindView(R.id.button_informacion_pacientes)
    Button infoPacientes;
    @BindView(R.id.button_carga_datos)
    Button cargaDatos;


    NavController navController;

    //Necesario para push



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejercicios, container, false);
        ButterKnife.bind(this, view);

        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
        navController = navHostFragment.getNavController();

        RxView.clicks(grupoRiesgo)
                .subscribe(aVoid -> {
                    navController.navigate(R.id.action_fragment);
                });

        RxView.clicks(infoPacientes)
                .subscribe(aVoid -> {
                    navController.navigate(R.id.fragment_informacion_pacientes);
                });

        RxView.clicks(cargaDatos)
                .subscribe(aVoid -> {
                    navController.navigate(R.id.fragment_carga_datos);
                });

        return view;
}

}