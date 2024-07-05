package com.hpbolduc.hpbolductp1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

public class ObjetSuper {

    // Variables
    protected Path path;
    protected Paint paint;

    protected Point depart, milieu, arrivee;
    protected float rayon;

    protected boolean efface;

    // Constructeur
    public ObjetSuper () {
        this.path = new Path();

        this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(Color.BLACK);
        this.paint.setStrokeWidth(0);

        this.efface = false;

        this.depart = new Point();
        this.milieu = new Point();
        this.arrivee = new Point();
    }

    // Getter / Setter
    public void setColor(int color) { this.paint.setColor(color); }
    public void setEpaisseurTrait(int epaisseurTrait) { this.paint.setStrokeWidth(epaisseurTrait); }

    public void setEfface(boolean efface) { this.efface = efface; }
    public boolean isEfface() { return efface; }

    public void setPathMoveTo(Point depart) { this.path.moveTo(depart.x, depart.y); }
    public void setPathLineTo(Point milieu) { this.path.lineTo(milieu.x, milieu.y); }
    public void setPathTriangle() {
        path.reset();
        path.moveTo(depart.x, depart.y);
        path.lineTo(milieu.x, milieu.y);
        path.lineTo(arrivee.x, arrivee.y);
        path.close();
    }

    public void setDepart(Point depart) { this.depart = depart; }
    public void setMilieu(Point milieu) { this.milieu = milieu; }
    public void setArrivee(Point arrivee) { this.arrivee = arrivee; }

    public void setRayon(Point milieu) {
        rayon = (float) Math.sqrt(Math.pow(depart.y - milieu.y, 2) + Math.pow(depart.x - milieu.x, 2));
    }

    // Methode à redéfinir
    protected void dessiner(Canvas canvas) {};
}