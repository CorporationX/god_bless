package faang.school.godbless.instagram_filters;

public class Image {
    private String imgName;
    private String description;

    Image (String imgName, String description) {
        this.imgName = imgName;
        this.description = description;
    }

    public String getImgName() {
        return imgName;
    }
    public String getDescription() {
        return description;
    }
}
