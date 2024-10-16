package school.faang.bjs2_34911;

import school.faang.bjs2_34911.model.Image;
import school.faang.bjs2_34911.model.Filter;
import school.faang.bjs2_34911.service.FilterProcessor;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Image originalPhoto = new Image("Original.jpg", "Original Photo");
        Image imageBlurFilter = filterProcessor.applyFilter(originalPhoto, Filter.BLUR);
        Image imageBlurContrastFilter = filterProcessor.applyFilter(imageBlurFilter, Filter.CONTRAST);
        System.out.println(imageBlurContrastFilter);

        Function<Image, Image> contrastBrightnessFilter = filterProcessor.combineFilters(Filter.CONTRAST, Filter.BRIGHTNESS);
        Image imageContrastBrightnessFilter = filterProcessor.applyFilter(originalPhoto, contrastBrightnessFilter);
        System.out.println(imageContrastBrightnessFilter);
    }
}
