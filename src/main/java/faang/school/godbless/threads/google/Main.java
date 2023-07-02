package faang.school.godbless.threads.google;

public class Main {
    public static void main(String[] args) {
        GooglePhoto googlePhoto = new GooglePhoto();

        Thread consumer = new Thread(() -> {
            googlePhoto.startAutoUpload();
        });

        Thread producer = new Thread(() -> {
           googlePhoto.onNewPhotoAdded("Family");
           googlePhoto.onNewPhotoAdded("Car");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            googlePhoto.onNewPhotoAdded("Shit");
        });

        consumer.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        producer.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        consumer.interrupt();
    }
}
