import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Fp: 函数式编程
 */
public class Fp {

    public static void main(String[] args) {
        List.of(Test.class.getDeclaredMethods()).stream().filter(m -> m.getName().contains("test")).forEach(m -> {
            System.out.println(m.getName() + ":");
            try {
                m.invoke(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

class Test {

    public static void test0() {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array, (c1, c2) -> c1.toLowerCase().compareTo(c2.toLowerCase()));
        System.out.println(String.join(", ", array));
    }

    /**
     * 初识stream
     */
    public static void test1() {
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        stream.map((c) -> c.toLowerCase()).forEach(System.out::println);
    }

    /**
     * fp三件套: map, filter, reduce
     */
    public static void test2() {
        Integer res = Stream.of(1, 2, 3, 4, 5, 6).filter(v -> v % 2 == 0).map(v -> v * v).reduce(0,
                (v1, v2) -> v1 + v2);
        System.out.println("sum :" + res);
    }
}