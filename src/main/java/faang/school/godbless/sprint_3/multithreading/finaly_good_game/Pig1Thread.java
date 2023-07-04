package faang.school.godbless.sprint_3.multithreading.finaly_good_game;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String name, int material) {
        super(name, material);
    }

    @Override
    public void run() {
        String pigName = super.getPigName();
        int materialNumber = super.getMaterial() - 1;
        String material = super.getHomeMaterials().get(materialNumber);
        System.out.printf("%s начинает постройку дома в котором есть только %s....%n", pigName, material);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s успешно посторил свой дом.%n", pigName);
    }
}
