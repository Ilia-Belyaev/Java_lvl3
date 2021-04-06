import org.example.CalculatorDivTest;
import org.example.Test;
import org.example.BeforeEach;
import org.example.AfterAll;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewReflection {
    private static int beforeEach = 0;
    private static int afterAll = 0;
    private static List<Integer> listOfPriority = new ArrayList<>();
    private static Test annotation;

    public static void main(String[] args) throws Exception {
        start(CalculatorDivTest.class);
    }

    public static void start(Class testClass) throws Exception {
        Method[] methods = testClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                annotation = method.getAnnotation(Test.class);
                listOfPriority.add(annotation.priority());
            }
        }
        Collections.sort(listOfPriority);

        for (Method method : methods) {

            if (method.isAnnotationPresent(BeforeEach.class)) {
                beforeEach++;
                if (beforeEach > 1) {
                    throw new Exception("Больше 1 метода c BeforeEach");
                }
                method.setAccessible(true);
                method.invoke(null);
            }
        }
        for (int i = 0; i < listOfPriority.size(); i++) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    if (listOfPriority.get(i) == method.getAnnotation(Test.class).priority()) {
                        method.setAccessible(true);
                        method.invoke(null);
                    }
                }
            }
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterAll.class)) {
                afterAll++;
                if (afterAll > 1) {
                    throw new Exception("Больше 1 метода c AfterAll");
                }
                method.setAccessible(true);
                method.invoke(null);
            }
        }
    }

}


