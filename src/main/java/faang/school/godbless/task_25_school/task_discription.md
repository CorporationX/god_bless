# Вспомним школу
👩‍💻 🧠🧠

## Условия задачи

1. Дан код:

```java
// Даны три стороны треугольника, вычислить его площадь
Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
    Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
}
```

2. Используя данные лямбды, вычислить площадь треугольника

3. Можно пользоваться только данными лямбдами. Нельзя использовать арифметические 
операторы + - * / и пакет Math, и др.

4. Добавить валидацию входных параметров.

