package faang.school.godbless.Instagram_Filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> nigthFilter = (image) -> new Image(image.getFileName() + "_night", image.getFileDescription() + " +фильтр для тёмных фото");
        Function<Image, Image> sharpnessFilter = (image) -> new Image(image.getFileName() + "_sharpness", image.getFileDescription() + " +резкость");

        System.out.println(filterProcessor.applyFilter(new Image("NigthPicture", "dark picture"), nigthFilter));

        Function<Image, Image> combineFilterNigthSharpness = filterProcessor.combineFilters(nigthFilter, sharpnessFilter);
        System.out.println(filterProcessor.applyFilter(new Image("NigthFuzzyPicture", "dark and fuzzy picture"), combineFilterNigthSharpness));

    }
}
