import java.util.Arrays;

public class Main {
    private static int SIZE = 6;
    public static void main(String[] args) {
        firstTaskSubparagraph1();
        firstTaskSubparagraph2();
        secondTaskSubparagraph1();
        thirdTaskSubparagraph1();
    }

    private static void firstTaskSubparagraph1() {
        System.out.println("1.1 task");
        Student[] students = new Student[SIZE];
        students[0] = new Student("Danil", "Enshin", "Vladimirovich", 2001, 8, 22, "Voshod 9", "88005553535", "IVT", 3, "IV-923");
        students[1] = new Student("Vas9", "Qwf", "Vasilevich", 1998, 8, 22, "Voshod 9", "88005553535", "MRM", 2, "IP-025");
        students[2] = new Student("Dima", "qfgd", "Dmitrivich", 1000, 8, 22, "Voshod 9", "88005553535", "IVT", 3, "IV-923");
        students[3] = new Student("Vlad", "рпва", "Vladislavovich", 2001, 8, 22, "Voshod 9", "88005553535", "IVT", 3, "IV-923");
        students[4] = new Student("Maks", "ыва", "Maksimovich", 2004, 8, 22, "Voshod 9", "88005553535", "MRM", 2, "ABV-928");
        students[5] = new Student("Nilolay", "авыпр", "Nikolaevich", 2000, 8, 22, "Voshod 9", "88005553535", "ASQ", 1, "AS-146");
        System.out.println("a) список студентов заданного факультета (IVT):");
        for (int i = 0; i < SIZE; i++) {
            students[i].printFacultyTrue("IVT");
        }
        System.out.println("-----------------------");
        System.out.println("b)списки студентов для каждого факультета:");
        String[] faculty = new String[SIZE];
        for (int i = 0; i < SIZE; i++) {
            boolean coincidence = false;
            for (int j = 0; j < SIZE; j++) {
                if (students[i].getFaculty().equals(faculty[j])) {
                    coincidence = true;
                    break;
                }
            }
            if (coincidence)
                continue;
            else
                faculty[i] = students[i].getFaculty();
            for (int j = 0; j < SIZE; j++) {
                if (students[j].getFaculty().equals(faculty[i]))
                    System.out.println(students[j].toString());
            }
            System.out.println("Next faculty.");
        }
        System.out.println("-----------------------");
        System.out.println("b)списки студентов для каждого курса:");
        for (int i = 1; i < 6; i++)
            for (int j = 0; j < SIZE; j++)
                if (students[j].getCourse() == i)
                    System.out.println(students[j].toString());
        System.out.println("-----------------------");
        System.out.println("c) список студентов, родившихся после заданного года (2002):");
        for (int i = 0; i < SIZE; i++) {
            students[i].printYearTrue(2002);
        }
        System.out.println("-----------------------");
        System.out.println("d) список учебной группы (IV-923):");
        for (int i = 0; i < SIZE; i++) {
            students[i].printGroupTrue("IV-923");
        }
    }

    private static void firstTaskSubparagraph2() {
        System.out.println("\n1.2 task");
        Customer[] customers = new Customer[SIZE];
        customers[0] = new Customer("7123", "Danil", "Enshin", "Vladimirovich", "Voshod 9", 4, "7654");
        customers[1] = new Customer("7123", "Andrew", "Gdfsd", "Andreevich", "Voshod 9", 6, "124");
        customers[2] = new Customer("7123", "Dima", "Bsaff", "Dmitrivich", "Voshod 9", 9, "12456");
        customers[3] = new Customer("7123", "Maks", "Zfdh", "Maksimovichvich", "Voshod 9", 152, "7654");
        customers[4] = new Customer("7123", "Vladimir", "Hsada", "Vladimirovich", "Voshod 9", 563, "834");
        customers[5] = new Customer("7123", "Vladislav", "Cdgsg", "Vladislavovich", "Voshod 9", 356, "35235");
        System.out.println("a) список покупателей в алфавитном порядке :");
        System.out.println("Comparator по фамилии: ");
        Arrays.sort(customers, Customer.LastNameComparator);
        for (int i = 0; i < SIZE; i++) {
            System.out.println(customers[i].toString());
        }
        System.out.println("-----------------------");
        int minValue = 3;
        int maxValue = 10;
        System.out.println("b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.");
        System.out.println("Минимальное значение: " +minValue+ ". Максимальное значение: " +maxValue);
        for (int i = 0; i < SIZE; i++)
            if (customers[i].getCreditCardNumber() > minValue && customers[i].getCreditCardNumber() < maxValue)
                System.out.println(customers[i].toString());
    }

