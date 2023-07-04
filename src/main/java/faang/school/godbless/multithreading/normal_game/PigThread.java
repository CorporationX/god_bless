package faang.school.godbless.multithreading.normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class PigThread extends Thread {
    protected String pigName;
    protected Material material;

    @Override
    public void run() {
        System.out.println("Поросенок " + pigName + " строит дом из материала - " + material);

        try {
            Thread.sleep(material.constructionTime);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Поросенок " + pigName + " построил свой дом из материала - " + material);
    }
}
