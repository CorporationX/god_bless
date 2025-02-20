package school.faang.instagram;

import lombok.Getter;

import java.util.function.Function;

@Getter
public class FilterProcessor {
    private Image image;
    private Function<Image, Image> filter;
    private Function<Image, Image> grayscaleFilter;
    private Function<Image, Image> sepiaFilter;

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        this.image = image;
        this.filter = filter;

        return filter.apply(image);
    }

    protected Function<Image, Image>
                    combineFilters(Function<Image, Image> grayscaleFilter,
                    Function<Image, Image> sepiaFilter) {

        this.grayscaleFilter = grayscaleFilter;
        this.sepiaFilter = sepiaFilter;

        return grayscaleFilter.andThen(sepiaFilter);
    }

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image ->
                new Image(Image.getName(), Image.getDescription() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = image ->
                new Image(Image.getName(), Image.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(Image.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(Image.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(Image.getDescription());
    }
}