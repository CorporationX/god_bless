package faang.school.godbless.multi_paral.task8normal;

public class Pig1Thread extends PigThread{
    public Pig1Thread() {
        super("Ниф-Ниф", 1);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " строит дом из соломы...");
            Thread.sleep(1000);
            System.out.println(getPigName() + " завершил строительство! Уровень защиты: " + getMaterial());
        } catch (InterruptedException e) {
            System.out.println("Строительство прервано");        }
    }
}
