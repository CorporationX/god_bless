import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    //    Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    static public int sum(List<Integer> nums) {
        return nums.stream().reduce(0, Integer::sum);
    }

    //    Найти максимальный элемент в списке чисел;
    static public int max(List<Integer> nums) {
        if(nums.isEmpty()){
            throw new IllegalArgumentException();
        }
       return nums.stream().mapToInt(Integer::intValue).max().orElseThrow();
    }


//    Найти среднее значение чисел в списке;

//    Найти количество строк, начинающихся с определённого символа в списке строк;

//    Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;

//    Отсортировать список строк по длине;

//    Проверить, все ли элементы списка удовлетворяют определённому условию;

//    Найти наименьший элемент в списке, который больше заданного числа;

//    Преобразовать список строк в список их длин.
}
