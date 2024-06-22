package faang.school.godbless.YouTube;

public class RunnableForYouTube implements Runnable {
    private VideoManager videoManager;
    private String numberForApplyFromOut;

    public RunnableForYouTube(VideoManager videoManager, String numberForApplyFromOut) {
        if(videoManager == null) {
            throw new IllegalArgumentException(
                    "RunnableForYouTube class in constructor apply object VideoManager is null");
        }
        if(numberForApplyFromOut == null) {
            throw new IllegalArgumentException(
                    "RunnableForYouTube class in constructor apply String is null");
        }
        this.videoManager = videoManager;
        this.numberForApplyFromOut = numberForApplyFromOut;
    }

    @Override
    public void run() {
        videoManager.addView(numberForApplyFromOut);
        System.out.println(videoManager.getViewCount(numberForApplyFromOut));
    }
}
