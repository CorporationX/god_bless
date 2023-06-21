package sprint3task3;
//новая функция, которая позволяет пользователям применять фильтры к своим фотографиям.
//создать систему, которая позволяет пользователям выбирать различные фильтры и
// применять их к своим фотографиям

import lombok.Data;
///
import java.util.function.Function;

@Data
public class FilterProcessor {
    //будет содержать функции высокого порядка для обработки изображений
    // и применения фильтров

    public Image applyFilter(Image photo, Function<Image, Image> filter) {
        //возвращает новый объект типа Image с применённым фильтром
        //применение сразу скомбинированных двух фильтров??
        //фильтр это лямбда!!!!!
        Image filteredPhoto = ;
        Function<Image, Image> filter =
    }

    public Function<Image, Image> combineFilters(Function<Image, Image>, Function<Image, Image>) {
        //возвращает новую функцию высокого порядка, которая последовательно
        //применяет обе функции
        Function<Image, Image> unitedFilters =
    }


    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

// Применение фильтров (1)
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
    }
}