    private static void secondTaskSubparagraph1() {
        System.out.println("\n2.1 task");
        Fraction[] fractions = new Fraction[SIZE];
        fractions[0] = new Fraction(16,7);
        fractions[1] = new Fraction(12, 34);
        fractions[2] = new Fraction(4,57);
        fractions[3] = new Fraction(5, 15);
        fractions[4] = new Fraction(51,102);
        fractions[5] = new Fraction(456,654);
//        testAllFunctional(fractions);
//        System.out.println("-----------------------");
        sumFraction(fractions);
    }

    private static void testAllFunctional(Fraction[] fractions) {
        System.out.println("Тест сложения.");
        fractions[0].addition(8,18);
        System.out.println(fractions[0].toString());
        System.out.println("Тест вычитания.");
        fractions[1].subtraction(234, 435);
        System.out.println(fractions[1].toString());
        System.out.println("Тест деления.");
        fractions[2].divide(2,57);
        System.out.println(fractions[2].toString());
        System.out.println("Тест умножения.");
        fractions[3].multiplication(3,6);
        System.out.println(fractions[3].toString());
    }

    private static void sumFraction(Fraction[] fractions) {
        System.out.println("Modifies each even-indexed array element by adding the next element after it");
        for (int i = 0; i < fractions.length - 1; i++)
            if (i % 2 == 0) {
                fractions[i].addition(fractions[i + 1].getM(), fractions[i + 1].getN());
                System.out.println(fractions[i].toString());
            }
    }
    /*
    Полином - это многочлен какой-то степени, я выбрал для себя, что максимальная степень многочлена 3
    Чтобы сложить многочлен надо сложить коэффициенты перед одинаковыми степенями Х-са
    Коэффициентами у меня является дробь с инт числителем и инт знаменателем
    За отстойный код извиняюсь, но работает верно))
     */
    private static void thirdTaskSubparagraph1() {
        System.out.println("\n3.1 task");
        Fraction[] fractions = new Fraction[SIZE * 4];
        fractions[0] = new Fraction(16,7); //1
        fractions[1] = new Fraction(12, 34);
        fractions[2] = new Fraction(4,57);
        fractions[3] = new Fraction(5, 15);
        fractions[4] = new Fraction(51,102); //1
        fractions[5] = new Fraction(456,654);
        fractions[6] = new Fraction(16,7);
        fractions[7] = new Fraction(12, 34);
        fractions[8] = new Fraction(4,57); //1
        fractions[9] = new Fraction(5, 15);
        fractions[10] = new Fraction(51,102);
        fractions[11] = new Fraction(456,654);
        fractions[12] = new Fraction(16,7); //1
        fractions[13] = new Fraction(12, 34);
        fractions[14] = new Fraction(4,57);
        fractions[15] = new Fraction(5, 15);
        fractions[16] = new Fraction(51,102); //1
        fractions[17] = new Fraction(456,654);
        fractions[18] = new Fraction(16,7);
        fractions[19] = new Fraction(12, 34);
        fractions[20] = new Fraction(4,57); //1
        fractions[21] = new Fraction(5, 15);
        fractions[22] = new Fraction(51,102);
        fractions[23] = new Fraction(456,654);
        Polynomial[] polynomials = new Polynomial[SIZE];
        polynomials[0] = new Polynomial(fractions[0], fractions[1], fractions[2], fractions[3]);
        polynomials[1] = new Polynomial(fractions[4], fractions[5], fractions[6], fractions[7]);
        polynomials[2] = new Polynomial(fractions[8], fractions[9], fractions[10], fractions[11]);
        polynomials[3] = new Polynomial(fractions[12], fractions[13], fractions[14], fractions[15]);
        polynomials[4] = new Polynomial(fractions[16], fractions[17], fractions[18], fractions[19]);
        polynomials[5] = new Polynomial(fractions[20], fractions[21], fractions[22], fractions[23]);

        for (int i = 1; i < SIZE; i++) {
            polynomials[i].addPol(polynomials[i - 1]);
        }
        System.out.println("Коэф степени 3");
        System.out.println(polynomials[SIZE - 1].fraction1.toString());
        System.out.println("Коэф степени 2");
        System.out.println(polynomials[SIZE - 1].fraction2.toString());
        System.out.println("Коэф степени 1");
        System.out.println(polynomials[SIZE - 1].fraction3.toString());
        System.out.println("Коэф степени 0");
        System.out.println(polynomials[SIZE - 1].fraction4.toString());
    }
}
