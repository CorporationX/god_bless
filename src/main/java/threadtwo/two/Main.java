package threadtwo.two;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(() -> googlePhoto.startAutoUpload());
        Thread addPhotoThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String photoPath = "path/photo" + i + ".jpg";
                    googlePhoto.onNewPhotoAdded(photoPath);
                    System.out.println("Новое фото добавлено в список" +
                            " на загрузку: " + photoPath);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Добавление новых фото было прервано.");
            }
        });

        uploadThread.start();
        addPhotoThread.start();

    }
}
