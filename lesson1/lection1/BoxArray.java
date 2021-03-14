package Java_lvl3.git.lesson1.lection1;

public class BoxArray<T extends Number> implements Comparable<T> {

    private T[] arr;

    public BoxArray(T[] arr) {
        this.arr = arr;

        // Что делать нельзя!
        // 1. нельзя создать объект типа T t = new T();
        // 2. нельзя создать новый массив T[] t = new T[2];
        // 3. Нельзя создавать обобщенные исключения
        // 4. Нельзя использовать в статическом контексте
    }

    public double getAverage() {
        double average = 0.0;
        for (T el : arr) {
            average += el.doubleValue();
        }

        return average / arr.length;
    }

    public boolean isAverageEqual(BoxArray<?> box) {
        return Math.abs(this.getAverage() - box.getAverage()) < 0.001;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        double v1 = 0.0;
        double v2 = 0.5;

        for (int i = 0; i < 50; i++) {
            v1 += 0.01;
        }

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v1 - v2);
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
