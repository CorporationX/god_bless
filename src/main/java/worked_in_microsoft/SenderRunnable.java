package worked_in_microsoft;

import lombok.Getter;

import java.util.stream.IntStream;

@Getter
public class SenderRunnable implements Runnable{
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    @Override
    public void run() {
        IntStream.range(startIndex, endIndex).forEach(i -> System.out.println(i + " : mail sanded"));
    }
}
