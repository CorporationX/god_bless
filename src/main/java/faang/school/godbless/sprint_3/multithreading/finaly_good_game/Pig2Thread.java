package faang.school.godbless.sprint_3.multithreading.finaly_good_game;

public class Pig2Thread extends PigThread {
    @Override
    public void run() {
        PigThread pig = new PigThread("Нуф-Нуф", 2);
        String pigName = pig.getPigName();
        int materialNumber = pig.getMaterial() - 1;
        String material = pig.getHomeMaterials().get(materialNumber);
        System.out.printf("%s начинает постройку дома в котором есть только %s....%n", pigName, material);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s успешно посторил свой дом.%n", pigName);
    }
}

