package faang.school.godbless.BJS2_21878;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilter(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        return (image) -> filterTwo.apply(filterOne.apply(image));
    }

    public String editImageName(String imageName, String filterName) {
        int indexLastPoint = imageName.lastIndexOf('.');
        String formatName = imageName.substring(indexLastPoint);
        imageName = imageName.substring(0, indexLastPoint);
        return imageName + filterName + formatName;
    }
}

