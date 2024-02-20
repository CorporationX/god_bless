package faang.school.godbless.instagramFilters;

public class Image {
    private final String nameFile;
    private final String descriptionFile;

    public Image(String nameFile, String descriptionFile) {
        this.nameFile = nameFile;
        this.descriptionFile = descriptionFile;
    }

    public String getName() {
        return nameFile;
    }

    public String getDescription() {
        return descriptionFile;
    }
}
