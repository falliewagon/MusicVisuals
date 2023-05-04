package C21416084;
import ie.tudublin.*;

import processing.core.PApplet;

public class CrowdAnxiety
{
    YofukaVisuals yv;
    float x = 0;
    float y = 0;
    float t = 0;
    float c2 = 0;
    float c3 = 0;
    float c4 = 0;
    float diameter  = 10;
    float frequency = 2.0f;
    float[] lerpedBuffer;

    public CrowdAnxiety(YofukaVisuals yv)
    {
        this.yv = yv;
        
        x = this.yv.width / 2;
        y = this.yv.height;
        lerpedBuffer = new float[this.yv.width];
    }

    public void render()
    {
        yv.colorMode(PApplet.HSB);
        yv.strokeWeight(2);
        c4 = 255;
        for(int i = 0 ; i < yv.getAudioBuffer().size() ; i++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], yv.getAudioBuffer().get(i), 0.5f);
            yv.stroke(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, c2), c3, c4);

            float lr = lerpedBuffer[i] * (y / 2) * 12.0f;

            yv.ellipse((PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width)), 2*(lr)*PApplet.sin(frequency*(lr))+y, diameter, diameter);

            if(yv.counter.seconds() >= 23.6)
            {
                c2 = 255;
                c3 = 255;
                c4 = 255;
            }
        } // end for
    } // end render
}