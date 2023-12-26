package faang.school.godbless.NormalGame;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Наф-Наф", 2);
    }

    @Override
    public void run() {
        System.out.println("Поросенок " + this.getPigName() + " строит дом из кирпичей в потоке" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка при строительстве");
        }
        System.out.println("Дом из кирпичей построен");
    }
}
