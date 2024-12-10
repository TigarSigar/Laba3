package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        // Задание 1A
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        System.out.println("Массив: " + Arrays.toString(array));

        // Задание 1B
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        System.out.println("Список: " + list);

        // Задание 1C
        Collections.sort(list);
        System.out.println("Отсортированный список: " + list);

        // Задание 1D
        Collections.reverse(list);
        System.out.println("Реверс списка: " + list);

        // Задание 1E
        Collections.shuffle(list);
        System.out.println("Перемешанный список: " + list);

        // Задание 1F
        Collections.rotate(list, 1);
        System.out.println("Список после вращения: " + list);

        // Задание 1G
        List<Integer> uniqueList = new ArrayList<>();
        for (int num : list) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }
        System.out.println("Список без дубликатов: " + uniqueList);

        // Задание 1H
        List<Integer> filteredList = new ArrayList<>(uniqueList);
        for (int i = 0; i < uniqueList.size(); i++) {
            int count = 0;
            for (int num : list) {
                if (uniqueList.get(i).equals(num)) {
                    count++;
                }
            }
            if (count < 2) {
                filteredList.remove(uniqueList.get(i));
            }
        }
        System.out.println("Элементы, встречающиеся не менее 2 раз: " + filteredList);

        // Задание 1I
        int[] listToArray = new int[filteredList.size()];
        for (int i = 0; i < filteredList.size(); i++) {
            listToArray[i] = filteredList.get(i);
        }
        System.out.println("Список в массиве: " + Arrays.toString(listToArray));

        // Задание 1J
        for (int k : listToArray) {
            int count = 0;
            for (int j : listToArray) {
                if (k == j) {
                    count++;
                }
            }
            System.out.println(k + " - " + count);
        }

        System.out.println();

        // Задание 2
        System.out.println("Простые числа:");
        PrimesGenerator generator = new PrimesGenerator(10);
        generator.generatePrimes();
        System.out.println(generator.getPrimes());

        // Задание 3
        List<Human> humans = Arrays.asList(
                new Human("Nikita", "Shark", 20),
                new Human("Danila", "Revenko", 25),
                new Human("Ilya", "Ekimov", 30)
        );

        humans.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println("Сортировка по имени: " + humans);

        humans.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.surname.compareTo(o2.surname);
            }
        });
        System.out.println("Сортировка по фамилии: " + humans);

        // Задание 4
        String text = "This is a test test".toLowerCase();
        String[] words = text.split("\\W+");

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
        System.out.println("Подсчёт слов: " + wordCounts);
    }
}

class PrimesGenerator {
    private final List<Integer> primes = new ArrayList<>();
    private final int count;

    public PrimesGenerator(int count) {
        this.count = count;
    }

    public void generatePrimes() {
        int num = 2;
        while (primes.size() < count) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

class Human {
    public String name;
    public String surname;
    public int age;

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + age + " лет";
    }
}
