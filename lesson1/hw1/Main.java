package Java_lvl3.git.lesson1.hw1;

public class Main {
    public static void main(String[] args){
    SwapPlacesSomeElement<Integer> newSwap = new SwapPlacesSomeElement<>(new Integer[]{1,2,3,4,5},1,3);
    SwapPlacesSomeElement<String> newSwap1 = new SwapPlacesSomeElement<>(new String[]{"one","two","three","four","five"},4,2);
        System.out.println("Новый массив newSwap: ");
        newSwap.isSwap();
        for (int i = 0; i < newSwap.isSwap().length ; i++) {
            System.out.print(newSwap.isSwap()[i]+"\t");
        }
        System.out.println();
        newSwap1.isSwap();
        System.out.println("Новый массив newSwap1: ");
        for (int i = 0; i < newSwap1.isSwap().length ; i++) {
            System.out.print(newSwap1.isSwap()[i]+"\t");
        }

    }
}
