package com.hpbolduc.hpbolductp1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

//Étape 3 - Ecouteur Couleur
public class EcouteurCouleur implements View.OnClickListener{

    // Variables
    private int color;
    private LinearLayout colorLayout;

    // Constructeur
    public EcouteurCouleur(MainActivity mainActivity) {
        this.colorLayout = mainActivity.findViewById(R.id.ColorLayout);
        this.color = Color.BLACK;
    }

    // Getter/Setter
    public int getColor() { return color; }
    public void setColor(int color) {
        this.color = color;

        // Mettre le X sur la bonne couleur
        for (int i = 0; i < colorLayout.getChildCount(); i++)
        {
            if (colorLayout.getChildAt(i) instanceof Button)
                if (color == ((ColorDrawable) colorLayout.getChildAt(i).getBackground()).getColor())
                    ((Button) colorLayout.getChildAt(i)).setText("X");
                else
                    ((Button) colorLayout.getChildAt(i)).setText("");
        }
    }

    public LinearLayout getColorLayout() { return colorLayout; }

    // Méthode de View.OnClickListener
    @Override
    public void onClick(View source) {
        // Enregistrer la couleur choisi
        setColor( ((ColorDrawable) source.getBackground()).getColor() );
    }
}
