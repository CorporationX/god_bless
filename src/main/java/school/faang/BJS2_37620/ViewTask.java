package school.faang.BJS2_37620;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ViewTask implements Runnable {
    private final VideoManager videoManager;
    private final String videoId;

    @Override
    public void run() {
        videoManager.addView(videoId);
        System.out.println("Просмотры для " + videoId + ": " + videoManager.getViewCount(videoId));
    }
}
