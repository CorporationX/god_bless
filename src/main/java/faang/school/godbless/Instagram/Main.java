package faang.school.godbless.Instagram;

import java.util.function.Function;

public class Main {
public static void main(String[] args){
    Image originPhoto = new Image("origin.jpg" , "оригинальное фото ");

    FilterProcessor filterProcessor = new FilterProcessor();

    Function<Image , Image> grayscaleFilter = (image) ->
        new Image(image.namePhoto()+"_grayscale","Фильтр: Чёрно-белый ");
    Function<Image , Image> sepiaFilter = (image) ->
    new Image(image.namePhoto()+"_sepia", "Фильтр: сепия ");
    Function<Image, Image> viggneterFilter = (image) ->
            new Image(image.namePhoto() + "_vignette","Фильтр: виньетка");

    Image grayscaleImage = filterProcessor.applyFilter(originPhoto , grayscaleFilter);
    Image sepiaImage = filterProcessor.applyFilter(originPhoto , sepiaFilter);
    Image vignetteImage = filterProcessor.applyFilter(originPhoto , viggneterFilter);

    Function<Image, Image> combinedFilter = filterProcessor.combineFilter(grayscaleFilter, sepiaFilter);
    Image combinedImage = filterProcessor.applyFilter(originPhoto, combinedFilter);

}
}
