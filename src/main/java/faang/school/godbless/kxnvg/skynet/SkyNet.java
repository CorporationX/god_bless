package faang.school.godbless.kxnvg.skynet;

public class SkyNet {

    public static void main(String[] args) {
        String target1 = new String("Император");
        String target2 = new String("Дарт Вейдер");
        Robot r2d2 = new Robot("Р2Д2", target1);
        Robot c3po = new Robot("С-3РО", target2);

        Thread thread1 = new Thread(r2d2::attack);
        Thread thread2 = new Thread(c3po::attack);

        thread1.start();
        thread2.start();
    }
}
