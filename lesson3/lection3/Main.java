package Java_lvl3.git.lesson3.lection3;

public class Main {
    private final Object object = new Object();
    private volatile char thisWord = 'A';

    public static void main(String[] args) {
        Main myThreads = new Main();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myThreads.printA();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myThreads.printB();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                myThreads.printC();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (object) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (thisWord != 'A') {
                        object.wait();
                    }
                    System.out.print('A');
                    thisWord = 'B';
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (object) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (thisWord != 'B') {
                        object.wait();
                    }
                    System.out.print('B');
                    thisWord = 'C';
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (object) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (thisWord != 'C') {
                        object.wait();
                    }
                    System.out.print('C');
                    thisWord = 'A';
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
