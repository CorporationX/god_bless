package faang.school.godbless.sprint_3.multithreading.finaly_good_game;

public class Pig1Thread extends PigThread {
    @Override
    public void run() {
        PigThread pig = new PigThread("Ниф-Ниф", 1);
        String pigName = pig.getPigName();
        int materialNumber = pig.getMaterial() - 1;
        String material = pig.getHomeMaterials().get(materialNumber);
        System.out.printf("%s начинает постройку дома в котором есть только %s....%n", pigName, material);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s успешно посторил свой дом.%n", pigName);
    }
}
