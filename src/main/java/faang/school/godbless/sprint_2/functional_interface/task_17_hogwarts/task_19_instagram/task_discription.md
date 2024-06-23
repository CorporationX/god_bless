# Фильтры Instagram
👩‍💻 🧠

## Условия задачи
### Описание: 
Вы являетесь разработчиком приложения **Instagram** и работаете над новой функцией, которая позволяет пользователям 
применять фильтры к своим фотографиям. Вам необходимо создать систему, которая позволяет пользователям выбирать 
различные фильтры и применять их к своим фотографиям. Для реализации этой системы вы должны использовать функции 
высокого порядка в **Java**.

### Цель: 
Создайте класс `FilterProcessor`, который будет содержать функции высокого порядка для обработки изображений и 
применения фильтров.

## Требования:

1. Создайте класс `Image`, который будет представлять фотографию пользователя. В рамках данной задачи, класс 
`Image` может иметь только имя файла и описание;
2. Создайте класс `FilterProcessor` с методами: 
   * `applyFilter`: принимает объект типа `Image` и функцию высокого порядка для применения фильтра 
   (например, `Function<Image, Image>`), возвращает новый объект типа `Image` с применённым 
   фильтром;
   * `combineFilters`: принимает две функции высокого порядка и возвращает новую функцию высокого порядка, 
   которая последовательно применяет обе функции.
3. Создайте несколько фильтров, используя лямбда-выражения и стандартные функциональные интерфейсы **Java**.

### Пример использования:

```dtd
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
```


### Почему эта задача полезна?
С помощью функций высокого порядка, можно передавать в методы действия в виде лямбда-выражений, что позволяет 
писать новые фильтры для такой системы, как **Instagram**, гораздо быстрее. Разработчику просто нужно создать 
дополнительную лямбду — она и будет новым фильтром. А больше ничего менять не требуется!