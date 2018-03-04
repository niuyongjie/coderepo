package lambdaDemo;

import java.util.function.Consumer;

import static java.lang.System.out;

/**
 * 演示 Lambda 表达式变量的作用域
 */
public class LambdaScopeTest {
    public int x = 0;

    class FirstLevel {
        public int x = 1;

        void methodInFirstLevel(int x) {
            // 1. The following statement causes the compiler to generate
            // the error "local variables referenced from a lambda expression
            // must be final or effectively final" in statement A:
            //
            // x = 99;

            //2. If you substitute the parameter x in place of y in the
            //declaration of the lambda expression myConsumer,
            // then the compiler generates an error:
            // The compiler generates the error "variable x is already defined

            Consumer<Integer> consumer = (y) -> {
                out.println("x = " + x);
                out.println("y = " + y);
                out.println("this.x = " + this.x);
                out.println("LambdaScopeTest.this.x = " +
                        LambdaScopeTest.this.x);
            };

            consumer.accept(x);
        }
    }

    public static void main(String[] args) {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
