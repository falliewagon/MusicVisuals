package C21416084;
import ie.tudublin.*;

import processing.core.PApplet;

public class JoyfulIgnorance
{
    YofukaVisuals yv;
    float r = 0;
    float h = 0;
    float t = 0;
    float fx;
    float fy;
    float diameter  = 10;
    float frequency = 2.0f;
    float[] lerpedBuffer;

    public JoyfulIgnorance(YofukaVisuals yv)
    {
        this.yv = yv;

        r = this.yv.width / 2;
        h = this.yv.height;

        fx = this.yv.width / 2;
        fy = this.yv.height / 2;

        lerpedBuffer = new float[this.yv.width];
    }

    public void render()
    {
        yv.colorMode(PApplet.HSB);
        yv.strokeWeight(2);

        for(int i = 0 ; i < yv.getAudioBuffer().size() ; i++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], yv.getAudioBuffer().get(i), 0.5f);
            yv.stroke(PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, 255), 255, 255);

            float lr = lerpedBuffer[i] * (h / 2) * 12.0f;

            yv.ellipse((PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.width)), 2*(lr)*PApplet.sin(frequency*(lr))+h, diameter, diameter);
        }
        
        for(int j = 0; j < yv.getAudioBuffer().size() ; j++)
        {
            yv.noFill();
            float lb = lerpedBuffer[j] * (h / 2) * 2.0f;
            yv.circle(fx, fy, (lb)*PApplet.sin(frequency*(h)));
        }
    }
}