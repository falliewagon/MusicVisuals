package C21416084;
import ie.tudublin.*;

import processing.core.PConstants;

public class CallOfTheNight
{
    YofukaVisuals yv;
    float x = 0;
    float y = 0;
    float z = 0;
    float i = 0;
    float j = 0;

    public CallOfTheNight(YofukaVisuals yv)
    {
        this.yv = yv;
        x = this.yv.width;
        y = this.yv.height;
        z = this.yv.height / 2;
    }

    public void render()
    {
        yv.stroke(255);
        yv.strokeWeight(2);
        yv.line(x, y/8, x-i, y / 8);
        yv.line(0, y - y / 8, 0 + j, y - y / 8);

        if (i < x)
        {
            i = i + (0.003f*x);
        }

        if (j < x)
        {
            j = j + (0.003f*x);
        }

        yv.textSize(120);
        yv.fill(255, 255, 255);
        yv.textAlign(PConstants.CENTER, PConstants.CENTER);
        yv.text("Yofukashino Uta", x/2, y/2);


    }
}