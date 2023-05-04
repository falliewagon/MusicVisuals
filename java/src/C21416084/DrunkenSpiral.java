package C21416084;
import ie.tudublin.*;

import processing.core.PApplet;

public class DrunkenSpiral
{
    YofukaVisuals yv;

    float x;
    float y;

    double r = 0;
    double ht = 0;
    double cx;
    double op; 

    double edY;
    double edX;

    float feX;
    float feY;

    boolean sCk;

    float lH;
    float lW; 
    float rH;
    float rW; 
    float mH;
    float mW; 

    float bX;
    float eY;

    float corner;

    public DrunkenSpiral(YofukaVisuals yv)
    {
        this.yv = yv;
        
        x = this.yv.width;
        y = this.yv.height;
    }

    public void render()
    {
        yv.stroke(255);
        yv.calculateAverageAmplitude();
        yv.colorMode(PApplet.HSB);
        
        for (int a = 0; a < 30; a++){
            spin(a);
        } 
    }

    public void spin(int stagger)
    {
        float amp = yv.getSmoothedAmplitude(); 
        
        lH = y/3;
        lW = x/3;
        mH = y/2;
        mW = x/2; 

        rH = y/3;
        rW = x-(x/3); 

        yv.strokeWeight(amp*25);
        yv.stroke(400*(amp/2), 400, 400);

        r = r + .005;

        if(yv.counter.seconds() > 69)
        {
            if (sCk == true)
            {
                ht = ht + .000006*x;
                if (ht>x/8)
                {
                    sCk=false;
                }
            }
            if (sCk == false)
            {
                ht = ht - .000006*x;
                if (ht<x/10)
                {
                    sCk=true;
                }
            }
        }
        else
        {
            if(ht<0.75*x)
            {
                ht = ht + 0.00002*x;
            }
        }

        corner = (float) ht;

        if(yv.counter.seconds() < 97.5 & ht > .00003*x)
        {
            feX = mW;
            feY = mH;

            for(int i = 0; i < 8; i++)
            {
                if (i%2==0)
                {
                    cx = Math.cos(Math.toRadians(stagger*12 + r - 15))*ht/i;
                    op = Math.sin(Math.toRadians(stagger*12 + r - 15))*ht/i;

                    bX = feX;
                    eY = feY;

                    edX = cx + mW;
                    edY = op + mH;

                    feX = (float) edX;
                    feY = (float) edY;

                    yv.line(bX, eY, feX, feY);
                }
                else
                {
                    cx = Math.cos(Math.toRadians(stagger*12 + r + 15))*ht/i;
                    op = Math.sin(Math.toRadians(stagger*12 + r + 15))*ht/i;

                    bX = feX;
                    eY = feY;

                    edX = cx + mW;
                    edY = op + mH;

                    feX = (float) edX;
                    feY = (float) edY;
                    
                    yv.line(bX, eY, feX, feY);
                }
            }

            
            if(yv.counter.seconds() < 97.5 & ht > .00003*x )
            {
                cx = Math.cos(Math.toRadians(0 + stagger*12 + r))*ht;
                op = Math.sin(Math.toRadians(0 + stagger*12 + r))*ht;
                
                yv.noFill();

                for(int i = 0; i<8; i++)
                {
                    float cCr = (float) (ht*2)/i;
                    yv.circle(mW, mH, cCr);
                }
            }
        }
    }
}
