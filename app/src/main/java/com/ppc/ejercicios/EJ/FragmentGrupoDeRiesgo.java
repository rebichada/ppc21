package com.ppc.ejercicios.EJ;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.jakewharton.rxbinding4.view.RxView;
import com.ppc.ejercicios.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentGrupoDeRiesgo extends Fragment {

    @BindView(R.id.textView)
    TextView grupoRiesgoText;
    @BindView(R.id.button_calcular)
    Button calcular;

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grupo_de_riesgo, container, false);
        ButterKnife.bind(this, view);

        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
        navController = navHostFragment.getNavController();

        grupoRiesgoText.setMovementMethod(new ScrollingMovementMethod());

        RxView.clicks(calcular)
                .subscribe(aVoid -> {
                    navController.navigate(R.id.fragment_calculo_grupo_riesgo);
                });

        return view;
    }



}