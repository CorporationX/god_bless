package faang.school.godbless.sprint_3.multithreading_synchronization.task_2_photo;

import java.util.List;

public class UpLoaderThread extends Thread {
    private final GooglePhotosAutoUploader googlePhoto;
    private final List<String> pathList;

    public UpLoaderThread(GooglePhotosAutoUploader googlePhoto, String nameThread, List<String> pathList) {
        super(nameThread);
//        System.out.println("name in UpLoaderThread(): " + this.getName());
        this.googlePhoto = googlePhoto;
        this.pathList = pathList;
    }


    @Override
    public void run() {
        while (googlePhoto.isActive()){
            synchronized (pathList){
                if(pathList.isEmpty()){
                    try {
                        pathList.wait(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    for (String p : pathList) {
                        googlePhoto.onNewPhotoAdded(p);
                    }
                    pathList.clear();
                }
            }
        }
        System.out.printf("%s: завершает работу.\n", this.getName());
    }
}
