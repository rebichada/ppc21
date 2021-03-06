package com.ppc.ejercicios.EJ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.jakewharton.rxbinding4.view.RxView;
import com.ppc.ejercicios.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentInformacionParaPacientes extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacion_pacientes, container, false);
        ButterKnife.bind(this, view);

        return view;
}



}
