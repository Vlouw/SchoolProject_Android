package com.hpbolduc.hpbolductp1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

public class SeekBarFragment extends DialogFragment {

    // Variables
    private EcouteurSeekBar eSeekBar;
    private int epaisseurTrait;

    public SeekBarFragment() {
        // Required empty public constructor
    }

    // Getter/Setter
    public int getEpaisseurTrait() { return epaisseurTrait; }

    // Methode de la classe SeekbarFragment
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_seekbartrait , null);

        // Étape 1 - Creation SeekBar
        eSeekBar = new EcouteurSeekBar(rootView, epaisseurTrait);
        // Étape 2
        eSeekBar.getSeekBarTrait().setOnSeekBarChangeListener(eSeekBar);

        builder.setView(rootView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        epaisseurTrait = eSeekBar.getEpaisseurTrait();
                        dismiss(); // fermer la boîte de dialogue
                    }
                })
                .setNegativeButton(R.string.annuler, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        eSeekBar.setEpaisseurTrait(epaisseurTrait);
                        dismiss(); // fermer la boîte de dialogue
                    }
                });

        return builder.create();
    }
}