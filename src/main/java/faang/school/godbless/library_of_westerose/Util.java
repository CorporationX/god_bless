package faang.school.godbless.library_of_westerose;

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

    public static int getIntegerInput(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static int randomNumberShelf() {
        int randomNumber = (int) (Math.random() * 9999);

        if (randomNumber <= 1000) {
            randomNumber = randomNumber + 1000;
        }
        return randomNumber;
    }
}
