# Миллиончики Uber (Дополнительно)

## Условия задачи
Техлид проверит эту задачу в свободное время (долгое ревью).

### Описание: 
Вы являетесь разработчиком приложения **Uber** и работаете над функцией, которая позволяет пользователям оценить 
стоимость поездки до выбора водителя. Вам необходимо создать систему, которая будет принимать расстояние и время 
поездки, а затем вычислять стоимость на основе различных тарифов.

### Цель: 
Создайте класс `FareCalculator`, который будет использовать `BiFunction` для подсчёта стоимости поездки.

### Требования:
1. Создайте класс `FareCalculator` с методом `calculateFare`;
2. Метод `calculateFare` должен принимать расстояние, время и `BiFunction` для вычисления стоимости поездки;
3. Создайте несколько тарифов, используя лямбда-выражения и интерфейс `BiFunction`;
4. Протестируйте вашу систему, создав несколько примеров поездок с разными тарифами.

### Пример использования:
```java
FareCalculator fareCalculator = new FareCalculator();

// Создание тарифов
BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

// Примеры поездок
double distance = 10.0;
double time = 15.0;

double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
System.out.println("Стоимость поездки на тарифе Premium: " + premiumTripCost);
```

## Почему эта задача полезна?
На примере видно, как легко теперь в **Uber** создать новый тариф прямо на ходу! По сути нужно всего лишь написать новую 
лямбду и передать её в уже существующий метод. Именно в лямбде и будет содержаться логика нового тарифа поездки.