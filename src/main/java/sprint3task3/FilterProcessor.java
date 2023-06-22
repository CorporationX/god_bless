package sprint3task3;
//новая функция, которая позволяет пользователям применять фильтры к своим фотографиям.
//создать систему, которая позволяет пользователям выбирать различные фильтры и
//применять их к своим фотографиям.
import lombok.Data;
import java.util.function.Function;

@Data
public class FilterProcessor {
    //будет содержать функции высокого порядка для обработки изображений
    //и применения фильтров.
    public Image applyFilter(Image photo, Function<Image, Image> filter) {
        //возвращает новый объект типа Image с применённым фильтром
        //фильтр - для лямбды!
        Image filteredPhoto = filter.apply(photo);
        return filteredPhoto;
    }
    public Function<Image, Image> combineFilters
            (Function<Image, Image> filter1, Function<Image, Image> filter2) {
        //возвращает новую функцию высокого порядка, которая последовательно
        //применяет обе функции
        //делаем новую лямбду(фильтр), которая состоит из двух лямбд
        Function<Image, Image> unitedFilter = filter1.andThen(filter2);
        return unitedFilter;
    }

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

// Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
    }
}
