package C21416084;
import ie.tudublin.*;

import processing.core.PApplet;

public class WaveVisual
{
    YofukaVisuals yv;
    float cy = 0;
    float f = 0;
    float[] lerpedBuffer;
    
    public WaveVisual(YofukaVisuals yv)
    {
        this.yv = yv;
        cy = this.yv.height / 2;
        f = 0;
        lerpedBuffer = new float[this.yv.width];
    }
    
    
    public void render()
    {
        yv.colorMode(PApplet.HSB);
        for (int i = 0; i < yv.getAudioBuffer().size(); i++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], yv.getAudioBuffer().get(i), 0.05f);
            yv.stroke(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, 0) ,0 ,255);
            float feh = lerpedBuffer[i] * cy * 12.0f;

            yv.line(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width), 0, PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width), (0) + (cy *(0.001f*feh))  );
            yv.line(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width), cy + cy, PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width), (cy+cy) + (cy *(0.001f*feh))  );
        }
        
    }

        

}
        
