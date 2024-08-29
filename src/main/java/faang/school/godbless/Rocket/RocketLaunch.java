package faang.school.godbless.Rocket;

import lombok.Getter;

@Getter
public class RocketLaunch {
    private String name;
    private long launchTime;

    public RocketLaunch(String name, long launchTime) {
        this.name = name;
        this.launchTime = launchTime;
    }

    public void launch(){
        try {
            Thread.sleep(1000);
            System.out.println("Rocket " + name + " launched at " + System.currentTimeMillis());
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Launch of rocket " + name + " was interrupted.");
        }
    }
}
