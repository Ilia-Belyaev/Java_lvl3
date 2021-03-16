package Java_lvl3.git.lesson1.hw1;

public class MainArray {
    public static void main(String[] args){
        NewArray <Double>DoubleList = new NewArray<>(new Double[]{1d,3d,5d,7d,11d,13d,17d});
        NewArray <String>StringList = new NewArray<>(new String[]{"A","B","C","D","E"});
        DoubleList.convertArray();
        for (int i = 0; i < DoubleList.convertArray().size(); i++) {
            System.out.print(DoubleList.convertArray().get(i)+"\t");
        }
        System.out.println();
        for (int i = 0; i < StringList.convertArray().size(); i++) {
            System.out.print(StringList.convertArray().get(i)+"\t");

        }
        System.out.println();
        System.out.println(StringList.convertArray().indexOf("D"));
    }
}
