package com.hpbolduc.hpbolductp1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public class SurfaceDessin extends View {

    private MainActivity mainActivity;
    private Bitmap bitmapImage;

    public SurfaceDessin(Context context, MainActivity mainActivity) {
        super(context);
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onDraw (Canvas canvas) {

        // Validation qu'un objet existe pour prévenir l'erreur au démarrage, loop les objets et dessiner
        if (!mainActivity.eSurface.getDrawVector().isEmpty())
            for ( ObjetSuper objet:mainActivity.eSurface.getDrawVector())
                objet.dessiner(canvas);
    }

    // Méthode donnée par le prof
    public Bitmap getBitmapImage() {

        this.buildDrawingCache();
        bitmapImage = Bitmap.createBitmap(this.getDrawingCache());
        this.destroyDrawingCache();

        return bitmapImage;
    }
}