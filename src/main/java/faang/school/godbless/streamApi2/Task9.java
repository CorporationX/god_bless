package faang.school.godbless.streamApi2;

import java.util.ArrayList;

/**
 * Доп задание: Написать метод, который найдёт все подстроки в строке, которые являются палиндромами.
 * На вход получаем строку, а вернуть должны список строк
 */
public class Task9 {
    public static void main(String[] args) {
        String str = "google";
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i <= str.length(); i++) {
            strings.add(str.substring(0, i));
        }

        System.out.println(strings.stream().filter(s -> s.contentEquals(new StringBuilder(s).reverse())).toList());
    }
}
