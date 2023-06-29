package faang.school.godbless.Sprint3.Task_3_Instagram;

public class Image {
    private String fileName;
    private String description;

    public String getFileName() {
        return fileName;
    }

    public String getDescription() {
        return description;
    }

    public Image(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
    }
}
