package faang.school.godbless.sprint5.Multithreading_Async.task13_PI;

public class Main {

    public static void main(String[] args) {
        GreatPi greatPi = new GreatPi();

        double pi = greatPi.createPi(1);
        System.out.println(pi);
    }
}
