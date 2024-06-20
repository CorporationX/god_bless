package faang.school.godbless.google_photo;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Stream<String> photosToAdd = getPhotoStream();

        Thread photoAdderThread = new Thread(() -> photosToAdd.forEach(autoUploader::onNewPhotoAdded));
        Thread photeUploaderThread = new Thread(autoUploader::startAutoUpload);

        photoAdderThread.start();
        photeUploaderThread.start();
    }

    private static Stream<String> getPhotoStream() {
        return Stream.of("Photo1", "Photo2", "Photo3", "Photo4", "Photo5",
                "Photo6", "Photo7", "Photo8", "Photo9", "Photo10",
                "Photo11", "Photo12", "Photo13", "Photo14", "Photo15",
                "Photo16", "Photo17", "Photo18", "Photo19", "Photo20",
                "Photo21", "Photo22", "Photo23", "Photo24", "Photo25",
                "Photo26", "Photo37", "Photo28", "Photo29", "Photo30",
                "Photo31", "Photo32", "Photo33", "Photo34", "Photo35",
                "Photo36", "Photo37", "Photo38", "Photo39", "Photo40",
                "Photo41", "Photo42", "Photo43", "Photo44", "Photo45",
                "Photo46", "Photo47", "Photo48", "Photo49", "Photo50",
                "Photo51", "Photo52", "Photo53", "Photo54", "Photo55",
                "Photo56", "Photo57", "Photo58", "Photo59", "Photo60",
                "Photo61", "Photo62", "Photo63", "Photo64", "Photo65");
    }
}
