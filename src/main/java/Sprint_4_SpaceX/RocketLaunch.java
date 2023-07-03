package Sprint_4_SpaceX;

public class RocketLaunch {
    private String launchName;
    private String launchTime;

    public RocketLaunch(String launchName, String launchTime) {
        this.launchName = launchName;
        this.launchTime = launchTime;
    }

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Launch " + launchName + " at " + launchTime);
    }
}
