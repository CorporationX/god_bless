package faang.school.godbless.multithreading.normal_game;

public class Pig3Thread extends PigThread{
    public Pig3Thread(String name, String material) {
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

        System.out.println("Поросенок " + pigName + " построил дом из материала - " + material);
    }
}
