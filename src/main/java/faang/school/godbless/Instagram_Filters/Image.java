package faang.school.godbless.Instagram_Filters;

public class Image {
    private final String fileName;
    private final String fileDescription;

    public Image(String fileName, String fileDescription) {
        this.fileName = fileName;
        this.fileDescription = fileDescription;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    @Override
    public String toString() {
        return "Image{" +
                "fileName='" + fileName + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                '}';
    }
}
