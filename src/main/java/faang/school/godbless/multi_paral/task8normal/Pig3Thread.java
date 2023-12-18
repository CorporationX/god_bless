package faang.school.godbless.multi_paral.task8normal;

public class Pig3Thread extends PigThread{
    public Pig3Thread() {
        super("Наф-Наф" , 3);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " строит дом из кирпичей...");
            Thread.sleep(3000);
            System.out.println(getPigName() + " завершил строительство! Уровень защиты: " + getMaterial());
        } catch (InterruptedException e) {
            System.out.println("Строительство прервано");        }
    }
}
