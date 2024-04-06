package faang.school.godbless.gameOfTheTrones;

import java.util.Scanner;

public class Util {

    public static String readLine() {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        while (line.isEmpty()) {
            line = input.nextLine();
        }
        return line;
    }
    public static int getIntegerInput() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();}
}
