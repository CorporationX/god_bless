package school.faang.task3110.pigs;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class PigThread extends Thread {
    private String pigName;
    private String material;

    @Override
    public void run() {
        switch (material) {
            case "солома":
                try {
                    System.out.println(pigName + " строит дом из " + material);
                    Thread.sleep(1000);
                    System.out.println(pigName + " достроил дом из " + material);
                    break;
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            case "палки":
                try {
                    System.out.println(pigName + " строит дом из " + material);
                    Thread.sleep(3000);
                    System.out.println(pigName + " достроил дом из " + material);
                    break;
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            case "кирпичи":
                try {
                    System.out.println(pigName + " строит дом из " + material);
                    Thread.sleep(5000);
                    System.out.println(pigName + " достроил дом из " + material);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e.getMessage());
                }
        }
    }
}
