package faang.school.godbless.youtube;

public interface VideoManagerI {
    void addView(String videoId);
    int getViewCount(String videoId);
}
