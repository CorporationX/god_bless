package src.main.java.faang.school.godbless;

public class Image {
    private final String name;
    private final String description;
    Image(String filename, String description){
        this.name = filename;
        this.description = description;
    }
    public String getName() {
        return name;
    }
}
