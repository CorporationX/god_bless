package faang.school.godbless.normGame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PigThread extends Thread{
    @NonNull
    private String pigName;
    @NonNull
    private String material;

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " построил дом из " + getMaterial());
    }
}
