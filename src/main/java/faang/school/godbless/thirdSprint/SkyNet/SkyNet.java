package faang.school.godbless.thirdSprint.SkyNet;

public class SkyNet {
    public static void main(String[] args) {
        Robot bib = new Robot("Bib", "ребёнок");
        Robot bob = new Robot("Bob", "бабушка");

        Thread thread1 = new Thread(bib::attack);
        Thread thread2 = new Thread(bob::attack);
        thread1.start();
        thread2.start();
    }
}
