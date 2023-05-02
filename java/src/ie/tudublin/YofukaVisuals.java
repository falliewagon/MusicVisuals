package ie.tudublin;

public class YofukaVisuals extends Visual
{
    // Declare Visuals Start
    public Counter counter;
    Title ts;


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
    }
}