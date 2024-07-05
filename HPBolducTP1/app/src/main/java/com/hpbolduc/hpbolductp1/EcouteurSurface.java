package com.hpbolduc.hpbolductp1;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.Vector;

//Étape 3 - Surface de dessin
public class EcouteurSurface implements View.OnTouchListener {

    // Variables
    private MainActivity mainActivity;
    private String option;

    private Point posClick, posMove;
    private int color;
    private int epaisseurTrait;

    private boolean nouvelObjet, premierClick;

    private Vector<ObjetSuper> drawVector;

    // Constructeur
    public EcouteurSurface(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.drawVector = new Vector<ObjetSuper>();
        this.nouvelObjet = false;
        this.premierClick = true;
    }

    // Getter
    public Vector<ObjetSuper> getDrawVector() {
        return drawVector;
    }

    // Méthode de View.OnTouch
    @Override
    public boolean onTouch(View source, MotionEvent motionEvent) {

        // Aller chercher les infos nécessaire pour la création de l'objet
        option = mainActivity.eOption.getOption();
        epaisseurTrait = mainActivity.seekBarFrag.getEpaisseurTrait();

        // Définir la couleur de Background si c'est une efface
        if (option.equals("ButtonEfface"))
            color = ((ColorDrawable) mainActivity.drawingLayout.getBackground()).getColor();
        else
            color = mainActivity.eCouleur.getColor();

        // Action de la souris
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            posClick = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            pathObjectDown();
            mainActivity.surfaceD.invalidate();

        } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            posMove = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            pathObjectMove();
            mainActivity.surfaceD.invalidate();

        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            pathObjectUp();

        } else {
            posClick = null;
            posMove = null;
        }

        // Définir la couleur et l'épaisseur du trait si c'est un nouvel objet
        if (nouvelObjet) {
            drawVector.lastElement().setColor(color);
            drawVector.lastElement().setEpaisseurTrait(epaisseurTrait);
        }

        return true;
    }

    private void pathObjectDown() {
        if (option.equals("ButtonCrayon") || option.equals("ButtonEfface")) {
            drawVector.addElement(new TraceLibre());
            drawVector.lastElement().setPathMoveTo(posClick);

            if (option.equals("ButtonEfface"))
                drawVector.lastElement().setEfface(true);

            nouvelObjet = true;
            premierClick = true;

        } else if (option.equals("ButtonCercle")) {
            drawVector.addElement(new Cercle());
            drawVector.lastElement().setDepart(posClick);
            drawVector.lastElement().setRayon(posClick);

            nouvelObjet = true;
            premierClick = true;

        } else if (option.equals("ButtonTriangle")) {
            if (premierClick) {
                drawVector.addElement(new Triangle());
                drawVector.lastElement().setDepart(posClick);
                drawVector.lastElement().setMilieu(posClick);
                drawVector.lastElement().setArrivee(posClick);
                drawVector.lastElement().setPathTriangle();

                nouvelObjet = true;
            } else {
                drawVector.lastElement().setArrivee(posClick);
                drawVector.lastElement().setPathTriangle();
            }

        } else if (option.equals("ButtonRectangle")) {
            drawVector.addElement(new Rectangle());
            drawVector.lastElement().setDepart(posClick);
            drawVector.lastElement().setArrivee(posClick);

            nouvelObjet = true;
            premierClick = true;

        } else if (option.equals("ButtonPipette")) {
            // Enregistrer la couleur de la pipette
            color = mainActivity.surfaceD.getBitmapImage().getPixel(posClick.x, posClick.y);

            // Si couleur = 0, alors on a cliquer dans le background
            if (color == 0)
                color = ((ColorDrawable) mainActivity.drawingLayout.getBackground()).getColor();

            // Set color / option
            mainActivity.eCouleur.setColor(color);
            mainActivity.eOption.setOption("ButtonCrayon");
        }
    }

    private void pathObjectMove() {
        if (option.equals("ButtonCrayon") || option.equals("ButtonEfface")) {
            drawVector.lastElement().setPathLineTo(posMove);

        } else if (option.equals("ButtonCercle")) {
            drawVector.lastElement().setRayon(posMove);

        } else if (option.equals("ButtonRectangle")) {
            drawVector.lastElement().setArrivee(posMove);

        } else if (option.equals("ButtonTriangle")) {
            if (premierClick) {
                drawVector.lastElement().setMilieu(posMove);
            } else {
                drawVector.lastElement().setArrivee(posMove);
            }

            drawVector.lastElement().setPathTriangle();
        }
    }

    private void pathObjectUp() {
        if (option.equals("ButtonTriangle")) {
            if (premierClick) {
                premierClick = false;
                nouvelObjet = false;
            } else
                premierClick = true;
        }
        else
            nouvelObjet = false;
    }
}
