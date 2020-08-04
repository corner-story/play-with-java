import java.lang.reflect.*;

public class Reflection {

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        Field fnum = test.getClass().getDeclaredField("num");
        fnum.setAccessible(true);
        int num = fnum.getInt(test);
        for (int i = 0; i < num; i++) {
            String methodName = "test" + i;
            Method m = test.getClass().getDeclaredMethod(methodName);
            if(m != null){
                System.out.println(methodName + ":");
                m.invoke(test);
            }
        }
    }
}

class Test {
    private int num = 4;

    // jvm中每一个class只有一个
    public void test0() throws Exception {
        Class<?> c1 = "fuck".getClass();
        Class<?> c2 = Class.forName("java.lang.String");
        Class<?> c3 = java.lang.String.class;
        System.out.println((c1 == c2 && c2 == c3));
    }

    // 获取Class中Field类
    public void test1() throws Exception{
        Test t = new Test();
        Field f = t.getClass().getDeclaredField("num");
        System.out.printf("Field Test.num -> %s %s %s", f.getName(), f.getType(), Modifier.isPrivate(f.getModifiers()));
        f.setAccessible(true);
        Object oldValue = f.get(t);
        System.out.printf("\told value: %s", oldValue);
        f.setInt(t, 10);
        System.out.printf("\told value: %s", f.get(t));
        System.out.printf("\tnew value: %s\n", new Test().num);
    }

    // 获取class中的Method
    public void test2() throws Exception{
        Test t = new Test();
        Method m = t.getClass().getDeclaredMethod("sayHello", String.class);
        m.setAccessible(true);
        m.invoke(t, "reflection-method");
    }

    // 获取class的其他信息
    public void test3() throws Exception{
        Class<?> c = Test.class;
        System.out.println("superclass: ");
        while(c != null){
            System.out.println("\t" + c.getSuperclass());
            c = c.getSuperclass();
        }
        System.out.println("interfaces: " + Test.class.getInterfaces().length);
    }

    private void sayHello(String name){
        System.out.printf("hello, %s!\n", name);
    }
}