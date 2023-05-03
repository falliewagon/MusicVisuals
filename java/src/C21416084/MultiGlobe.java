package C21416084;
import ie.tudublin.*;

import processing.core.PApplet;

public class MultiGlobe
{
    YofukaVisuals yv;
    float x;
    float sz;
    float[] lerpedBuffer;

    public MultiGlobe(YofukaVisuals yv) 
    {
        this.yv = yv;
        x = 0;
        sz = this.yv.height / 2;
        lerpedBuffer = new float[this.yv.width];
    }


    public void render()
    {
        yv.stroke(255);
        yv.colorMode(PApplet.HSB);


        /* 
        for(int i = 0 ; i < yv.getAudioBuffer().size() ; i++) 
        {
            yv.line(PApplet.cos(i)*245, PApplet.sin(i)*245, PApplet.cos(i)*PApplet.abs(yv.getAudioBuffer().size())*200 + PApplet.cos(i)*245, PApplet.sin(i)*PApplet.abs(yv.getAudioBuffer().size())*200 + PApplet.sin(i)*245);
        }
        */

        for (int i = 0; i < yv.getAudioBuffer().size(); i++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], yv.getAudioBuffer().get(i), 0.05f);
            yv.stroke(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, 0) , 0, 255);

            float lr = lerpedBuffer[i] * sz * 16.0f;

            yv.circle(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width), 0, PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width));
        }
    }
    
}