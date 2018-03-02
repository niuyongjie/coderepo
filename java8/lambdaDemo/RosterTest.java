package lambdaDemo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.lang.System.out;

/**
 * Lambda 表达式介绍,以一个方法的变迁为例子
 */
public class RosterTest {
    interface CheckPerson {
        boolean test(Person p);
    }

    /**
     * 方法 1 :
     * 匹配字段
     * 匹配对象中的一个字段, 以年龄为例.
     * 这个方法中对象的年龄是否大于指定的数字.
     * 缺点:
     * 1.如果需要小于指定年龄的对象, 就得再重写一个方法,改变操作符
     * 2.参数 age 的类型是固定的, 如果比较的其他类型的字段( 或者 Person 中的 age 变更类型), 就得重新编写方法
     */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    /**
     * 方法 2 :
     * 匹配字段区间化
     * 相比方法1, 该方法的参数是一个区间, 可以大于或小于指定值的对象. 优于方法1 * 缺点: * 没有解决对象不同字段类型, 字段个数变化等因素带来的困扰
     */
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int height) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < height) { // 注意区间的写法, 字段的顺序优美
                p.printPerson();
            }
        }
    }

    /**
     * 方法 3 :
     * 匹配对象, 接口, 内部类, 匿名内部类 ( 方法4 ), Lambda 表达式 ( 方法5 )
     * 面向接口编程的思想来过滤出需要的数据
     * 好处:
     * 1. 方法体的参数为接口, 就不会被具体形式参数类型所固化, 更加抽象化
     * 2. Person 类不管变更字段类型还是, 增删字段, 都不需要修改该方法体, 只需要修改接口实现方法的具体内容即可
     * 3. 接口可以有多个实现类, 灵活多变, 根据不同的情况, 使用不同的接口实现类即可
     * 方法 4 : 匿名内部类好处:
     * 4. ( 匿名内部类 ) 能大量降低代码量, 因为你不需要为每一种情况编写实现类. 只是在需要的时候编写对应的匿名
     * 内部类即可
     * 方法 5 : Lambda 表达式: 如果接口含有一个抽象方法 ( 该接口可能包含一个或多个默认方法或者静态方法 ) 的情况下,
     * 可以使用 Lambda 表达式来简化匿名内部类的编写过程( 无需写方法名称 ), 格式为:
     * (Person p) -> 语句
     * Lambda 好处:
     * 5. 相比匿名内部类, 更大程度减少了代码编写量
     */
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * 方法 6 :
     * 使用 JDK 提供的标准功能接口, 替换方法 3 中自定义的功能接口
     * 好处:
     * 由于功能接口比较简单, 不用在程序中重复定义, 直接使用 JDK 提供的默认功能接口即可
     */
    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * 方法 7 :
     * 使用 JDK 提供的标准功能接口, 替换方法 6 中的逻辑代码
     * 方法 6 中逻辑代码的特征( if 语句 ), 有一个参数 Person , 无返回值
     * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
     */
    public static void processPerson(List<Person> roster,
                                     Predicate<Person> tester,
                                     Consumer<Person> block) {
        for (Person person : roster) {
            if (tester.test(person)) {
                block.accept(person);
            }
        }

    }


    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        for (Person p : roster) {
            p.printPerson();
        }

        // Approach 1: Create Methods that Search for Persons that Match One
        // Characteristic

        out.println("Persons older than 20:");
        printPersonsOlderThan(roster, 20);
        out.println();

        // Approach 2: Create More Generalized Search Methods

        out.println("Persons between the ages of 14 and 30:");
        printPersonsWithinAgeRange(roster, 14, 30);
        out.println();

        // Approach 3: Specify Search Criteria Code in a Local Class

        out.println("Persons who are eligible for Selective Service:");
        class CheckPersonEligibleForSelectiveService implements CheckPerson {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        || p.getAge() <= 25;
            }
        }
        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        out.println();


        // Approach 4: Specify Search Criteria Code in an Anonymous Class

        out.println("Persons who are eligible for Selective Service " +
                "(anonymous class):");
        printPersons(roster, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.FEMALE
                        && p.getAge() >= 18
                        || p.getAge() <= 25;
            }
        });
        out.println();

        // Approach 5: Specify Search Criteria Code with a Lambda Expression

        System.out.println("Persons who are eligible for Selective Service " +
                "(lambda expression):");
        printPersons(roster,
                (Person p) -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        || p.getAge() <= 25);
        out.println();

        // Approach 6: Use Standard Functional Interfaces with Lambda
        // Expressions

        System.out.println("Persons who are eligible for Selective Service " +
                "(with Predicate parameter):");
        printPersons(roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        || p.getAge() <= 25);
        out.println();

        // Approach 7: Use Lamba Expressions Throughout Your Application

        System.out.println("Persons who are eligible for Selective Service " +
                "(with Predicate and Consumer parameters):");

        processPerson(roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        || p.getAge() <= 25,
                p -> p.printPerson());
    }
}
