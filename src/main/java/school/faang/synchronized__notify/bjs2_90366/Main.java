package school.faang.synchronized__notify.bjs2_90366;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<String> photosPath = new ArrayList<>(List.of(
                "C:\\Users\\Denis\\Pictures\\Screenshots\\Screenshot (12).png",
                "D:\\Projects\\site\\assets\\images\\hero.jpg",
                "C:\\Users\\Denis\\Pictures\\Trips\\Italy\\rome_colosseum.jpg",
                "D:\\Photos\\Pets\\cat_sleeping.jpeg",
                "E:\\Backups\\Photos\\2022\\IMG_4501.heic",
                "C:\\Users\\Denis\\Pictures\\Panorama\\pano-001.jpg",
                "D:\\Photos\\Edited\\Lightroom\\IMG_3321_export.jpg",
                "C:\\Users\\Denis\\Pictures\\Food\\pizza-01.jpg",
                "E:\\GoPro\\GOPR1021.JPG",
                "C:\\Users\\Denis\\Pictures\\Memes\\funny-dog.png"
        ));

        List<String> newPhotosPath = new ArrayList<>(List.of(
                "C:\\Users\\Denis\\Pictures\\2025\\01\\IMG_0001.jpg",
                "C:\\Users\\Denis\\Pictures\\2025\\01\\IMG_0002.jpg",
                "C:\\Users\\Denis\\Pictures\\2025\\02\\Vacation\\DSC_1023.JPG",
                "C:\\Users\\Denis\\Pictures\\2025\\02\\Vacation\\Beach\\IMG_3345.png",
                "C:\\Users\\Denis\\Pictures\\Wallpapers\\city-night-4k.jpg",
                "D:\\Photos\\Family\\2024\\Birthday\\IMG_7780.jpeg",
                "D:\\Photos\\Family\\2023\\NewYear\\NYE_2023_01.jpg",
                "D:\\Photos\\Portfolio\\Landscape\\sunset-lake.jpg",
                "E:\\Camera\\2025-09-12\\_MG_9234.JPG",
                "C:\\Users\\Denis\\OneDrive\\Pictures\\Scans\\scan_0005.png"));

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        List<String> threadName = new ArrayList<>(List.of(
                "consumer",
                "producer"
        ));

        List<Runnable> runnables = new ArrayList<>();

        runnables.add(() -> {
            log.info("Первый поток startAutoUpload запустился");
            googlePhotosAutoUploader.startAutoUpload();

        });
        runnables.add(() -> {
            log.info("Второй поток onNewPhotoAdded запустился");
            photosPath.forEach(googlePhotosAutoUploader::onNewPhotoAdded);
            newPhotosPath.forEach(googlePhotosAutoUploader::onNewPhotoAdded);
        });

        IntStream.range(0, threadName.size())
                .mapToObj(i -> new Thread(runnables.get(i),
                                          threadName.get(i)))
                .forEach(Thread::start);
    }
}