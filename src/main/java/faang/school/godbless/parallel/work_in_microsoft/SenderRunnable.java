package faang.school.godbless.parallel.work_in_microsoft;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SenderRunnable implements Runnable {
    String[] letters;
    private int startIndex;
    private int endIndex;

    public SenderRunnable(String[] letters, int startIndex, int endIndex) {
        this.letters = letters;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        List<String> allIncludeList = Arrays.stream(letters).collect(Collectors.toList());
        System.out.println(allIncludeList.subList(startIndex, endIndex));
    }
}
