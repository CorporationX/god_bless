package faang.school.godbless;

public enum Jobs {
    GOOGLE, UBER, AMAZON;

    public static boolean contains(Jobs jobs) {
        try {
            Jobs.valueOf(String.valueOf(jobs));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
