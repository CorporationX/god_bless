package faang.school.godbless.lambda.insta;

public class Image {
    private String filePath;
    private String description;

    public Image(String filePath, String description) {
        this.filePath = filePath;
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getDescription() {
        return description;
    }
}
