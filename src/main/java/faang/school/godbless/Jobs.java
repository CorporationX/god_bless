package faang.school.godbless;

public enum Jobs {
    GOOGLE("Google"), UBER("Uber"), AMAZON("Amazon");

    private final String name;

    Jobs(String str) {
        name = str;
    }

    public static boolean contains(String name) {
        for (Jobs job : Jobs.values()) {
            if (job.name.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static Jobs fromString(String name) {
        for (Jobs job : Jobs.values()) {
            if (job.name.equalsIgnoreCase(name)) {
                return job;
            }
        }
        return null;
    }
}
