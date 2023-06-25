package faang.school.godbless;

public class Image {

    private String filename;
    private String description;

    public Image(String filename, String description){
        this.filename = filename;
        this.description = description;
    }

    public String getName() {
        return filename;
    }

    public String getDescription() {
        return description;
    }
}
