package school.faang.task_46325;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor processor = new FilterProcessor();

        Function<Image, Image> blackAndWhiteFilter = img -> {
            img.setDescription(img.getDescription() + " + black-and-white filter");
            return img;
        };
        Function<Image, Image> sepiaFilter = img -> {
            img.setDescription(img.getDescription() + " + sepia filter");
            return img;
        };
        Function<Image, Image> vignetteFilter = img -> {
            img.setDescription(img.getDescription() + " + vignette filter");
            return img;
        };
        try {
            Image bwImage = processor.applyFilter(new Image("photo", "Original image"),
                    blackAndWhiteFilter);
            System.out.println(bwImage.getDescription());

            Function<Image, Image> combinedFilter = processor.combineFilters(blackAndWhiteFilter, sepiaFilter);
            Image combinedImage = processor.applyFilter(new Image("secondPhoto", "Original secondImage"),
                    combinedFilter);
            System.out.println(combinedImage.getDescription());

            combinedFilter = processor.combineFilters(combinedFilter, vignetteFilter);
            Image finalImage = processor.applyFilter(new Image("thirdPhoto", "Original thirdImage"), combinedFilter);
            System.out.println(finalImage.getDescription());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
