package src.main.java.faang.school.godbless;

public class Image {
    private String name;
    private String description;
    Image(String filename, String description){
        this.name = filename;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
