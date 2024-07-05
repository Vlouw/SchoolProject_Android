package com.hpbolduc.hpbolductp1;

import android.graphics.Canvas;

public class Rectangle extends ObjetSuper {

    // Constructeur
    public Rectangle() {
        super();
    }

    // Methode de la classe
    public void dessiner (Canvas canvas) {
        canvas.drawRect(depart.x, depart.y, arrivee.x, arrivee.y, paint);
    }
}