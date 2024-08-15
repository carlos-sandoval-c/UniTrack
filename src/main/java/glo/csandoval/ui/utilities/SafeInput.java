package glo.csandoval.ui.utilities;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SafeInput {
    public static String getStringFromSource(InputStream scannerSource) {
        try {
            Scanner sc = new Scanner(scannerSource);
            return sc.nextLine();
        } catch (NoSuchElementException error) {
            return null;
        }
    }

    public static Double getDoubleFromSource(InputStream scannerSource) {
        try {
            Scanner sc = new Scanner(scannerSource);
            return sc.nextDouble();
        } catch (NoSuchElementException error) {
            // InputMismatchException \include NoSuchElementException
            return null;
        }
    }

    public static Integer getIntegerFromInput(InputStream scannerSource) {
        try {
            Scanner sc = new Scanner(scannerSource);
            return sc.nextInt();
        } catch (NoSuchElementException error) {
            // InputMismatchException \include NoSuchElementException
            return null;
        }
    }
}
