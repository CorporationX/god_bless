package faang.school.godbless.BJS2_10394;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    //����� ����� ������ ����� � ������. �� ���� �������� ������ �����, �� ������ ������ �������� int;
    public static int findEvenNumber(List<Integer> list) {
        return list.stream().filter(num -> num % 2 == 0).reduce((first, second) -> first + second).get();
    }

    //����� ������������ ������� � ������ �����;
    public static int findMaxNumber(List<Integer> list) {
        return list.stream().max((first, second) -> first - second).get();
    }

    //����� ������� �������� ����� � ������;
    public static int findAverageNumber(List<Integer> list) {
        return list.stream()
                .reduce((first, second) -> (first + second)).get() / list.size();
    }

    //����� ���������� �����, ������������ � ������������ ������� � ������ �����;
    public static int findString(List<String> list, Character symbol) {
        return (int) list.stream().filter((line) -> symbol.equals(line.charAt(0))).count();
    }

    //������������� ������ ����� � �������� ������ ��, ������� �������� ������������ ���������;
    public static List<String> findSubString(List<String> list, String substring) {
        return list.stream().filter((line) -> line.startsWith(substring)).toList();
    }

    //������������� ������ ����� �� �����;
    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted((first, second) -> first.length() - second.length()).toList();
    }

    //���������, ��� �� �������� ������ ������������� ������������ �������;
    public static boolean filterList(List<String> list, Predicate<String> predicate) {
        return list.stream().filter(line -> predicate.test(line)).count() > 0;
    }

    //����� ���������� ������� � ������, ������� ������ ��������� �����;
    public static int findMinNumber(List<Integer> list, int num) {
        return list.stream().sorted((min, max) -> max - min).findFirst().get();
    }

    //������������� ������ ����� � ������ �� ����.
    public static List<Integer> convertToListOfLength(List<String> list) {
        return list.stream().map(first -> first.length()).toList();
    }
}
