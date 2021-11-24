import java.io.*;
import java.util.*;

public class Main {
    private static final int SIZE = 100000;
    private static final int SIZE2 = 100;

    public static void main(String[] args) {
        task1sub1();
        task1sub2();
        task2sub1();
        task2sub2();
    }

    private static void task1sub1() {
        List<String> list = new ArrayList<String>();
        try {
            File file = new File("textFiles/String.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);

        try (FileWriter writer = new FileWriter("textFiles/String.txt", false)) {
            for (int i = list.size() - 1; i >= 0; i--) {
                writer.write(list.get(i) + "\n");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void task1sub2() {
        Stack<Character> numbers = new Stack<Character>();
        try {
            File file = new File("textFiles/Number.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            int symbol;
            while ((symbol = reader.read()) != -1) {
                numbers.push((char) symbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(numbers);
        try (FileWriter writer = new FileWriter("textFiles/Number.txt", false)) {
            while (!numbers.isEmpty()) {
                writer.write(numbers.pop());
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Быстрее работает с ArrayList, т.к от использует массив под капотом.
    // LinkedList двусвязный список. Объекты связанного листа могут быть разбросаны в памяти,
    // и их придется загружать в кеш поштучно, что относительно дорого.
    private static void task2sub1() {
        arrayList();
        linkedList();
    }

    private static void arrayList() {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(i);
//        List<Integer> result =  reformatList(list, defaultIndex);
//        System.out.println("result: " + result);
        int i = 0;                                  // Буферные переменные
        int size = 0;
        while (list.size() > 1) {                     // Создаём петлю, которая повторяется
            // до тех пор пока длина не будет 1
            if (list.size() % 2 != 0) {              // Если длина списка Нечётная
                i = 0;
                size = list.size() / 2;                // Количество элементов которые удалятся
                for (int j = 0; j < size ; j++) {   // Удаляем их через for
                    list.remove(i + 1);
                    i++;
                }
                list.remove(0);                      // После удаляем первый
            } else if (list.size() % 2 == 0) {        // Если длина списка Чётная
                i = 0;                              // Далее тоже что и выше
                size = list.size() / 2;
                for (int j = 0; j < size ; j++) {
                    list.remove(i + 1);
                    i++;
                }
            }
        }
        System.out.println(list);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time arrayList: " + (endTime - startTime) + "ms");
    }
// рекурсивно, дропается от 10к элементах(переполнение стека)
//    private static int defaultStep = 2;
//    private static int defaultIndex = defaultStep;
//    private static List<Integer> reformatList(List<Integer> list, int idx) {
//        if (list.size() == 1) {
//            return list;
//        }
//        if (idx > list.size())
//            return reformatList(list, idx - list.size());
//
////        System.out.print(list.get(idx - 1) + ", ");
//        list.remove(idx - 1);
//
//        return reformatList(list, defaultStep + idx - 1);
//    }

    private static void linkedList() {
        long startTime = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < SIZE; i++)
            linkedList.add(i);
//        LinkedList<Integer> result = reformatList1(linkedList, defaultIndex);
//        System.out.println("result: " + result);
        int i = 0;                                  // Буферные переменные
        int size = 0;
        while (linkedList.size() > 1){                     // Создаём петлю, которая повторяется
            // до тех пор пока длина не будет 1
            if (linkedList.size() % 2 != 0) {              // Если длина списка Нечётная
                i = 0;
                size = linkedList.size() / 2;                // Количество элементов которые удалятся
                for (int j = 0; j < size ; j++) {   // Удаляем их через for
                    linkedList.remove(i + 1);
                    i++;
                }
                linkedList.remove(0);                      // После удаляем первый
            } else if (linkedList.size() % 2 == 0) {        // Если длина списка Чётная
                i = 0;                              // Далее тоже что и выше
                size = linkedList.size() / 2;
                for (int j = 0; j < size ; j++) {
                    linkedList.remove(i + 1);
                    i++;
                }
            }
        }
        System.out.println(linkedList);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time linkedList: " + (endTime - startTime) + "ms");
    }
//    private static LinkedList<Integer> reformatList1(LinkedList<Integer> list, int idx) {
//        if (list.size() == 1) {
//            return list;
//        }
//        if (idx > list.size())
//            return reformatList1(list, idx - list.size());
//
////        System.out.print(list.get(idx - 1) + ", ");
//        list.remove(idx - 1);
//
//        return reformatList1(list, defaultStep + idx - 1);
//    }

    // интересней не придумал, в этой реализации число Х нам даже не нужно
    private static void task2sub2() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < SIZE2; i++) {
            arrayList.add((int) (Math.random()* 100));
        }
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = arrayList.size() - 1; j > i; --j) {
                if (arrayList.get(j - 1) > arrayList.get(j)) {
                    arrayList.set(j - 1, arrayList.get(j - 1) + arrayList.get(j));
                    arrayList.set(j, arrayList.get(j - 1) - arrayList.get(j));
                    arrayList.set(j - 1, arrayList.get(j - 1) - arrayList.get(j));
                }
            }
        }
        System.out.println(arrayList);
    }
}