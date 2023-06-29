package faang.school.godbless.sprint4.multithreading_parallelism_thread.task4;

public class ThreeLittlePigs {

    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1 = new Pig1Thread();
        Pig2Thread pig2 = new Pig2Thread();
        Pig3Thread pig3 = new Pig3Thread();

        pig1.start();
        pig2.start();
        pig3.start();

        pig1.join();
        pig3.join();
        pig2.join();

        System.out.println("Игра завершена!");
    }
}
