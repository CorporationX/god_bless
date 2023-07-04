package faang.school.godbless.three.pigs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public abstract class PigThread extends Thread {
    private String pigName;
    private int material;

    @Override
    public void run() {
        for (int i = 0; i < getMaterial(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("дом поросёнка " + getPigName() + " " + " построен на " + i);
        }
    }
}
