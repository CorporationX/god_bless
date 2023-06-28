package faang.school.godbless.multithreading.normal_game;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        System.out.println("Поросенок " + pigName + " строит дом из материала - " + material);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Поросенок " + pigName + " построил свой дом из материала - " + material);
    }
}
