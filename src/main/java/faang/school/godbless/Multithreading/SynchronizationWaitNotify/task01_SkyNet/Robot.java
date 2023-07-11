package faang.school.godbless.Multithreading.SynchronizationWaitNotify.task01_SkyNet;

public class Robot {
    private String target;
    public synchronized void attack(){
        System.out.println("My attack target is "+target);
    }

    public Robot(String target) {
        this.target = target;
    }
}
