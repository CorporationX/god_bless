package faang.school.godbless.kxnvg.skynet;

public class SkyNet {

    public static void main(String[] args) {
        Robot r2d2 = new Robot("Р2Д2", "Император");
        Robot c3po = new Robot("С-3РО", "Дарт Вейдер");

        Thread thread1 = new Thread(r2d2::attack);
        Thread thread2 = new Thread(c3po::attack);

        thread1.start();
        thread2.start();
    }
}
