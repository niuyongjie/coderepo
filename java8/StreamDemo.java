import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * Stream 流示例
 */
public class StreamDemo {
    public static void main(String[] args) {
        // 从集合创建流
        List<String> languages = Arrays.asList("English", "Chinese", "Chinese", "Japanese", "Hindi");
        Stream<String> languageStream = languages.stream();

        // 统计集合中不重复的元素总和
        long distinctCount = languageStream.distinct().count();
        out.println("集合不重复统计: " + distinctCount);
        // 统计集合中的元素总和
        out.println("集合统计: " + languages.stream().count());

        // 集合中是否包含元素
        boolean containsElement = languages.stream().anyMatch(item -> item.contains("English"));
        out.println(containsElement);

        // 过滤集合中的元素,留下偶数
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> filterStream = integers.stream().filter(element -> element % 2 == 0);
        filterStream.forEach(out::println);

        // 将 String 集合转为 Integer 集合
        List<String> stringList = Arrays.asList("110", "120", "119", "114");
        Stream<Integer> integerStream = stringList.stream().map(Integer::valueOf);
        integerStream.forEach(out::println);

        // 收集 Stream 执行过程中,变化的元素
        List<String> collectModifyElement = languages.stream().map(String::toUpperCase).collect(Collectors.toList());
        collectModifyElement.stream().forEach(out::println);

    }
}
