package C21416084;
import ie.tudublin.*;

import processing.core.PApplet;

public class BlurredVision
{
    YofukaVisuals yv;
    float sz = 0;
    float x = 0;
    float[] lerpedBuffer;
    
    public BlurredVision(YofukaVisuals yv)
    {
        this.yv = yv;
        sz = this.yv.height / 2;
        x = 0;
        lerpedBuffer = new float[this.yv.width];
    }
    
    
    public void render()
    {
        yv.colorMode(PApplet.HSB);

        for (int i = 0; i < yv.getAudioBuffer().size(); i++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], yv.getAudioBuffer().get(i), 0.05f);
            yv.stroke(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, 0) , 0, 255);

            float lr = lerpedBuffer[i] * sz * 16.0f;

            yv.line(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width), 0, PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width), (0) + (sz *(0.001f*lr))  );
            yv.line(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width), sz + sz, PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width), (sz+sz) + (sz *(0.001f*lr))  );
        }
    }
}
        
