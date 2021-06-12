package com.ppc.ejercicios.EJ;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.jakewharton.rxbinding4.view.RxView;
import com.ppc.ejercicios.BuildConfig;
import com.ppc.ejercicios.R;

import java.io.File;
import java.io.FileOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentCargaDatos extends Fragment {

    @BindView(R.id.imagenPaisaje)
    ImageView imgPaisaje;
    @BindView(R.id.button_compartir)
    Button compartir;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carga_datos, container, false);
        ButterKnife.bind(this, view);

        Drawable drawable=imgPaisaje.getDrawable();
        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();
        RxView.clicks(compartir)
                .subscribe(aVoid -> {
                    try {
                        File file = new File(getActivity().getBaseContext().getExternalCacheDir(), File.separator +"Imagen para el paciente");
                        FileOutputStream fOut = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                        fOut.flush();
                        fOut.close();
                        file.setReadable(true, false);
                        final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        Uri photoURI = FileProvider.getUriForFile(getActivity().getBaseContext(), BuildConfig.APPLICATION_ID +".provider", file);

                        intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        intent.setType("image/jepg");

                        startActivity(Intent.createChooser(intent, "Compartir imagen via"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });


        return view;

    }





}