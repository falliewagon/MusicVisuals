package ie.tudublin;

public class Counter
{
    int start = 0;
    boolean playing = false;

    YofukaVisuals yv;

    public Counter(YofukaVisuals yv)
    {
        this.yv = yv;
    }

    public int timeCount()
    {
        int time = (yv.millis()-start);

        return time;
    }



    public int seconds()
    {
        return timeCount() / 1000;
    }



    public void start()
    {
        start = yv.millis();
        playing = true;
    }

    public void stop()
    {
        playing = false;
    }
}