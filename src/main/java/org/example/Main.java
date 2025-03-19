package org.example;

import org.example.entity.Employee;

import java.util.*;

import static org.example.WordCounter.calculatedWord;

public class Main {
    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();


        employees.add(new Employee(101, "Sinem", "Türkmen"));
        employees.add(new Employee(102, "Mustafa", "Türkmen"));
        employees.add(new Employee(102, "Berdus", "Türkmen"));
        employees.add(new Employee(104, "Ciko", "Sevimlikurt"));
        employees.add(new Employee(101, "Alex", "Sevimlikurt"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: " + duplicates);

        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("Uniques: " + uniques);

        List<Employee> noDuplicates = removeDuplicates(employees);
        System.out.println("No duplicates: " + noDuplicates);
    }
    public static List<Employee> findDuplicates(List<Employee> employees){
        List<Employee> duplicates = new ArrayList<>();
        Set<Employee> unique = new HashSet<>();
        for(Employee employee: employees){
            if(!unique.add(employee)){
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> uniqueMap = new LinkedHashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
            }
        }

        for (Employee employee : employees) {
            if (employee != null && countMap.get(employee.getId()) == 1) {
                uniqueMap.put(employee.getId(), employee);
            }
        }

        for (Employee employee : employees) {
            if (employee != null && countMap.get(employee.getId()) > 1 && !uniqueMap.containsKey(employee.getId())) {
                uniqueMap.put(employee.getId(), employee);
            }
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> noDuplicates = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for(Employee employee: employees) {
            if (employee != null) {
                countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
            }
        }
        for(Employee employee: employees){
            if(employee != null && countMap.get(employee.getId()) == 1){
                noDuplicates.add(employee);
            }
        }
        return noDuplicates;
    }


}