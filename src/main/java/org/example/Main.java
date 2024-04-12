package org.example;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        List<Order> task1 = orders.stream().distinct().collect(Collectors.toList());
        System.out.println(task1);

        Map<String, Long> task2 = orders.stream().collect(Collectors.groupingBy(Order::getProduct,
                Collectors.counting()));
        System.out.println(task2);

        Map<String, Double> task3 = orders.stream().collect(Collectors.groupingBy(Order::getProduct,
                Collectors.summingDouble(Order::getCost)));
        System.out.println(task3);

        task3.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue()
                .reversed()).forEach(System.out::println);

        System.out.println();

        orders.stream().sorted((Comparator.reverseOrder())).limit(3).forEach(System.out::println);

        System.out.println(orders.stream().sorted((Comparator.reverseOrder())).limit(3)
                .collect(Collectors.summingDouble(Order::getCost)));


    }
}