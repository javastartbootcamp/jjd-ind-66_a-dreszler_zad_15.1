package pl.javastart.task.error;

public final class ErrorUtils {
    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    private ErrorUtils() {
    }

    public static void printError(String errorMessage) {
        System.out.println(RED + errorMessage + RESET);
    }
}
