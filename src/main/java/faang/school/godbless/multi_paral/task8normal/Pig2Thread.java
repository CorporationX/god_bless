package faang.school.godbless.multi_paral.task8normal;

public class Pig2Thread extends PigThread{
    public Pig2Thread() {
        super("Нуф-Нуф", 2);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " строит дом из палок...");
            Thread.sleep(2000);
            System.out.println(getPigName() + " завершил строительство! Уровень защиты: " + getMaterial());
        } catch (InterruptedException e) {
            System.out.println("Строительство прервано");
        }
    }
}
