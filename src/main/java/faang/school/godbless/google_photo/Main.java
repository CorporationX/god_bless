package faang.school.godbless.google_photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread threadUpload = new Thread(() -> uploader.startAutoUpload());
        Thread threadWatch = new Thread(() -> {
            while (true) {
                synchronized (uploader.lock) {
                    if (uploader.photosToUpload.isEmpty()) {
                        try {
                            uploader.lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (String photoPath : uploader.photosToUpload) {
                        System.out.println("Watching photos " + photoPath);

                    }
                }
            }
        });
        threadUpload.start();
        threadWatch.start();

        uploader.oneNewPhotoAdded("photo-1.png");
        uploader.oneNewPhotoAdded("photo-2.png");
        uploader.oneNewPhotoAdded("photo-3.png");
        uploader.oneNewPhotoAdded("photo-4.png");
    }
}
