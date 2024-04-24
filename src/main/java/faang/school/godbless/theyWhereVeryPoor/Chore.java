package faang.school.godbless.theyWhereVeryPoor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore  implements Runnable{
    private String chore;


    @Override
    public void run() {
        Thread.currentThread().setName(chore);
        System.out.println("Executing "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("Executing "+Thread.currentThread().getName()+ " is done");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

