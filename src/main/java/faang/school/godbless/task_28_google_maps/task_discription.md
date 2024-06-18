# Google Maps (Дополнительно) lvl2

## Условия задачи
Техлид проверит эту задачу в свободное время (долгое ревью).

### Описание: 
Вы являетесь разработчиком в компании **Google** и работаете над приложением **Google Maps**. 
Вам поручено создать систему поиска местоположений, которая использует стандартные функциональные интерфейсы **Java**, 
такие как `Function`, `Predicate` и `Consumer`, для фильтрации и обработки результатов поиска.

### Цель: 
Создайте класс `LocationSearchEngine` с методами для фильтрации и обработки результатов поиска, используя стандартные 
функциональные интерфейсы **Java**.

### Требования:
1. Создайте класс `Location` с полями `name`, `latitude`, и `longitude`;
2. Создайте класс `LocationSearchEngine` с методами: 
   * `filterLocations`: принимает список объектов типа `Location` и объект типа `Predicate<Location>`, 
возвращает список объектов типа `Location`, удовлетворяющих условию, заданному предикатом;
   * `processLocations`: принимает список объектов типа `Location`, объект типа `Consumer<Location>`, и выполняет заданное 
   действие для каждого элемента списка;
   * `calculateDistances`: принимает список объектов типа `Location`, объект типа `Function<Location, Double>`, 
   и возвращает список расстояний между каждым местоположением и заданной точкой на карте, вычисленных с помощью переданной функции.

### Пример использования:

```java
List<Location> locations = new ArrayList<>(Arrays.asList(
    new Location("Eiffel Tower", 48.8584, 2.2945),
    new Location("Statue of Liberty", 40.6892, -74.0445),
    new Location("Great Wall of China", 40.4319, 116.5704)
));

LocationSearchEngine searchEngine = new LocationSearchEngine();

// Фильтруем местоположения по долготе
List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);

// Выводим названия отфильтрованных местоположений
searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.getName()));

// Вычисляем расстояния от заданной точки до каждого местоположения
double baseLatitude = 37.4220;
double baseLongitude = -122.0841;
List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
    double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
    double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
    return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
});
```

## Почему эта задача полезна?
Посмотрите на метод `filterLocations`. То, что он принимает лямбду в качестве условия, означает, что мы можем 
передавать ему любую лямбду в разных местах, или же в зависимости от каких-то других действий пользователя.

Например, в **Google Maps** есть огромное количество фильтров по местоположению. И такой метод, написанный 
с использованием лямбд, позволил бы очень легко создавать большое количество новых фильтров. Почему? Потому что, 
чтобы реализовать новый фильтр в целом приложении **Google Maps**, что тогда нужно сделать?
