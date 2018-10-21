package lambdaDemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/**
 * 演示 JDK 8 新特性: 方法引用
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        Person[] rosterArray = roster.toArray(new Person[roster.size()]);
        roster.stream().forEach(person -> person.printPerson());

        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        // Lambda Expression version 1
        Arrays.sort(rosterArray,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                });

        // Lambda Expression version 2
        Arrays.sort(rosterArray, (a, b) -> Person.compareByAge(a, b));

        out.println("sort by Age ");
        Arrays.stream(rosterArray).forEach(p -> p.printPerson());
    }
}
