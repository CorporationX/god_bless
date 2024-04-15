package faang.school.godbless.BJS2_5522;

public class Player {
    private Object lock = new Object();
    private boolean isPlating = false;

    public void play() {
        synchronized (lock){
            isPlating = true;
            System.out.println(isPlating);
        }
    }

    public void pause() {
        synchronized (lock){
            isPlating = false;
            System.out.println(isPlating);
        }
    }

    public void scip() {
        synchronized (lock){
            isPlating = true;
            System.out.println(isPlating);
        }
    }

    public void previous() {
        synchronized (lock){
            isPlating = true;
            System.out.println(isPlating);
        }
    }
}
