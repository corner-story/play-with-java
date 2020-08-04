import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DynamicProxy: 可以在运行期动态创建某个interface的实例
 */
public class DynamicProxy {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before invoke......");
                // method.invoke(proxy, args);
                if(method.getName().equals("sayHello")){
                    System.out.println("hello, " + args[0]);
                }
                System.out.println("after invoke......");
                return null;
            }
        };
        Greeting g = (Greeting)Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), new Class[]{Greeting.class}, handler);
        g.sayHello("lambdafate");
        g.sayNothing("lambdafate");
    }
}

interface Greeting {
    public void sayHello(String name);
    public void sayNothing(String name);
}