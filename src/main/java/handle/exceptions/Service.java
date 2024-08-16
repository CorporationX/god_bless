package handle.exceptions;

import java.util.NoSuchElementException;

public class Service {
    int call(int param) {
        if (param > 500) {
            throw new IllegalArgumentException("Illegal argument param > 200");
        } else if (param > 300) {
            throw new NoSuchElementException("Aboba");
        } else if (param > 100) {
            throw new ArithmeticException("Aboba boba");
        } else {
            return param * 2;
        }
    }
}
