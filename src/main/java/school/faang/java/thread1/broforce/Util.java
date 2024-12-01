package school.faang.java.thread1.broforce;

public class Util {
    public static void workingProcess(int workingTime){
        try {
            Thread.sleep(workingTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
