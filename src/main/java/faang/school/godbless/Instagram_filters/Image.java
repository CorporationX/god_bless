package faang.school.godbless.Instagram_filters;

public class Image {
    private String fileName;
    private String description;

    public Image(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}