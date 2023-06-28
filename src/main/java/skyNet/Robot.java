package skyNet;

public class Robot {
    private String name;
    private Target target;

    public Robot(String name, Target target) {
        this.name = name;
        this.target = target;
    }

    public void attack() {
        synchronized (target) {
            System.out.println(name + " attack " + target.getName());
        }
    }
}
