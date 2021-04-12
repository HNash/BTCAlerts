import java.util.Timer;
import java.util.TimerTask;

public class Notifier
{
    // Timer
    public Timer timer;

    public Notifier()
    {
        timer = new Timer();
        // Scheduling a PriceFetchTask with the timer to be executed after 1 minute
        timer.schedule(new PriceFetchTask(), 60000); // Time before next task is executed in ms
    }

    class PriceFetchTask extends TimerTask
    {
        public void run()
        {
            // Calls getPrice(), which checks the price and compares it to the previous price
            PriceFetcher.getPrice();
            // Terminates the timer thread
            timer.cancel();
            // Starts a new notifier
            Main.notifier = new Notifier();
        }
    }
}