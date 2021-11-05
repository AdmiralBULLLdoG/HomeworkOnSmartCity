import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = Integer.parseInt(input.nextLine()); // Читаем с клавиатуры размер массива и записываем в size
        String[] array = new String[size]; // Создаём массив String размером в size
        System.out.println("Insert array elements:");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++)
            array[i] = input.nextLine(); // Заполняем массив элементами, введёнными с клавиатуры
        //1
        String Short = array[0];
        String Long = array[0];
        int size_Short = array[0].length();
        int size_Long = array[0].length();
        for (int i = 0; i < size; i++) {
            if (array[i].length() < size_Short) {
                Short = array[i];
                size_Short = array[i].length();
            }
            if (array[i].length() > size_Long) {
                Long = array[i];
                size_Long = array[i].length();
            }
        }
        System.out.println("The shortest: " + Short + " its length: " + size_Short);
        System.out.println("The longest: " + Long + " its length: " + size_Long);
        //2
        System.out.println("-------------------");
        String[] arrayTmp = new String[size];
        System.arraycopy(array, 0, arrayTmp, 0, size);
        for (int left = 0; left < arrayTmp.length; left++) {
            // Вытаскиваем значение элемента
            String value = arrayTmp[left];
            int _length = arrayTmp[left].length();
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (_length < arrayTmp[i].length()) {
                    arrayTmp[i + 1] = arrayTmp[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            arrayTmp[i + 1] = value;
        }
        System.out.println("Sorted: ");
        for (int i = 0; i < size; i++)
            System.out.println(arrayTmp[i]);
        //3
        System.out.println("-------------------");
        int average_length = 0;
        for (int i = 0; i < size; i++) {
            average_length += array[i].length();
        }
        average_length /= size;
        System.out.println("Average length: " + average_length);
        String[] less = new String[size];
        String[] more = new String[size];
        for (int i = 0; i < size; i++) {
            if (array[i].length() <= average_length)
                less[i] = array[i];
            if (array[i].length() > average_length)
                more[i] = array[i];
        }
        System.out.println("Less average length: ");
        for (int i = 0; i < size; i++) {
            if (less[i] == null)
                continue;
            System.out.println("Value: " + less[i] + " Length: " + less[i].length());
        }
        System.out.println("More average length: ");
        for (int i = 0; i < size; i++) {
            if (more[i] == null)
                continue;
            System.out.println("Value: " + more[i] + " Length: " + more[i].length());
        }
        System.out.println("-------------------");
        //4
        // достали из строки в инт
        int[] values = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            values[i] = Integer.parseInt(array[i]);
        }
        int[] counterArray = new int[size];
        int equality = 0;
        int onlyEven = 0;
        boolean[] _increase = new boolean[size];
        boolean[] differentNumbers = new boolean[size];
        boolean[] _palindrome = new boolean[size];
        for (int i = 0; i < array.length; i++) {
            boolean increase = true;
            int[] numbers = new int[10];
            // подчитываем количество символов в числе
            int tmp = values[i];
            int count = (tmp == 0) ? 1 : 0;
            while (tmp != 0) {
                count++;
                tmp /= 10;
            }
            // разделяем число на цифры
            int[] elements = new int[count];
            int tmp1 = values[i];
            for (int j = 0; j < count; j++) {
                elements[count - j - 1] = tmp1 % 10;
                tmp1 /= 10;
            }
            for (int j = 0; j < elements.length; j++)
                numbers[elements[j]] = 1;
            int sum = 0;
            for (int j = 0; j < numbers.length; j++)
                sum += numbers[j];
            counterArray[i] = sum;
            //5
            int even = 0;
            int uneven = 0;
            for (int j = 0; j < elements.length; j++) {
                if (elements[j] % 2 == 0)
                    even++;
                else
                    uneven++;
            }
            if (even == uneven)
                equality++;
            if (uneven == 0)
                onlyEven++;
            //6
            for (int j = 0; j < elements.length - 1; j++) {
                if (elements[j] >= elements[j + 1]) {
                    increase = false;
                    break;
                }
            }
            _increase[i] = increase;
            //7
            if (count == counterArray[i] && count != 1)
                differentNumbers[i] = true;
            //8
            int palindrome = values[i];
            int reverse = 0;
            while (palindrome != 0) {
                int remainder = palindrome % 10;
                reverse = reverse * 10 + remainder;
                palindrome = palindrome / 10;
            }
            if (values[i] == reverse)
                _palindrome[i] = true;
        }
        int maxElem = counterArray[0];
        int index = 0;
        for (int i = 1; i < counterArray.length; i++) {
            if (maxElem > counterArray[i]) {
                maxElem = counterArray[i];
                index = i;
            }
        }

        System.out.println("Value with least Digits Number: " +values[index]);
        System.out.println("-------------------");
        System.out.println("Quantity of numbers containing only even digits: " +onlyEven);
        System.out.println("Quantity of numbers with an equal even and uneven digits: " +equality);
        System.out.println("-------------------");
        for (int i = 0; i < _increase.length; i++)
            if (_increase[i]) {
                System.out.println("A number in which the digits are in strict ascending order: " +values[i]);
                break;
            }
        for (int i = 0; i < differentNumbers.length; i++)
            if (differentNumbers[i]) {
                System.out.println("A number consisting only of distinct digits: " +values[i]);
                break;
            }
        System.out.println("-------------------");
            int c = 0;
        for (int i = 0; i < _palindrome.length; i++) {
//            System.out.println("palindrome[" +i+ "] = " +_palindrome[i]);
            if (_palindrome[i])
                c++;
        }
        if (c == 1)
            for (int i = 0; i < _palindrome.length; i++)
                if (_palindrome[i]) {
                    System.out.println("Number of palindrome: " +values[i]);
                    break;
                }
        int b = 0;
        if (c > 1)
            for(int i = 0; i < _palindrome.length; i++) {
                if (_palindrome[i])
                    b++;
                if (_palindrome[i] && b == 2) {
                    System.out.println("Number of palindrome: " + values[i]);
                    break;
                }
            }
        System.out.println("-------------------");
        System.out.println("Author: Enshin Danil Vladimirovich");
        System.out.println("Date and time of receipt of the task: 25.10.2021 00:42");
        System.out.println("Date and time of task completion: 29.10.2021 15:21");
    }
}
