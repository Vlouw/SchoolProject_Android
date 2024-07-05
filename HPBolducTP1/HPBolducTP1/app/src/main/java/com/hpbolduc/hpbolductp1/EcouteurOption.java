package com.hpbolduc.hpbolductp1;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

//Étape 3 - Ecouteur Option
public class EcouteurOption implements View.OnClickListener {

    // Variables
    private MainActivity mainActivity;
    private LinearLayout optionLayout;
    private String option, optionStockage;

    // Constructeur
    public EcouteurOption(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.optionLayout = mainActivity.findViewById(R.id.OptionLayout);
        this.option = "ButtonCrayon";
        this.optionStockage = "ButtonCrayon";
    }

    // Getter/Setter
    public LinearLayout getOptionLayout() {
        return optionLayout;
    }
    public String getOption() { return option; }
    public void setOption(String option) {
        this.option = option;
        this.optionStockage = option;

        // Mettre tous les images background en blanc et celui choisi en vert
        for (int i = 0; i < optionLayout.getChildCount(); i++) {
            if (optionLayout.getChildAt(i) instanceof ImageView) {
                if ( option.equals(optionLayout.getChildAt(i).getResources().getResourceEntryName(optionLayout.getChildAt(i).getId())) )
                    optionLayout.getChildAt(i).getBackground().setTint(Color.GREEN);
                else
                    optionLayout.getChildAt(i).getBackground().setTint(Color.WHITE);
            }
        }
    }

    // Méthode de View.OnClickListener
    @Override
    public void onClick(View source) {
        // Retourne le ID en format String
        option = source.getResources().getResourceEntryName(source.getId());

        // Afficher la seekBarTrait
        if (option.equals("ButtonTrait")) {
            mainActivity.seekBarFrag.show(mainActivity.getSupportFragmentManager(), "Fragment");
            option = optionStockage;
        }
        // Si bouton remplir, changer la couleur de background, passer à travers tous les objets et changer la couleur si efface
        else if (option.equals("ButtonRemplir")) {
            mainActivity.drawingLayout.setBackgroundColor(mainActivity.eCouleur.getColor());

            for ( ObjetSuper objet:mainActivity.eSurface.getDrawVector()) {
                if (objet.isEfface())
                    objet.setColor(mainActivity.eCouleur.getColor());
            }

            // Mettre à jour le canvas
            mainActivity.surfaceD.invalidate();

            option = optionStockage;
        }

        setOption(option);
    }
}
