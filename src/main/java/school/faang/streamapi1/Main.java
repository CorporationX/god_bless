package school.faang.streamapi1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("сумма четных чисел: " +
                Operations.sumEvenNumbers(randomListInteger(random.nextInt(20))));

        System.out.println("максимальный элемент в списке: " +
                Operations.maxElement(randomListInteger(random.nextInt(20))));
        System.out.println("максимальный элемент в списке: " +
                Operations.maxElement(new ArrayList<>()));

        System.out.println("среднее значение чисел: " +
                Operations.averageValueNumbers(randomListInteger(random.nextInt(20))));

        System.out.println("количество строк, начинающихся с определённого символа: " +
                Operations.numbersLinesStartingCharacter(randomListString("zxcvbnmlkjhgfdsaqwertyuiop",
                        random.nextInt(20), random.nextInt(20)), 'f'));

        System.out.println("Отфильтровать список строк и оставить только те, которые содержат определённую подстроку: "
                + Operations.filterListRows(randomListString("zxcvbnmlkjhgfdsaqwertyuiop",
                random.nextInt(20), random.nextInt(20)), "hello"));

        System.out.println("Отсортировать список строк по длине: " +
                Operations.sortLineStringsByLength(randomListString("zxcvbnmlkjhgfdsaqwertyuiop",
                        random.nextInt(20), random.nextInt(20))));

        System.out.println("все ли элементы списка удовлетворяют определённому условию: " +
                Operations.isListCondition(randomListInteger(random.nextInt(20)), num -> num > 0));

        System.out.println("наименьший элемент в списке, который больше заданного числа: " +
                Operations.smallestItemThatLargerSpecified(randomListInteger(random.nextInt(20)),
                        random.nextInt(50)));

        System.out.println("список строк в список их длин: " +
                Operations.listStringsToTheirLengths(List.of("str", "qwerty", "a", "sdfgzxcv")));
    }

    public static List<Integer> randomListInteger(int count) {
        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomList.add(random.nextInt(200) - 100);
        }
        return randomList;
    }

    public static List<String> randomListString(String characters, int length, int count) {
        Random random = new Random();
        List<String> listString = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            char[] text = new char[length];
            for (int j = 0; j < length; j++) {
                text[j] = characters.charAt(random.nextInt(characters.length()));
            }
            listString.add(new String(text));
        }
        return listString;
    }
}
