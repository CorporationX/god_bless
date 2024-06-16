package faang.school.godbless.spaceX;


import lombok.Getter;

@Getter
public class RocketLaunch {
    private String nameLaunch;
    private long timeLaunch;

    public RocketLaunch(String nameLaunch, long timeLaunch) {
        if (nameLaunch == null) {
            throw new IllegalArgumentException("In RocketLaunch class entered non-existent name");
        }
        if (timeLaunch == 0) {
            throw new IllegalArgumentException("The time launch not be 0 in RocketLaunch");
        }
        this.nameLaunch = nameLaunch;
        this.timeLaunch = timeLaunch;
    }

    public void launch() {
        try {
            Thread.sleep(timeLaunch);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The rocket was successfully launched");
    }
}
