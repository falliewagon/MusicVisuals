package ie.tudublin;

import C21416084.*;

public class YofukaVisuals extends Visual
{
    // Declare Visuals Start
    public Counter counter;
    Title ts;

    CallOfTheNight cn;
    BlurredVision bv;
    CrowdAnxiety ca;
    DrunkenSpiral ds;
    JoyfulIgnorance ji;
    // Declare Visuals End

    public void settings()
    {
        fullScreen(P3D);
    }

    public void setup()
    {
        surface.setLocation(100, 100);
        startMinim();
        strokeWeight(2);

        /*
            Song is Yofukashino Uta by Creepy Nuts
            https://www.youtube.com/watch?v=zArhnXbh3Yc&ab_channel=CreepyNuts-Topic
        */

        loadAudio("YofukashinoUta.mp3");

        // Intialise Visuals Start
        counter = new Counter(this);
        ts = new Title(this);

        cn = new CallOfTheNight(this);
        bv = new BlurredVision(this);
        ca = new CrowdAnxiety(this);
        ds = new DrunkenSpiral(this);
        ji = new JoyfulIgnorance(this);
        // Intialise Visuals End
    }

    public void keyPressed() // when spacebar is pressed the counter starts and the song plays
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            counter.start();
        }
    }

    public void draw()
    {
        background(0);

        if(!counter.playing)
        {
            ts.render();
        }

        // Test Player (just remove the /* */ to make it run whichever visual you want to test)
        // N.B. Drunken spiral however is specifically timed so you have to play the song as a whole to see it work as intended

        /* 
        if(counter.playing && counter.seconds() < 500){
            ji.render();
        } 
        */
        
        // /* 
        if(counter.playing && counter.seconds() < 6){
            cn.render(); // Call of the Night
        }        
        
        if (counter.playing && counter.seconds() >= 6 && counter.seconds() <= 13){
            bv.render(); // Blurred Vision
        }

        if (counter.playing && counter.seconds() >= 14 && counter.seconds() <= 47){
            ca.render(); // Crowd Anxiety
        }

        if (counter.playing && counter.seconds() >= 48 && counter.seconds() <= 95){
            ds.render(); // Drunken Spiral
        }

        if (counter.playing && counter.seconds() >= 97.1 && counter.seconds() <= 130){
            ji.render(); // Joyful Ignorance
        }
        // */
    }
}