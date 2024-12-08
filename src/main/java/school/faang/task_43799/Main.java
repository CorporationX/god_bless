package school.faang.task_43799;

import java.util.Arrays;

import static school.faang.task_43799.Example.reversArray;

public class Main {
    public static void main(String[] args) {
        try {
            int[] newArray = {1, 2, 3, 4, 5};
            System.out.println(Arrays.toString(reversArray(newArray)));
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to reverse array: " + e.getMessage());
        }

        try {
            int[] newArray = {};
            System.out.println(Arrays.toString(reversArray(newArray)));
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to reverse array: " + e.getMessage());
        }

        try {
            int[] newArray = null;
            System.out.println(Arrays.toString(reversArray(newArray)));
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to reverse array: " + e.getMessage());
        }
    }
}
