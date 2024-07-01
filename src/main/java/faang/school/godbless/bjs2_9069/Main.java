package faang.school.godbless.bjs2_9069;

import java.util.function.Function;

public class Main {

  private static final Integer DIVISOR = 2;
  private static final String TRIANGLE_AREA_VALUE = "Прощадь треугольника = ";
  private static final String ARITHMETIC_ERROR_MESSAGE = "Деление на ноль";
  private static final Double DEFAULT_HALF_PERIMETER = 0.0;

  public static void main(String[] args) {
    Double area = triangleArea(2, 2, 2);
    System.out.println(TRIANGLE_AREA_VALUE + area);
  }

  private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
    Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

    final double halfPerimeterTriangle = getHalfPerimeterTriangle(a, b, c, sum, div);
    final double intermediateCalculate = getIntermediateCalculate(a, b, c, halfPerimeterTriangle, sub, mul);
    final double result = calculate(halfPerimeterTriangle, intermediateCalculate, mul);
    return sqrt.apply(result);
  }

  /**
   * расчет полупериметра треугольника p = a+b+c/2
   * @param a сторона А
   * @param b стороно В
   * @param c сторона С
   * @param sum Функциональный интерфейс для операции суммирования.
   * @param div Функциональный интерфейс для операции деления.
   * @return полупериметра треугольника
   */
  private static Double getHalfPerimeterTriangle(double a, double b, double c,
      Function<Double, Function<Double, Double>> sum, Function<Double, Function<Double, Double>> div) {
    Double halfPerimeterTriangle = DEFAULT_HALF_PERIMETER;
    final Double result = calculate(a, b, sum);
    try {
      halfPerimeterTriangle = calculate(calculate(result, c, sum), DIVISOR, div);
    } catch (ArithmeticException e) {
      System.out.println(ARITHMETIC_ERROR_MESSAGE);
    }
    return halfPerimeterTriangle;
  }

  /**
   * Расчет значения в зависисмоти от функционального интерфейса.
   * @param firstNumber первое значение
   * @param secondNumber второе значение
   * @param function функциональный интерфейс
   * @return расчитанное значение.
   */
  private static Double calculate(double firstNumber, double secondNumber, Function<Double, Function<Double, Double>> function) {
    return function.apply(firstNumber).apply(secondNumber);
  }

  /**
   * расчет промежуточного результата при расчете прощади. (p - a) * (p - b) * (p - c)
   * @param a сторона А
   * @param b сторона В
   * @param c сторона С
   * @param p полупериметр трекгольника.
   * @param sub Функциональный интерфейс для операции вычитания.
   * @param mul Функциональный интерфейс для операции умножения.
   * @return промежуточный результат расчета прощади треугольника.
   */
  private static Double getIntermediateCalculate(double a, double b, double c, double p,
      Function<Double, Function<Double, Double>> sub, Function<Double, Function<Double, Double>> mul) {
    final double resultSideA = calculate(p, a, sub);
    final double resultSideB = calculate(p, b, sub);
    final double resultSideC = calculate(p, c, sub);
    return calculate(resultSideA, calculate(resultSideB, resultSideC, mul), mul);
  }

}
