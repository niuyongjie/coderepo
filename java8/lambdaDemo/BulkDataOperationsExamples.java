package lambdaDemo;

import java.util.List;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

/**
 * stream 和 方法引用对大量数据的操作示例
 */
public class BulkDataOperationsExamples {
    public static void main(String[] args) {

        // Create sample data

        List<Person> roster = Person.createRoster();

        // 1. Print names of members, for-each loop

        out.println("Members of the collection (for-each loop):");
        for (Person p : roster) {
            out.println(p.getName());
        }

        // 2. Print names of members, forEach operation

        out.println("Members of the collection (bulk data operations):");
        roster
                .stream()
                .forEach(p -> out.println(p.getName()));

        // 3. Print names of male members,

        out.println("Male members of the collection (bulk data operation):");
        roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .forEach(p -> out.println(p.getName()));

        // 4. Print names of male members, for-each loop

        out.println("Male members of the collection (for-each loop):");
        for (Person p : roster){
            if (p.getGender() == Person.Sex.MALE) {
                out.println(p.getName());
            }
        }

        // 5. Get average age of male members of the collection:

        double average = roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        out.println("Average age of male members (bulk data operations):" + average);

    }
}
