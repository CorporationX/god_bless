import lombok.Getter;

@Getter
public class Image {
    private String name;
    private String description;

    public Image(String name, String description){
        this.name=name;
        this.description=description;
    }
}
