package Array;

import java.util.ArrayList;
import java.util.List;

public class CreateArray {
    private static int[] newArray;
    //private static int lengthArray;
    private static Integer lastFour = null;

    public CreateArray() {
        //this.lengthArray = lengthArray;
    }

    public static int[] condition(int[] array) {
        //array = createNumberInArray();


        for (int i = 0; i < array.length; i++) {//нахожу индекс последней 4
            if (array[i]==(4)) {//пришлось через == сравнивать
                lastFour = i+1;
            }
        }

        if (lastFour == null) {
            throw new RuntimeException("В этом массиве нет четвёрок");
        }
        newArray = new int[array.length - lastFour];
        for (int j = 0; j < array.length - lastFour ; j++) {
            newArray[j]=array[lastFour + j];
            System.out.print(newArray[j] + "\t");

        }
        return newArray;
    }


//    public static List<Integer> createNumberInArray() {
//        array = new ArrayList<>(lengthArray);
//        for (int i = 0; i < lengthArray; i++) {
//            array.add(i, (int) (Math.random() * 20));
//            System.out.print(array.get(i) + "\t");
//        }
//        System.out.println();
//        return array;
//    }
}
