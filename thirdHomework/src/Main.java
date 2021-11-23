import java.util.Arrays;

public class Main {
    private static final int SIZE = 7;

    public static void main(String[] args) {
        String text = "Я, Еньшин Данил Владимирович, обучаюсь на кафедре Smart City";
        System.out.println("Task1: ");
        task1sub1(text);
        task1sub2(text);
        System.out.println("Task2: ");
        task2sub2();
        System.out.println("Task 3: ");
        task3sub1and2();
    }

    private static void task1sub1(String text) {
        String[] words = text.split(", | ");
//        for (String word : words) {
//            System.out.println(word);
//        }
        int numberLetters = 3;
        String symbol = "*";
        for (String word: words) {
            String tmp;
            if (word.length() < 3) {
                System.out.println(word);
                continue;
            }
            tmp = word.substring(0, numberLetters - 1);
            tmp = tmp.concat(symbol);
            tmp = tmp.concat(word.substring(numberLetters));
            System.out.println(tmp);
        }
    }

    private static void task1sub2(String text) {
        String[] lines = text.split("\\n");
        for (String line : lines) {
            printSymbols(line);
            printSymbolNumbers(line);
        }
    }

    private static final String FORMAT = "%5s";

    private static void printSymbols(String line) {
        for (char symbol : line.toCharArray()) {
            System.out.printf(FORMAT, symbol);
        }
        System.out.println();
    }

    private static void printSymbolNumbers(String line) {
        for (char symbol : line.toCharArray()) {
            System.out.printf(FORMAT, (int)symbol);
        }
        System.out.println();
    }

    private static void task2sub2() { // сделал без классов(т.к эта задача решается легче и меньше кода писать)
        String text = "Это бы означало,   что производный тип будет\n" +
                "точно такого же типа, как и базовый класс, так как они имеют одинаковый интерфейс.\n" +
                "В результате вы можете свободно заменять объекты базового класса объектами производных\n" +
                "классов. Можно говорить о полной замене, и это часто называется принципом\n" +
                "замены.";
        String[] sentence = text.split("[.!?]"); // сплит по предложениям
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].trim();
            System.out.println(sentence[i]);
        }
        System.out.println();
        StringBuilder[] withoutWhitespace = new StringBuilder[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            withoutWhitespace[i] = new StringBuilder();
            String[] whitespace = sentence[i].split("\\s+"); // сплит по whitespace
            for (String s : whitespace)
                withoutWhitespace[i].append(s).append(" ");
            System.out.println(withoutWhitespace[i]);
        }
        System.out.println();
        String[] inAscendingOrder = new String[withoutWhitespace.length];
        for (int i = 0; i < inAscendingOrder.length; i++)
            inAscendingOrder[i] = withoutWhitespace[i].toString();
        Arrays.sort(inAscendingOrder, (x, y) -> x.split(" ").length - y.split(" ").length); //sort по возрастанию кол-ва слов
        for (String s : inAscendingOrder)
            System.out.println(s);
    }

    private static void task3sub1and2() {
        String text = "qwe rty yui op[] asd fgh jkl zxc vbn m,. qwe rtyo";
        System.out.println("Длина текста: " +text.length()); // 7*7=49
        char[] charText = text.toCharArray();
        String[][] matrix = new String[SIZE][SIZE];
        int k = 0;
        System.out.println("Исходная матрица: ");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = String.valueOf(charText[k]);
                k++;
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Матрица повернутая на 90: ");
        String[][] matrix1 = rotation(matrix);
        System.out.println();
        System.out.println("Матрица с обменом строк: ");
        String[][] matrix2 = swapLine(matrix1);
        System.out.println();
        System.out.println("Матрица с обменом столбцов: ");
        String[][] matrix3 = swapColumn(matrix2);
        System.out.println();
        System.out.println("Обход матрицы по спирали: ");
        String[] line = spiral(matrix3);

        int dif = 0;
        int di = 0;
        int dj = 0;
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = 1; j < line.length; j++) {
                if (i == j)
                    continue;
                if (line[i].equals(line[j]) && dif < Math.abs(j - i)) {
                    dif = Math.abs(j - i);
                    di = i;
                    dj = j;
                }
            }
        }
        System.out.println();
        System.out.println("Максимальная длина подстроки: " +dif);
        System.out.println("Индекс первой встречи символа: " +di);
        System.out.println("Индекс последней встречи символа: " +dj);
        StringBuilder LLine = new StringBuilder();
        for (String s : line)
            LLine.append(s);
        LLine.delete(di, (dj + 1));
        System.out.println("Получившаяся строка: " +LLine);
    }

    private static String[] spiral(String[][] matrix3) {
        String[] line = new String[SIZE * SIZE];
        int row = 0;
        int col = 0;
        int dx = 1;
        int dy = 0;
        int dirChanges = 0;
        int visits = SIZE;

        for (int i = 0; i < SIZE * SIZE; i++) {
            line[i] = matrix3[row][col];
            if (--visits == 0) {
                visits = SIZE * (dirChanges % 2) +
                        SIZE * ((dirChanges + 1) % 2) -
                        (dirChanges / 2 - 1) - 2;
                int temp = dx;
                dx = -dy;
                dy = temp;
                dirChanges++;
            }
            col += dx;
            row += dy;
        }
        for (int i = 0; i < SIZE * SIZE; i++) {
            System.out.print(line[i]);
        }
        return line;
    }

    private static String[][] swapColumn(String[][] matrix2) {
        String[][] matrix3 = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (SIZE - j == 1) {
                    matrix3[i][j] = matrix2[i][j];
                    System.out.print(matrix3[i][j] + " ");
                    continue;
                }
                if (j % 2 == 1)
                    matrix3[i][j] = matrix2[i][j - 1];
                else
                    matrix3[i][j] = matrix2[i][j + 1]; // 1-й столбец таблицы меняется местами со 2-м, 3-й — с 4-м и т. д
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
        return matrix3;
    }

    private static String[][] swapLine(String[][] matrix1) {
        String[][] matrix2 = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix2[i][j] = matrix1[SIZE - 1 - i][j]; // 1-я строка таблицы меняется местами с последней, 2-я — с предпоследней и т. д
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        return matrix2;
    }

    private static String[][] rotation(String[][] matrix) {
        String[][] matrix1 = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix1[i][j] = matrix[SIZE - 1 - j][i]; // поворот на 90
                System.out.print(matrix1[i][j]+ " ");
            }
            System.out.println();
        }
        return matrix1;
    }
}
