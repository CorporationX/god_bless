package school.faang.task_48894;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader google = new GooglePhotosAutoUploader();
        Thread thread1 = new Thread(() -> {
            google.onNewPhotoAdded("Изображение 1");
            google.onNewPhotoAdded("Изображение 2");
            google.onNewPhotoAdded("Изображение 3");
            google.onNewPhotoAdded("Изображение 4");
            google.onNewPhotoAdded("Изображение 5");
            google.onNewPhotoAdded("Изображение 6");
            google.onNewPhotoAdded("Изображение 7");
            google.onNewPhotoAdded("Изображение 8");
        });
        Thread thread2 = new Thread(() -> {
            try {
                google.startAutoUpload();
            } catch (InterruptedException e) {
                System.out.println(e + "Ошибка загрузки фото");
            }
        });

        thread1.start();
        thread2.start();
    }
}