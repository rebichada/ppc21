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

public class FragmentEjercicio2 extends Fragment {

    @BindView(R.id.buttonSuma)
    Button suma;
    @BindView(R.id.buttonResta)
    Button resta;
    @BindView(R.id.buttonDivision)
    Button division;
    @BindView(R.id.buttonMultiplicar)
    Button multiplicar;
    @BindView(R.id.editTextOperacion1)
    EditText editTextOperacion1;
    @BindView(R.id.editTextOperacion2)
    EditText editTextOperacion2;
    @BindView(R.id.resultado)
    TextView resultado;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejercicio_2, container, false);
        ButterKnife.bind(this, view);


        RxView.clicks(suma)
                .subscribe(aVoid -> {
                    resultado.setText("Resultado : "+
                            String.valueOf(Integer.parseInt(editTextOperacion1.getText().toString())
                                    +Integer.parseInt(editTextOperacion2.getText().toString())));
                    InputMethodManager imm = (InputMethodManager)getActivity()
                            .getSystemService(getActivity().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                });

        RxView.clicks(resta)
                .subscribe(aVoid -> {
                    resultado.setText("Resultado : "+
                            String.valueOf(Integer.parseInt(editTextOperacion1.getText().toString())
                                    -Integer.parseInt(editTextOperacion2.getText().toString())));
                    InputMethodManager imm = (InputMethodManager)getActivity()
                            .getSystemService(getActivity().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                });

        RxView.clicks(division)
                .subscribe(aVoid -> {
                    resultado.setText("Resultado : "+
                            String.valueOf(Double.parseDouble(editTextOperacion1.getText().toString())
                                    /Double.parseDouble(editTextOperacion2.getText().toString())));
                    InputMethodManager imm = (InputMethodManager)getActivity()
                            .getSystemService(getActivity().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                });

        RxView.clicks(multiplicar)
                .subscribe(aVoid -> {
                    resultado.setText("Resultado : "+
                            String.valueOf(Integer.parseInt(editTextOperacion1.getText().toString())
                                    *Integer.parseInt(editTextOperacion2.getText().toString())));
                    InputMethodManager imm = (InputMethodManager)getActivity()
                            .getSystemService(getActivity().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                });






        return view;
}



}
