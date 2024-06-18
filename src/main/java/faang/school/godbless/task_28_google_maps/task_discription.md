# Google Maps (�������������) lvl2

## ������� ������
������ �������� ��� ������ � ��������� ����� (������ �����).

### ��������: 
�� ��������� ������������� � �������� **Google** � ��������� ��� ����������� **Google Maps**. 
��� �������� ������� ������� ������ ��������������, ������� ���������� ����������� �������������� ���������� **Java**, 
����� ��� `Function`, `Predicate` � `Consumer`, ��� ���������� � ��������� ����������� ������.

### ����: 
�������� ����� `LocationSearchEngine` � �������� ��� ���������� � ��������� ����������� ������, ��������� ����������� 
�������������� ���������� **Java**.

### ����������:
1. �������� ����� `Location` � ������ `name`, `latitude`, � `longitude`;
2. �������� ����� `LocationSearchEngine` � ��������: 
   * `filterLocations`: ��������� ������ �������� ���� `Location` � ������ ���� `Predicate<Location>`, 
���������� ������ �������� ���� `Location`, ��������������� �������, ��������� ����������;
   * `processLocations`: ��������� ������ �������� ���� `Location`, ������ ���� `Consumer<Location>`, � ��������� �������� 
   �������� ��� ������� �������� ������;
   * `calculateDistances`: ��������� ������ �������� ���� `Location`, ������ ���� `Function<Location, Double>`, 
   � ���������� ������ ���������� ����� ������ ��������������� � �������� ������ �� �����, ����������� � ������� ���������� �������.

### ������ �������������:

```java
List<Location> locations = new ArrayList<>(Arrays.asList(
    new Location("Eiffel Tower", 48.8584, 2.2945),
    new Location("Statue of Liberty", 40.6892, -74.0445),
    new Location("Great Wall of China", 40.4319, 116.5704)
));

LocationSearchEngine searchEngine = new LocationSearchEngine();

// ��������� �������������� �� �������
List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);

// ������� �������� ��������������� ��������������
searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.getName()));

// ��������� ���������� �� �������� ����� �� ������� ��������������
double baseLatitude = 37.4220;
double baseLongitude = -122.0841;
List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
    double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
    double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
    return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
});
```

## ������ ��� ������ �������?
���������� �� ����� `filterLocations`. ��, ��� �� ��������� ������ � �������� �������, ��������, ��� �� ����� 
���������� ��� ����� ������ � ������ ������, ��� �� � ����������� �� �����-�� ������ �������� ������������.

��������, � **Google Maps** ���� �������� ���������� �������� �� ��������������. � ����� �����, ���������� 
� �������������� �����, �������� �� ����� ����� ��������� ������� ���������� ����� ��������. ������? ������ ���, 
����� ����������� ����� ������ � ����� ���������� **Google Maps**, ��� ����� ����� �������?
