package Java_lvl3.git.lesson1.hw1;

import java.util.ArrayList;

public class NewArray<T>{
    private  T[] mass;
    NewArray(T[] mass){
        this.mass = mass;
    }
    public ArrayList convertArray(){
        ArrayList<T> list= new ArrayList<>();
        for (int i = 0; i < mass.length; i++) {
            list.add(i,mass[i]);
        }

        return list;
    }
}
