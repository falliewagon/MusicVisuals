package ie.tudublin;

import C21416084.*;

public class YofukaVisuals extends Visual
{
    // Declare Visuals Start
    public Counter counter;

    Title ts;
    IntroVisual iv;
    WaveVisual wv;
    SkyFall sf;
    EclipseOn eo;


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

        iv = new IntroVisual(this);
        wv = new WaveVisual(this);
        sf = new SkyFall(this);
        eo = new EclipseOn(this);
        // Intialise Visuals End
    }

    public void keyPressed()
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

        //Test Player
        /*
        if(counter.playing && counter.seconds() < 500){
            eo.render();
        } 
        */
        

        
        if(counter.playing && counter.seconds() < 6){
            iv.render();
        }        
        
        if (counter.playing && counter.seconds() >= 6 && counter.seconds() <= 13){
            wv.render();
        }

        if (counter.playing && counter.seconds() >= 14 && counter.seconds() <= 47){
            sf.render();
        }

        if (counter.playing && counter.seconds() >= 48 && counter.seconds() <= 95){
            eo.render();
        }
        
        
        
        
        
    }
}