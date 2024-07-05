package com.hpbolduc.hpbolductp1;

import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

// Étape 3 - Ecouteur SeekBar
public class EcouteurSeekBar implements SeekBar.OnSeekBarChangeListener {

    // Variables
    private SeekBar seekBarTrait;
    private TextView seekBarValue;
    private int epaisseurTrait;

    // Constructeur
    public EcouteurSeekBar(ViewGroup rootView, int epaisseurTrait) {
        this.seekBarTrait = rootView.findViewById(R.id.SeekBarTrait);
        this.seekBarValue = rootView.findViewById(R.id.SeekBarValue);

        this.seekBarTrait.setMax(50);

        this.epaisseurTrait = epaisseurTrait;

        this.seekBarTrait.setProgress(epaisseurTrait);
        this.seekBarValue.setText(String.valueOf(seekBarTrait.getProgress()));
    }

    // Getter/Setter
    public int getEpaisseurTrait() { return epaisseurTrait; }
    public void setEpaisseurTrait(int epaisseurTrait) { this.epaisseurTrait = epaisseurTrait; }
    public SeekBar getSeekBarTrait() { return seekBarTrait; }

    // Méthodes de SeekBar.OnSeekBarChangeListener
    @Override
    public void onProgressChanged(SeekBar seekBar, int value, boolean bool) {
        seekBarValue.setText(String.valueOf(value));
        epaisseurTrait = value;
    }

    // Méthodes bidons pour compléter la classe
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
