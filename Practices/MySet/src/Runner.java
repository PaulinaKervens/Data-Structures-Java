package MySet.src;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class Runner {

    void main() {
        Set<String> set = new HashSet<>();
        set.add("Kali");
        set.add("Nicole");
        set.add("Jean");
        set.add("AllSet");
        set.add("Bukele");
        set.add("Kirki");
        set.add("Nanikaze");
        set.add("Osam Benly 10");
        set.add("Molie");

        Set<String> myset = new LinkedHashSet<>();
        myset.add("Kali");
        myset.add("Nicole");
        myset.add("Jean");
        myset.add("AllSet");
        myset.add("Bukele");
        myset.add("Kirki");
        myset.add("Nanikaze");
        myset.add("Osam Benly 10");
        myset.add("Molie");

        for(String set1 : set) {
            System.out.println(set1.hashCode() + " " + set1);
        }



        System.out.println(" ");

        myset.forEach(
                e -> System.out.println(
                        e.hashCode() + " " + e.toUpperCase()
                )
        );

    }

}