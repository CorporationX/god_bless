package worked_in_microsoft;

import lombok.Getter;

import java.util.stream.IntStream;

@Getter
public class SenderRunnable implements Runnable{
    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex).forEach(i -> {
            System.out.println(i + " : mail sanded");
        });
    }
}
