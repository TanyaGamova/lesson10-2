import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};

        // 1, 2
        List<String> fourOldBoys = boys.stream().filter(x -> x.getAge() > 17 ).map(x -> x.getName() ).distinct().sorted().limit(4).
                collect(Collectors.toList());

        //debug
        fourOldBoys.forEach(System.out::println);
        // 3
        Map<String,Long> namesakes = fourOldBoys.stream().collect(
                Collectors.toMap(String::valueOf, cur -> boys.stream().filter( x -> x.getName() == cur).count() - 1));
        // 4
        namesakes.entrySet().stream().map(x -> x.getKey() + '=' + x.getValue() ).forEach(System.out::println);
    }
}
