package core.util;

import java.util.Arrays;

public class LogUtil {
    static public void printArray(String[] array) {
        System.out.println(Arrays.toString(array));
    }

    static public synchronized void printArray(Double[] array) {
        System.out.println(Arrays.toString(array));
    }

    static public void printArray(String msg, Double[] array) {
        System.out.println(msg+Arrays.toString(array));
    }

    // String[][] deepArray = new String[][] {{"John", "Mary"}, {"Alice", "Bob"}};
    // output: [[John, Mary], [Alice, Bob]]
    static public void printDeepArray(String[][] array) {
        System.out.println(Arrays.deepToString(array));
    }
}
