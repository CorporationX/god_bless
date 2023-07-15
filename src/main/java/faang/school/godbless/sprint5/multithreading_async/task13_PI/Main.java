package faang.school.godbless.sprint5.multithreading_async.task13_PI;

public class Main {

    public static void main(String[] args) {
        GreatPi greatPi = new GreatPi();

        double pi = greatPi.createPi(1);
        System.out.println(pi);
    }
}
