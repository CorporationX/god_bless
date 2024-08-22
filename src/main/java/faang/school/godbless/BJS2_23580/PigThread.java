package faang.school.godbless.BJS2_23580;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class PigThread extends Thread {
    private String name;
    private Material material;

    @Override
    public void run() {
        System.out.println(name + " начинает строить дом из " + material);
        try {
            Thread.sleep(material.getTimeBuild());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println(name + " закончил строить дом из " + material);
    }
}
