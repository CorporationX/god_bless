package faang.school;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread{
    private String pigName;
    private String material;

    @Override
    public void run() {
        System.out.println(getPigName() + " построил дом из " + getMaterial());
    }
}
