package school.faang.youtubeviewcounter;

@FunctionalInterface
public interface Listener {
    void onViewCountChanged(String videoId, int newCount);
}
