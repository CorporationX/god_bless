package school.faang.bjs245208;

public class Helpers {
    public static boolean notEmptyParamsCheck(Object... toCheck) {

        boolean allAreEmpty = true;

        for (Object obj : toCheck) {
            if (obj != null) {
                if (!(obj instanceof String) || !((String) obj).isEmpty()) {
                    allAreEmpty = false;
                    break;
                }
            }
        }

        if (allAreEmpty) {
            System.out.println("Cannot operate request as all required fields are not set!");
            return false;
        }

        return true;
    }

    public static <T> boolean notEmptyParamCheck(T toCheck, String name) {
        if (toCheck == null) {
            System.out.printf("Cannot operate request as %s is not set!\n", name);
            return false;
        }

        if (toCheck instanceof String && ((String) toCheck).isEmpty()) {
            System.out.printf("Cannot operate request as %s is not set!\n", name);
            return false;
        }

        return true;
    }
}
