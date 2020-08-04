/**
 * Generic
 */
public class Generic {

    public static void main(String[] args) {
        Man<Integer, String> man = new Man<>(20, "I'am a man!");
        man.printManInfo(man.getPersonSex());
    }
}


// 泛型接口
interface Person<T>{
    public T getPersonSex();
}

// 泛型模板类
class Man<T, K> implements Person<String>{
    public T info0;
    public K info1;

    public Man(T t, K k){
        this.info0 = t;
        this.info1 = k;
    }

    // 泛型方法
    public <R> void printManInfo(R r){
        System.out.printf("info0: %s, info1: %s, sex: %s\n", this.info0, this.info1, r);
    }

    @Override
    public String getPersonSex() {
        return "man";
    }
}