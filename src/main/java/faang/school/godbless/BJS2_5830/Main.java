package faang.school.godbless.BJS2_5830;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // почему когда я собираю этот лист непосредственно при создании класса при помощи List.of() у меня сыпется куча ошибок?
        // я чисто предполагаю что потоки начинают работать с листом во время его сборки и так получается что сыпятся ошибки, или нет?😇
        List<String> list1 = new ArrayList<>();
        list1.add("forest.jpg");
        list1.add("dog.jpeg");
        list1.add("dolphin.bmp");
        list1.add("car.tif");
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader(list1);

        Thread viewer = new Thread(autoUploader::startAutoUpload);
        List<String> list = new ArrayList<>();
        list.add("cat.jpg");
        list.add("mom.jpeg");
        list.add("brother.bmp");
        list.add("home.tif");
        Thread uploader = new Thread(() -> autoUploader.onNewPhotoAdded(list));

        viewer.start();
        Thread.sleep(5000);
        uploader.start();
    }
}
