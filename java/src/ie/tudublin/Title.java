package ie.tudublin;

import processing.core.PConstants;
import processing.core.PFont;

public class Title
{
    YofukaVisuals yv;
    PFont f;
    float x;
    float y;

    public Title(YofukaVisuals yv){
        this.yv = yv;
        x = this.yv.width;
        y = this.yv.height;

        
        f = yv.createFont("Por_Siempre_Gotica.ttf", 120);
        yv.textFont(f);
    }

    public void render()
    {
        yv.fill(255);
        yv.textAlign(PConstants.CENTER, PConstants.CENTER);
        yv.text("Press Spacebar To Begin", x/2, y/2);
    }
}