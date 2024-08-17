package faang.school.godbless.BJS2_19295;

import lombok.NoArgsConstructor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OptimizationTimer {
    Timer timer;

    public OptimizationTimer() {
        timer = new Timer();
    }

    protected void startOptimizationTimer(int timeInSeconds, TimerTask timerTask) {
        timer.scheduleAtFixedRate(timerTask, 0, timeInSeconds * 1000L);
    }
}
