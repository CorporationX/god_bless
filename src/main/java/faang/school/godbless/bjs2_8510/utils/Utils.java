package faang.school.godbless.bjs2_8510.utils;

public final class Utils {

  public static final Integer PERMITTED_LOAD_PERCENT = 90;
  public static final Integer MIDDLE_LOAD_PERCENT = 50;
  public static final Integer LOW_LOAD_PERCENT = 30;
  public static final Integer SHARE_EXPRESSION = 100;
  public static final Double ENERGY_CONSUMPTION_PER_UNIT_CAPACITY = 1.5;
  public static final Integer MIN_LOAD_SERVER = 1;
  private static final int SUMMAND = 2;

  private Utils() {}

  public static Double getLoadFactor(Double obtained, Double total, Integer shareExpression) {
    return (obtained * shareExpression) / total;
  }

  public static Double getArithmeticAverage(Double... numbers) {
    Double result = 0.0;
    for (Double number : numbers) {
      result += number;
    }
    return result / SUMMAND ;
  }

}
