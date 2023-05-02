package C21416084;
import ie.tudublin.*;

import processing.core.PApplet;
import processing.core.PConstants;

public class IntroTest {
    YofukaVisuals yv;
    float x;
    float y;
    float cy = 0;
    float f = 0;
    float i = 0;
    float j = 0;
    float[] lerpedBuffer;
    public IntroTest(YofukaVisuals yv)
    {
        this.yv = yv;
        x = this.yv.width;
        y = this.yv.height;
        cy = this.yv.height / 2;
        f = 0;
        lerpedBuffer = new float[this.yv.width];
    }

    public void render()
    {
        //LineIntro
        yv.stroke(255);
        yv.strokeWeight(2);
        yv.line(x, y/8, x-i, y / 8);
        yv.line(0, y - y / 8, 0 + j, y - y / 8);

        if (i < x){
            i = i + (0.003f*x);
        }

        if (j < x){
            j = j + (0.003f*x);
        }

        //Piano
        yv.stroke(255);
        yv.line(x/2, y/2 - 50, x/2 - 50, y/2 - 50);
        yv.line(x/2 - 50, y/2 - 50, x/2 - 50, y/2 - 75);
        yv.line(x/2 - 50, y/2 - 75, x/2, y/2 - 75);

        yv.line(x/2, y/2 - 50, x/2 + 50, y/2 - 50);
        yv.line(x/2 + 50, y/2 - 50, x/2 + 50, y/2 - 75);
        yv.line(x/2 + 50, y/2 - 75, x/2, y/2 - 75);

        yv.line(x/2 + 45, y/2 - 50, x/2 + 45, y/2-25);
        yv.line(x/2 - 45, y/2 - 50, x/2 - 45, y/2-25);
        
        
        yv.line(x/2 + 45, y/2 - 75, x/2+25, y/2 - 125);
        yv.line(x/2 - 45, y/2 - 75, x/2+35, y/2 - 135);

        //WaveForm
        yv.colorMode(PApplet.HSB);
        for (int i = 0; i < yv.getAudioBuffer().size(); i++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], yv.getAudioBuffer().get(i), 0.05f);
            yv.stroke
            (
                PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, 255),
                255,
                255
            );
            float feh = lerpedBuffer[i] * cy * 4.0f;
            yv.line(cy+cy+cy,PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.height), (cy+cy+cy) + (cy*(0.001f*feh)), PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.height) );
            yv.line(cy/2, PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.height), (cy/2) + (cy *(0.001f*feh)), PApplet.map(i, 0, yv.getAudioBuffer().size(), 0, yv.height) );
        }

        //Title
        yv.textSize(48);
        yv.colorMode(PConstants.RGB);
        yv.fill(255, 0, 0);
        yv.textAlign(PConstants.CENTER, PConstants.CENTER);
        yv.text("Yofukashino \nUta", x/2, y/2);


    }
}