package com.hpbolduc.hpbolductp1;

import android.graphics.Canvas;

public class Cercle extends ObjetSuper {

    // Constructeur
    public Cercle() {
        super();
    }

    // Methode de la classe
    public void dessiner (Canvas canvas) { canvas.drawCircle(depart.x, depart.y, rayon, paint); }
}