package faang.school.godbless.NormalGame;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-Ниф", 0);
    }

    @Override
    public void run() {
        System.out.println("Поросенок " + this.getPigName() + " строит дом из соломы в потоке" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка при строительстве");
        }
        System.out.println("Дом из соломы построен");
    }
}
