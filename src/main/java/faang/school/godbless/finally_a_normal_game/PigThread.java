package faang.school.godbless.finally_a_normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Getter

public class PigThread extends Thread{
    private String pigName;
    private String material;
    private long timeToBuild;

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(this.getPigName() + " начал строить дом из " + this.getMaterial());
        Thread.sleep(timeToBuild);
        System.out.println(this.getPigName() + " построил дом из " + this.getMaterial() + "!");
    }
}
