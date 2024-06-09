package unittesting;

public class NumberConverter {

    public String convertNumber(String number, int sourceBase, int targetBase) {
        if (isInvalidBase(sourceBase) && isInvalidBase(targetBase)) {
            throw new IllegalArgumentException("Invalid base");
        }

        try {
            int result = Integer.parseInt(number, sourceBase);
            return Integer.toString(result, targetBase).toUpperCase();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unable convert");
        }
    }

    private boolean isInvalidBase(int base) {
        return base < 2 || base > 16;
    }
}
