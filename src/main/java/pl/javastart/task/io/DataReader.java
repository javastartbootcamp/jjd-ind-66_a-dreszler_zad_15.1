package pl.javastart.task.io;

import java.util.InputMismatchException;
import java.util.Scanner;

import static pl.javastart.task.constants.SortingConstants.*;
import static pl.javastart.task.error.ErrorUtils.*;

public class DataReader {
    private static final int INVALID_INPUT = -1;

    public static int readSortingOrder(Scanner scanner) {
        int sortingOrder = INVALID_INPUT;
        boolean sortingOrderValid = false;
        while (!sortingOrderValid) {
            System.out.printf("Sortować rosnąco czy malejąco? (%d - rosnąco, %d - malejąco)\n", ASCENDING_ORDER,
                    DESCENDING_ORDER);
            try {
                sortingOrder = scanner.nextInt();
                switch (sortingOrder) {
                    case ASCENDING_ORDER, DESCENDING_ORDER -> sortingOrderValid = true;
                    default -> printError("Podano nieprawidłową opcję. Spróbuj ponownie.");
                }
            } catch (InputMismatchException e) {
                printError("Jako porządek sortowania wprowadzić można tylko liczbę całkowitą. Spróbuj ponownie.");
            }
            scanner.nextLine();
        }

        return sortingOrder;
    }

    public static int readParameter(Scanner scanner) {
        int parameter = INVALID_INPUT;
        boolean parameterValid = false;
        while (!parameterValid) {
            System.out.printf("Po jakim parametrze posortować? (%d - imię, %d - nazwisko, %d - wynik)\n", FIRST_NAME,
                    LAST_NAME, SCORE);
            try {
                parameter = scanner.nextInt();
                switch (parameter) {
                    case FIRST_NAME, LAST_NAME, SCORE -> parameterValid = true;
                    default -> printError("Podano nieprawidłową opcję. Spróbuj ponownie.");
                }
            } catch (InputMismatchException e) {
                printError("Jako parametr wprowadzić można tylko liczbę całkowitą. Spróbuj ponownie.");
            }
            scanner.nextLine();
        }

        return parameter;
    }
}
