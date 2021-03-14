package Java_lvl3.git.lesson1.hw1;

public class SwapPlacesSomeElement<T> {
    private int firstElement;
    private int secondElement;
    private  T[] mass;
    private T isVariable;
    SwapPlacesSomeElement(T[] mass, int firstElement, int secondElement){
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.mass = mass;
    }
    public T[] isSwap(){
        isVariable = mass[secondElement];
        mass[secondElement] = mass[firstElement];
        mass[firstElement] = isVariable;
        return mass;
    }
}
