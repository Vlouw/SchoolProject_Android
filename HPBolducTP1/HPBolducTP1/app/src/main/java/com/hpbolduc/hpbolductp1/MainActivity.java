package com.hpbolduc.hpbolductp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Variables
    EcouteurCouleur eCouleur;
    EcouteurOption eOption;
    EcouteurSurface eSurface;
    SurfaceDessin surfaceD;
    SeekBarFragment seekBarFrag;

    ConstraintLayout drawingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Étape 1 - Surface de dessin
        drawingLayout = findViewById(R.id.DrawingLayout);

        surfaceD = new SurfaceDessin(this, this);
        eSurface = new EcouteurSurface(this);

        // Étape 2
        surfaceD.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        surfaceD.setOnTouchListener(eSurface);
        drawingLayout.addView(surfaceD);

        // Étape 1 - Écouteur couleur
        eCouleur = new EcouteurCouleur(this);
        // Étape 2 - Trouver seulement le bouton choisi
        for (int i = 0; i < eCouleur.getColorLayout().getChildCount(); i++)
        {
            if (eCouleur.getColorLayout().getChildAt(i) instanceof Button)
                eCouleur.getColorLayout().getChildAt(i).setOnClickListener(eCouleur);
        }

        // Étape 1 - Écouteur option
        eOption = new EcouteurOption(this);
        // Étape 2 - Trouver seulement l'image choisi
        for (int i = 0; i < eOption.getOptionLayout().getChildCount(); i++)
        {
            if (eOption.getOptionLayout().getChildAt(i) instanceof ImageView)
                eOption.getOptionLayout().getChildAt(i).setOnClickListener(eOption);
        }

        // Étape 1 - Creation du SeekBarFragment
        seekBarFrag = new SeekBarFragment();
    }
}