package Java_lvl3.git.lesson1.hw1;
import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> box ;
    Box(){
        this.box=new ArrayList<>();
    }
    public  void addFruit(T fruit){
        box.add(fruit);
    }

    public ArrayList<T> getBox() {
        return box;
    }
    public String getWeight(){
        float sum = 0f;
        for (T t : box) {
            sum += t.getWeight();
        }
        return "Вес коробки составляет " + sum + " у.е.";
    }
    public boolean compare(Box<?> arrayList){
        return this.getWeight().equals(arrayList.getWeight());
    }

    public void refactorBox(Box<T> box1, int elem){

        for (int i = 0; i <elem ; i++) {
            box1.addFruit(this.box.get(i));
        }
        this.box.subList(0,elem).clear();

    }
}
