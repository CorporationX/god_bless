package faang.school.godbless.instagram_filters;

public class FilterProcessor {

    Filters<Image, Image> GRAYSCALEFILTER = image -> new Image(image.getName() + "_grayscale"
            , "Фильтр: черно-белый");

    Filters<Image, Image> SEPIAFILTER = image -> new Image(image.getName() + "_sepia"
            , "Фильтр: сепия");

    Filters<Image, Image> VIGNETTEFILTER = image -> new Image(image.getName() + "_vignette"
            , "Фильтр: виньетка");

    public Image applyFilter(Image image, Filters<Image, Image> filter) {
        return filter.getFilter(image);
    }

    public Filters<Image, Image> combineFilters(Filters<Image, Image> filter1, Filters<Image, Image> filter2) {
        return image -> filter2.getFilter(filter1.getFilter(image));
    }
}
