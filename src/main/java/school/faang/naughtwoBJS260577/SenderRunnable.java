package school.faang.naughtwoBJS260577;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private final int startIndex;
    private final int endIndex;


    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("letter #%d sent%n", i);
        }
    }
}
