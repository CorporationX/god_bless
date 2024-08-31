package faang.school.godbless.dolbahlop.multithreading.synchronization;

public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotoAutoUpLouder googlePhotoAutoUpLouder = new GooglePhotoAutoUpLouder();
        Thread startAutoUpload = new Thread(googlePhotoAutoUpLouder::startAutoUpload);
        Thread oneNewPhotoAdded = new Thread(() -> {
            try {
                googlePhotoAutoUpLouder.oneNewPhotoAdded("photo1.png");
                Thread.sleep(1000);
                googlePhotoAutoUpLouder.oneNewPhotoAdded("photo2.png");
                Thread.sleep(2000);
                googlePhotoAutoUpLouder.oneNewPhotoAdded("photo3.png");
                Thread.sleep(500);
                googlePhotoAutoUpLouder.oneNewPhotoAdded("photo4.png");
                Thread.sleep(100);
                googlePhotoAutoUpLouder.oneNewPhotoAdded("photo5.png");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        startAutoUpload.start();
        oneNewPhotoAdded.start();
    }
}
