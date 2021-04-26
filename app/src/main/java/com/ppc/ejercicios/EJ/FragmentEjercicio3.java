package com.ppc.ejercicios.EJ;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.ppc.ejercicios.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentEjercicio3 extends Fragment {

    @BindView(R.id.info_resolucion)
    TextView infoResolucion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejercicio_3, container, false);
        ButterKnife.bind(this, view);

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels; // ancho absoluto en pixels
        int height = metrics.heightPixels; // alto absoluto en pixels

        infoResolucion.setText("Resolución : "+String.valueOf(width)+"X"+String.valueOf(height));


        return view;

    }





}