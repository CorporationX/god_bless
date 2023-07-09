package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task8;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String view) {
        viewsMap.put(view, viewsMap.getOrDefault(view, 0) + 1);
    }

    public synchronized int getViewCount(String videoName) {
        Integer integer;
        while (!viewsMap.containsKey(videoName)) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        integer = viewsMap.get(videoName);
        System.out.println(videoName + " имеет " + integer + " просмотров");
        return integer;
    }


}
