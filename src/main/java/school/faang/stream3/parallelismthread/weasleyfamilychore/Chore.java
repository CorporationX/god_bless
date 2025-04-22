package school.faang.stream3.parallelismthread.weasleyfamilychore;

import lombok.Data;

@Data
public class Chore implements Runnable{
    private final String chore;

    @Override
    public void run() {

    }
}
