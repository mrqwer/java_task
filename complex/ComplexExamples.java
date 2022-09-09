// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.Setter;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// import static java.util.stream.Collectors.groupingBy;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString(){
            return "Person: " + name;
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться Key: Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */
        
        /*
        Сперва убираю дупликаты, просто добавляя каждый экзепляр класса Person в HashMap,
        он сам уберет дупликаты, так как внутри класса переопределены методы equals и hashCode
        */
        System.out.println("Task 1");
        Map<Person, Integer> map = new HashMap<>();

        for(int i = 0; i < RAW_DATA.length; i++){
            map.put(RAW_DATA[i], RAW_DATA[i].getId());
        }

        /* 
        Дальше создаю новую хэш-карту по ключам именам каждого экзепляра и значение список состоящий из id каждого человека
        входящего в одну группу схожих имен.
        */
        Map<String, List<Integer>> map2 = new HashMap<>();
        for(Map.Entry<Person, Integer> entry : map.entrySet()){
            if (!map2.containsKey(entry.getKey().getName())){ // если нет нашего имени в новой карте map2 
                List<Integer> a = new ArrayList<>(); // создаем список из id. сработает только один раз для каждой уникальной группы имен
                a.add(entry.getValue()); // добавляем id из значений каждого ключа предыдущей карты в список id текущей группы имен, также сработает один раз для каждого уникального имени
                map2.put(entry.getKey().getName(), a); // добавляем имя группы и список состоящий пока из одного элемента
            }
            else{
                map2.get(entry.getKey().getName()).add(entry.getValue()); // при нахождений схожих имен уже имеющегося ключа в карте, добавляем в список id
            }
        }

        for(Map.Entry<String, List<Integer>> entry: map2.entrySet()){
            Collections.sort(entry.getValue());
            System.out.println("Key:"+entry.getKey() + " | " + "List of each persons id in this group by non-decreasing order:" + entry.getValue());
            System.out.println("Value:" + entry.getValue().size());

        }
        System.out.println("The End of Task 1\n");

        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */
        
        System.out.println("Task 2");
        int [] arr = new int[]{3, 4, 2, 7};
        int [] res = new int[2];
        int target = 10;
        Map<Integer, Integer> map3 = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int tmp = target-arr[i];
            if(map3.containsKey(tmp)){
                res[0] = tmp;
                res[1] = arr[i];
            }
            map3.put(arr[i], i);
        }
        System.out.println(Arrays.toString(res));
        System.out.println("The end of Task 2\n");
        /*
        Task3
            Реализовать функцию нечеткого поиска
            
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */

         System.out.println("Task 3");
         System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
         System.out.println(fuzzySearch("cwhl", "cartwheel"));
         System.out.println(fuzzySearch("cwhee", "cartwheel"));
         System.out.println(fuzzySearch("cartwheel", "cartwheel"));
         System.out.println(fuzzySearch("cwheeel", "cartwheel"));
         System.out.println(fuzzySearch("lw", "cartwheel"));
         System.out.println("The end of Task 3");
    }
    
    public static boolean fuzzySearch(String pattern, String string){
        if(string.equals(pattern)) return true;
        int i = 0, j = 0;
        while (j < string.length()){
            if (pattern.charAt(i) == string.charAt(j)){
                if(i+1 == pattern.length()) return true;
                i++;
            }
            j++;
        }
        return false;
    }
}