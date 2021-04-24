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

public class FragmentPrincipalEjercicios extends Fragment {

    @BindView(R.id.button_ejercicio_1)
    Button ejercicio1;
    @BindView(R.id.button_ejercicio_2)
    Button ejercicio2;
    @BindView(R.id.button_ejercicio_3)
    Button ejercicio3;


    NavController navController;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejercicios, container, false);
        ButterKnife.bind(this, view);

        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
        navController = navHostFragment.getNavController();

        RxView.clicks(ejercicio1)
                .subscribe(aVoid -> {
                    navController.navigate(R.id.fragment_ejercicio_1);
                });

        RxView.clicks(ejercicio2)
                .subscribe(aVoid -> {
                    navController.navigate(R.id.fragment_ejercicio_2);
                });

        return view;
}

}