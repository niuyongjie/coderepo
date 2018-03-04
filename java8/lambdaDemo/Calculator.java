package lambdaDemo;

import static java.lang.System.out;

/**
 * Lambd 表达式的应用
 */
public class Calculator {
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        Calculator app = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        out.println("40 + 2 = " + app.operateBinary(40, 2, addition));
        out.println("20 - 2 = " + app.operateBinary(20, 2, subtraction));
    }
}
