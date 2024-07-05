package com.hpbolduc.hpbolductp1;

import android.graphics.Canvas;

public class TraceLibre extends ObjetSuper {

    // Constructeur
    public TraceLibre () {
        super();
    }

    // Methode de la classe
    public void dessiner (Canvas canvas) {
        canvas.drawPath(path, paint);
    }
}
