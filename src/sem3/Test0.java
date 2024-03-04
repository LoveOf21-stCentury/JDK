package sem3;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;

public class Test0<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
//    Создать обобщенный класс с тремя параметрами (T, V, K).
//    Класс содержит три переменные типа (T, V, K),
//    конструктор, принимающий на вход параметры типа (T, V, K),
//    методы возвращающие значения трех переменных.

//    Создать метод, выводящий на консоль имена классов для трех переменных класса.
//    Наложить ограничения на параметры типа:
//    T должен реализовать интерфейс Comparable,
//    V должен реализовать интерфейс DataInput и расширять класс InputStream,
//    K должен расширять класс Number.

    private T valueT;
    private V valueV;
    private K valueK;

    public Test0(T valueT, V valueV, K valueK) {
        this.valueT = valueT;
        this.valueV = valueV;
        this.valueK = valueK;
    }

    public T getValueT() {
        return valueT;
    }

    public V getValueV() {
        return valueV;
    }

    public K getValueK() {
        return valueK;
    }

    public void print() {
        System.out.printf("t = %s, v = %s, k = %s", valueT.getClass().getSimpleName(),
                valueV.getClass().getSimpleName(),
                valueK.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Test0<String, DataInputStream, Integer> test0 = new Test0<>("example", new DataInputStream(System.in),  10);
        test0.print();
    }
}
