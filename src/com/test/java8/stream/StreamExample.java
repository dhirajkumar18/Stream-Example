package com.test.java8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static <Optionaldouble> void main(String[] args) {
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

        //11. find the average of list of numbers
        List<Integer> list2=Arrays.asList(7,10,40,1,3,9,10,7);
        OptionalDouble average = list2.stream()
                .mapToInt(Integer::intValue)
                .average();
        System.out.println("average "+average);

        // 12. convert a list of string of there length.

        List<String> fruitlist=Arrays.asList("mango","banans","grapes","orange","coconut","apple","guava");
        List<Integer> newlist= fruitlist.stream().map(String::length).collect(Collectors.toList());
        System.out.println("fruit list by length "+newlist);

        //13. Get the first element of Stream
         String str=fruitlist.stream().findFirst().get();
        System.out.println("first string from list : "+ str);

        //14. check if any string in list contains "java"
        List<String> list3=Arrays.asList("spring","java","html","java script");
        boolean flag=list3.stream().anyMatch(s -> s.contains("java"));
        System.out.println("java contains "+flag);

        //15 Group a list of strings by there length
        Map<Integer,List<String>> map = fruitlist.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("grouped "+map);

        // 16. partition by even and odd
        Map<Boolean,List<Integer>> map2= list2.stream().collect(Collectors.partitioningBy(n -> n%2==0));
        System.out.println(" partition by even and odd "+map2);

        //17. count occurrences of each word in a list

        List<String> list4=Arrays.asList("java","spring","java","php","c++","c#","html","java script","spring");
        Map<String,Long> map3=list4.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Word occurrences "+map3);
        //18. skip first 5 element and print
        list4.stream().skip(5).forEach(System.out::println);
        System.out.println("************************");
        //19. Limit the stream to first 3 elements
        list4.stream().limit(3).forEach(System.out::println);

        //20. find duplicate in list
        Set<Integer> set=new HashSet<>();
        List<Integer> list5=Arrays.stream(arr).boxed().toList();
        System.out.println("list5" +list5);
       List<Integer> duplicates= list5.stream().filter(n -> !set.add(n)).toList();
        System.out.println("duplicates "+duplicates);
        // 21. fibanico series

        List<Integer> fibseries = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10)
                .map(fib -> fib[1]).collect(Collectors.toList());
        System.out.println(fibseries);

    }
}
