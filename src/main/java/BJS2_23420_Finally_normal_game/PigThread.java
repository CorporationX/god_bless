package BJS2_23420_Finally_normal_game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PigThread extends Thread {
    private String pigName;
    private int material;

    public void buildHome() {

        System.out.printf("%s роет котлован на %d  кубов!", getPigName(), getMaterial());
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        System.out.printf("%s заливает фундамент.", getPigName());
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        System.out.printf("%s кладёт кирпич.", getPigName());
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        System.out.println(getPigName() + " монтирует крышу.");
    }

    public void gameOver() {
        System.out.println("игра завершена!");
    }
}
