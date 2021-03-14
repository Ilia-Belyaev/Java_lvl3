package Java_lvl3.git.lesson1.lection1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>(1);
        Box<Integer> box2 = new Box<>(2);
        // Integer, Character, Long
        // int, char, long
        // autoboxing

        int number = box1.getObj() + box2.getObj();
        System.out.println(number);

        BoxArray<Integer> intArray = new BoxArray<>(new Integer[] {1, 2, 3, 4, 5});
        BoxArray<Double> doubleArray = new BoxArray<>(new Double[] {1.0, 2.0, 3.0, 4.0, 5.0});
//        BoxArray<String> stringBoxArray = new BoxArray<>(new String[] {""});

        System.out.println(intArray.getAverage());
        System.out.println(doubleArray.getAverage());

        intArray.isAverageEqual(doubleArray);

        foo(1);
        foo("asd");

        List<? extends Number> l = new ArrayList<Integer>();
        l = new ArrayList<Double>();
//        l.add(2);

       // List<Integer> integers = List.of(1, 2, 3);
        //List<Double> doubles = List.of(1D, 2D, 3D);
//        fooList(integers);
//        fooList(doubles);
    }

    public static <T> T foo(T obj) {
        return obj;
    }

    public static void fooList(List<? super Number> list) {
//        Number number = list.get(0);
//        list.add(new Object());
        list.add(2);
        list.add(2.0);
        list.add(2.6);
    }

}
