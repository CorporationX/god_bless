package school.faang.lambda.streamapi1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        System.out.printf("\nArray Integers: \n %s", m.initListIntegers());
        System.out.printf("\nArray Strings: \n %s", m.initListString());

        System.out.printf("\n1. Найдено сумму четных чисел в списке: %d",
                m.getSumPositiveNumbersInList(m.initListIntegers()));
        System.out.printf("\n2. Найдено максимальный элемент в списке чисел: %d",
                m.getMaxNumberInList(m.initListIntegers()));
        System.out.printf("\n3. Найдено среднее значение чисел в списке: %f",
                m.getAverageNumberOfElementsInList(m.initListIntegers()));
        System.out.printf("\n4. Найдено количество строк, начинающихся с определённого символа: %d",
                m.getCountNumberRowsFilterSymbol(m.initListString(), 'a'));
        System.out.printf("\n5. Отфильтровано список строк и оставить только те, которые содержат определённую подстроку : %s",
                m.getListStringContainsSubString(m.initListString(), "String"));
        System.out.printf("\n6. Отсортировано список строк по длине : %s",
                m.getSortedListStringByLength(m.initListString()));
        System.out.printf("\n7. Проверено, все ли элементы списка удовлетворяют определённому условию : %b",
                m.isAllItemsAreCondition(m.initListIntegers(), integer -> integer > 0));
        System.out.printf("\n8. Найдено наименьший элемент в списке, который больше заданного числа: %d",
                m.getMinValueForItemsMoreConstant(m.initListIntegers(), 3));
        System.out.printf("\n9. Преобразовано список строк в список их длин: %s",
                m.getTransferListStringLengthToListInteger(m.initListString()));
    }

    public Integer getSumPositiveNumbersInList(List<Integer> inputList) {
        return inputList
                .stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public Integer getMaxNumberInList(List<Integer> inputList) {
        return inputList
                .stream()
                .max(Comparator.comparingInt(o -> o))
                .get();
    }

    public double getAverageNumberOfElementsInList(List<Integer> inputList) {
        return inputList.isEmpty()
                ? 0
                : (double) inputList
                .stream()
                .reduce(0, Integer::sum) / inputList.size();
    }

    public int getCountNumberRowsFilterSymbol(List<String> inputList, char oneSymbolFilter) {
        return (int) inputList
                .stream()
                .filter(string ->
                        !string.isEmpty() && (string.charAt(0) == oneSymbolFilter))
                .count();
    }

    public List<String> getListStringContainsSubString(List<String> inputList, String subString) {
        return inputList
                .stream()
                .filter(s -> s.contains(subString))
                .toList();
    }

    public List<String> getSortedListStringByLength(List<String> inputList) {
        return inputList
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public boolean isAllItemsAreCondition(List<Integer> inputList, Predicate<Integer> predicate) {
        return !inputList.isEmpty() && inputList
                .stream()
                .filter(predicate)
                .count() == inputList.size();
    }

    public int getMinValueForItemsMoreConstant(List<Integer> inputList, int condition) {
        return inputList
                .stream()
                .filter(integer -> integer > condition)
                .min(Comparator.comparingInt(o -> o))
                .get();
    }

    public List<Integer> getTransferListStringLengthToListInteger(List<String> inputList) {
        return inputList
                .stream()
                .map(String::length)
                .toList();
    }

    public List<Integer> initListIntegers() {
        return Arrays.asList(1, 2, 3, 4, 5);
    }

    public List<String> initListString() {
        return Arrays.asList("a1String4444", "b2String22", "a3String1", "b4STRING666666", "c5String55555");
    }
}