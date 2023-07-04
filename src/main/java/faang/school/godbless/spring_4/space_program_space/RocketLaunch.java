package faang.school.godbless.spring_4.space_program_space;

import java.util.concurrent.TimeUnit;

public class RocketLaunch implements Runnable {
    private final String nameStartup;
    private final Integer launchTime;

    public RocketLaunch(String nameStartup, int launchTime) {
        this.nameStartup = nameStartup;
        this.launchTime = launchTime;
    }

    public void launch() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("The rocket is launched: " + nameStartup);
    }

    public String getNameStartup() {
        return nameStartup;
    }

    public Integer getLaunchTime() {
        return launchTime;
    }

    @Override
    public void run() {
        try {
            launch();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public int compareTo(RocketLaunch o) {
//        return this.getLaunchTime().compareTo(o.getLaunchTime());
//    }
}
