package Java_lvl3.git.lesson1.hw1;
public class MainFruit {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> boxApple = new Box<>();
        Box<Apple> newBoxApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();
        for (int i = 0; i < 5; i++) {
            boxApple.addFruit(apple);
            boxOrange.addFruit(orange);
        }
//        for (int i = 0; i < boxApple.getBox().size(); i++) {
//            System.out.println(boxApple.getBox().get(i).weight);
//        }
        System.out.println(boxApple.getWeight());
        System.out.println(boxOrange.getWeight());
        System.out.println(boxApple.compare(boxOrange));
        System.out.println(boxApple.compare(boxApple));
        boxApple.refactorBox(newBoxApple,4);
        for (int i = 0; i <newBoxApple.getBox().size() ; i++) {
            System.out.println(newBoxApple.getBox().get(i).name);
        }
        System.out.println();
        for (int i = 0; i <boxApple.getBox().size() ; i++) {
            System.out.println(boxApple.getBox().get(i).name);
        }
    }
}
