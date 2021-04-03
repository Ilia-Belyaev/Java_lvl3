package CompositionArray;

import java.util.Arrays;

public class ArrayStructure {
    ArrayStructure() {

    }

    public static Boolean createArray(int[] array) {
        Arrays.sort(array);
        return ((Arrays.binarySearch(array, 1)) >= 0) && ((Arrays.binarySearch(array, 4)) >= 0);
    }
}
