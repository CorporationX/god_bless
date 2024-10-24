package school.faangSprint3.t17;

public class Main {
    public static void main(String[] args) {
        System.out.println("Игра \"Три поросёнка\" начинается!");

        Pig1Thread nifNif = new Pig1Thread();
        Pig2Thread nufNuf = new Pig2Thread();
        Pig3Thread nafNaf = new Pig3Thread();

        nifNif.start();
        nufNuf.start();
        nafNaf.start();

        try {
            nifNif.join();
            nufNuf.join();
            nafNaf.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Игра завершена! Все поросята построили свои дома.");
    }
}