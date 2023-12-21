package faang.school.godbless.multi.task10skynet;

public class SkyNet {
    public static void main(String[] args) throws InterruptedException {
        Robot robot1 =  new Robot("Cара Коннор");
        Robot robot2 =  new Robot("Cара Коннор");
        Robot robot3 =  new Robot("Кайл Риз");

        Thread thread1 = new Thread(robot1::attack);
        Thread thread2 = new Thread(robot2::attack);
        Thread thread3 = new Thread(robot3::attack);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
