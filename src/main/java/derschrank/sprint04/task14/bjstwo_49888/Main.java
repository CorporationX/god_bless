package derschrank.sprint04.task14.bjstwo_49888;

public class Main {
    private static final int POINTS_FOR_CALCULATING_PI = 1000000;

    public static void main(String[] args) {
        Pi pi = new Pi();
        System.out.println("PI = " + pi.calculatePi(POINTS_FOR_CALCULATING_PI));
    }
}
