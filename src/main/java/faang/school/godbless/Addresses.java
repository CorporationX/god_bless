package faang.school.godbless;

public enum Addresses {
    LONDON, NEWYORK, AMSTERDAM;

    public static boolean contains(Addresses addresses) {
        try {
            Addresses.valueOf(String.valueOf(addresses));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
