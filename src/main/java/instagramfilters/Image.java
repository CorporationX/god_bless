package instagramfilters;

public record Image(String name, String description) {

    public Image applyDescription(String newDescription) {
        return new Image(name(), newDescription);
    }
}
