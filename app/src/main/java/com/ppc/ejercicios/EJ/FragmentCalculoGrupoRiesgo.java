package com.ppc.ejercicios.EJ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.ppc.ejercicios.R;

import butterknife.ButterKnife;

public class FragmentCalculoGrupoRiesgo extends Fragment {

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calcular_grupo_riesgo, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
