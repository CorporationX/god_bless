package faang.school.godbless.NormalGame;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Нуф-Нуф", 1);
    }

    @Override
    public void run() {
        System.out.println("Поросенок " + this.getPigName() + " строит дом из палок в потоке" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка при строительстве");
        }
        System.out.println("Дом из палок построен");
    }
}
