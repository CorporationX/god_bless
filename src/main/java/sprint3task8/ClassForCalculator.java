package sprint3task8;
import java.util.List;

public class ClassForCalculator {

    public static int calculate
            (List<Integer> nums, Calculator calculator)
            throws IllegalArgumentException{
        for (Integer num: nums) {
            calculator.calculate(num);
            //два аргумента в интерфейсе ж
            return num;
        }
    }

    public static int product(List<Integer> nums){
        //Произведение чисел во всем списке

    }
    public static int sum(List<Integer> nums) {
        //Сумма чисел всего списка
    }
}
