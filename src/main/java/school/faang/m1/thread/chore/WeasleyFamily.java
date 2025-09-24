package school.faang.m1.thread.chore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    private final List<String> choreList = new ArrayList<>();
    private final ExecutorService executorsService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.choreList.add("wash dishes");
        weasleyFamily.choreList.add("swipe floor");
        weasleyFamily.choreList.add("cook lunch");
        weasleyFamily.choreList.add("clean windows");
        weasleyFamily.choreList.add("arrange");

        for (String chore : weasleyFamily.choreList) {
            weasleyFamily.executorsService.submit(new Chore(chore));
        }
    }
}
