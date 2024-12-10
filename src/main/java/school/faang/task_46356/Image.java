package school.faang.task_46356;

public class Image {
    private String name;
    private String description;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
