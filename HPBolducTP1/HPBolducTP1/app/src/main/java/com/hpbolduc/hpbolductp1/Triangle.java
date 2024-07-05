package com.hpbolduc.hpbolductp1;

import android.graphics.Canvas;

public class Triangle extends ObjetSuper {

    // Constructeur
    public Triangle() {
        super();
    }

    // Methode de la classe
    public void dessiner (Canvas canvas) {
        canvas.drawPath(path, paint);
    }
}