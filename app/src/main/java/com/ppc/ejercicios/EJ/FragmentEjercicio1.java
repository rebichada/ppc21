package com.ppc.ejercicios.EJ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.jakewharton.rxbinding4.view.RxView;
import com.ppc.ejercicios.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentEjercicio1 extends Fragment {

    @BindView(R.id.button_cambiar_texto)
    Button cambiarTexto;
    @BindView(R.id.button_aceptar)
    Button aceptar;
    @BindView(R.id.button_cancelar)
    Button cancelar;

    @BindView(R.id.vistaTexto)
    TextView texto;
    @BindView(R.id.editarTexto)
    EditText editarTexto;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejercicio_1, container, false);
        ButterKnife.bind(this, view);

        aceptar.setVisibility(View.INVISIBLE);
        cancelar.setVisibility(View.INVISIBLE);
        editarTexto.setVisibility(View.INVISIBLE);

        RxView.clicks(cambiarTexto)
                .subscribe(aVoid -> {
                    aceptar.setVisibility(View.VISIBLE);
                    cancelar.setVisibility(View.VISIBLE);
                    editarTexto.setVisibility(View.VISIBLE);

                    cambiarTexto.setVisibility(View.INVISIBLE);
                    texto.setVisibility(View.INVISIBLE);
                });

        RxView.clicks(aceptar)
                .subscribe(aVoid -> {
                    aceptar.setVisibility(View.INVISIBLE);
                    cancelar.setVisibility(View.INVISIBLE);
                    editarTexto.setVisibility(View.INVISIBLE);
                    texto.setText(editarTexto.getText());

                    cambiarTexto.setVisibility(View.VISIBLE);
                    texto.setVisibility(View.VISIBLE);
                });

        RxView.clicks(cancelar)
                .subscribe(aVoid -> {
                    aceptar.setVisibility(View.INVISIBLE);
                    cancelar.setVisibility(View.INVISIBLE);
                    editarTexto.setVisibility(View.INVISIBLE);

                    cambiarTexto.setVisibility(View.VISIBLE);
                    texto.setVisibility(View.VISIBLE);
                });

        return view;
    }



}