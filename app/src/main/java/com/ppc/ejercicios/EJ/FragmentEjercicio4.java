package com.ppc.ejercicios.EJ;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

import com.jakewharton.rxbinding4.view.RxView;
import com.ppc.ejercicios.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import android.widget.ImageView;

public class FragmentEjercicio4 extends Fragment {
    @BindView(R.id.btnCamara)
    Button btnCamara;
    @BindView(R.id.imageView)
    ImageView imgView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejercicio_4, container, false);
        ButterKnife.bind(this, view);

        RxView.clicks(btnCamara).subscribe(aVoid -> {
            //Perform some work here//
            openCamera();
        });

        return view;
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,
                    1);
        //}
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == getActivity().RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgView.setImageBitmap(imageBitmap);
        }
    }

}

