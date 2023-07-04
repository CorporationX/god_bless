package faang.school.godbless.sprint_3.multithreading.finaly_good_game;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String name, int material) {
        super(name, material);
    }

    @Override
    public void run() {
        String pigName = super.getPigName();
        int materialNumber = super.getMaterial() - 1;
        String material = super.getHomeMaterials().get(materialNumber);
        System.out.printf("%s начинает постройку дома в котором есть только %s....%n", pigName, material);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s успешно посторил свой дом.%n", pigName);
    }
}
