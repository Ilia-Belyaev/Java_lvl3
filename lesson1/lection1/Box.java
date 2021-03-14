package Java_lvl3.git.lesson1.lection1;

// new Box<Integer>()
// new Box<String>()
public class Box<T> { // (String name, int num)
    // T - type, E - element, K - key, V - value

    private T obj;

    public Box(T obj) {
        this.obj = obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

}
