package school.faang.task3110.pigs;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class PigThread extends Thread {
    private String pigName;
    private String material;

    @Override
    public abstract void run();
}

