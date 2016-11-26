package speed.Timer;

public class Timer implements Runnable {

    private Thread runThread;
    public boolean running = false;
    private SpeedTimer speedTimer;

    private long summedTime = 0;

    public Timer(SpeedTimer speedTimer) {
        this.speedTimer = speedTimer;
    }

    public static void main(String[] args) throws InterruptedException{
        SpeedTimer t = new SpeedTimer();

    }

    public void startTimer() {
        running = true;
        // start the thread up
        runThread = new Thread(this);
        runThread.start();
    }



    public void stopTimer() {
        // completely stop the timer
        running = false;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        // keep showing the difference in time until we are either paused or not running anymore
        while(running) {
            SpeedTimer.update(summedTime + (System.currentTimeMillis() - startTime));
        }

    }
}
