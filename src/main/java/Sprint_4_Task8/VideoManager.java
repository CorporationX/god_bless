package Sprint_4_Task8;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

@Data
public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String video) {
        viewsMap.put(video, viewsMap.getOrDefault(video, 0) + 1);
        this.notifyAll();
    }

    @SneakyThrows
    public synchronized int getViewCount(String video) {
        int sum = 0;
        while (!viewsMap.containsKey(video)) {
            this.wait(1000);
        }

        sum = viewsMap.get(video);
        System.out.println(video + " c " + sum + " просмотров");
        return sum;
    }
}
