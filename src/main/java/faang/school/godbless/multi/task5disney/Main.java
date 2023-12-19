package faang.school.godbless.multi.task5disney;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DisneyRide disneyRide = new DisneyRide();


        disneyRide.startRide(5);
        System.out.println("Аттракцион запущен.");
        Thread.sleep(2000);


        disneyRide.stopRide();
        Thread.sleep(1000);
        System.out.println("Аттракцион приостановлен.");

    }
}
