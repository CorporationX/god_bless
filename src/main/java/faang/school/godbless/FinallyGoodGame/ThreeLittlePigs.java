package faang.school.godbless.FinallyGoodGame;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        PigThread thread1 = new Pig1Thread("NifNif","straw");
        PigThread thread2 = new Pig2Thread("NafNaf","sticks");
        PigThread thread3 = new Pig3Thread("NufNuf","bricks");
        List<PigThread> threads = List.of(thread1,thread2,thread3);
        for (PigThread thread: threads){
            thread.start();
            thread.buildHouse();
            thread.join();
        }
        System.out.println("Game is over");
    }
}
