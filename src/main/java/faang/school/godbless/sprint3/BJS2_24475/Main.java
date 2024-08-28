package faang.school.godbless.sprint3.BJS2_24475;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread uploadingThread = new Thread(googlePhoto::startAutoUpload);
        Thread viewingThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    googlePhoto.onNewPhotoAdded("d:/photos/more2005/photo" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        uploadingThread.start();
        viewingThread.start();

        try {
            viewingThread.join();
            uploadingThread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Program ended");
    }
}
