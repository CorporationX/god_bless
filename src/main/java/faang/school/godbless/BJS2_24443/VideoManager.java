package faang.school.godbless.BJS2_24443;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class VideoManager {
    private final Map<String, AtomicInteger> viewMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewMap.computeIfAbsent(videoId, k -> new AtomicInteger(0)).incrementAndGet();
        System.out.println("К " + videoId + " добавился 1 просмотр");
    }

    public int getViewCount(String videoId) {
        return viewMap.getOrDefault(videoId, new AtomicInteger(0)).get();
    }

    public void printViewsMap() {
        System.out.println("\nТекущее содержимое карты просмотров:");
        viewMap.forEach((videoId, count) ->
                System.out.println("ID: " + videoId + " - Количество просмотров: " + count.get()));
    }
}
