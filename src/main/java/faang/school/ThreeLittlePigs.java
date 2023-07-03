package faang.school;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Pig1Thread("НифНиф", "солома");
        Thread second = new Pig1Thread("НафНаф", "палки");
        Thread third = new Pig1Thread("НуфНуф", "кирпичи");

        first.start();
        second.start();
        third.start();

        first.join();
        second.join();
        third.join();
        System.out.println("Game over");





    }
}
