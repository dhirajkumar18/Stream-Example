package com.test.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        // 1. Find even number from list

        List<Integer> list1 = Arrays.asList(2, 7, 13, 18, 29, 42, 65, 72);
        List<Integer> evenList = list1.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("even list: " + evenList);

        //2. find the maximum number in list
        Optional<Integer> maxval = list1.stream().max(Integer::compareTo);
        maxval.ifPresent(integer -> System.out.println("max val" + integer));

        // 3. find the minimum in list

        Optional<Integer> minval = list1.stream().min(Integer::compareTo);
        System.out.println("min val="+minval.get());

        // 4. count the number of string starting with "A"

        List<String> names=Arrays.asList("amit","Anjali","dhiraj","priya","sakshi","neha","anil");
        long count=names.stream().filter(s -> s.toLowerCase().startsWith("a")).count();
        System.out.println("count="+count);

        // 5. Convert all string to uppercase

        List<String> upper=names.stream().map(String::toUpperCase).toList();
        System.out.println("upper case "+ upper);

        // 6. remove duplicates from list
        int arr[]={10,20,12,10,40,45,60,72,80,20,40,90,45};
        List<Integer> unique=Arrays.stream(arr).boxed().distinct().toList();
        System.out.println("unique "+unique);

        // 7. Sort a list in ascending order
        List<Integer> ascnumlist=Arrays.stream(arr).boxed().distinct().sorted().toList();
        System.out.println("ascending list "+ascnumlist);

        //8. Sort a list in descending order
        List<Integer> descnumlist=Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).distinct().toList();
        System.out.println("descending order "+descnumlist);

        //9. join a string with delimeter
        List<String> namelist= Arrays.asList("dhiraj kumar","priya kumari","neha sharma","gita rani");
        namelist.stream().collect(Collectors.joining(" - "));
        System.out.println(namelist);

        // 10. find the sum of all elements

        int sum=unique.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum is "+sum);

    }
}
