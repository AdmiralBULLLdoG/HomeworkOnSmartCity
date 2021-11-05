public class Fraction {
    private int m;
    private  int n;

    @Override
    public String toString() {
        return "Fraction{" +
                "m=" + m +
                ", n=" + n +
                '}';
    }

    public Fraction(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    void multiplication(int value1, int value2) {
        this.m *= value1;
        this.n *= value2;
        int nod = gcd(this.m, this.n);
        this.m /= nod;
        this.n /= nod;
//        System.out.println("Числитель: " +this.m+ " Знаменатель: " +this.n);
    }

    void divide(int value1, int value2) {
        this.m *= value2;
        this.n *= value1;
        int nod = gcd(this.m, this.n);
        this.m /= nod;
        this.n /= nod;
//        System.out.println("Числитель: " +this.m+ " Знаменатель: " +this.n);
    }
//System.out.println("Числитель = "+m+ " Знаменатель равен ="+n+ " Делитель = " +value+ " Результат = " +(this.m / value / this.n));
    void addition(int value1, int value2) {
        if (value2 == this.n) {
            this.m += value1;
            int nod = gcd(this.m, this.n);
            this.m /= nod;
            this.n /= nod;
//            System.out.println("Числитель: " + this.m + " Знаменатель: " + this.n);
        }
        else if (value2 % this.n == 0) {
            this.m = this.m * (value2 / this.n);
            this.n = value2;
            this.m += value1;
            int nod = gcd(this.m, this.n);
            this.m /= nod;
            this.n /= nod;
//            System.out.println("Числитель: " +this.m+ " Знаменатель: " +this.n);
        }
        else if (this.n % value2 == 0) {
            value1 = value1 * (this.n / value2);
            this.m += value1;
            int nod = gcd(this.m, this.n);
            this.m /= nod;
            this.n /= nod;
//            System.out.println("Числитель: " +this.m+ " Знаменатель: " +this.n);
        }
        else {
            int nok = lcm(this.n, value2);
            this.m = this.m * (nok / this.n);
            this.n = nok;
            value1 = value1 * (nok / value2);
            this.m += value1;
            int nod = gcd(this.m, this.n);
            this.m /= nod;
            this.n /= nod;
//            System.out.println("Числитель: " +this.m+ " Знаменатель: " +this.n);
        }
    }

    void subtraction(int value1, int value2) {
        if (value2 == this.n) {
            this.m -= value1;
            int nod = gcd(this.m, this.n);
            this.m /= nod;
            this.n /= nod;
//            System.out.println("Числитель: " + this.m + " Знаменатель: " + this.n);
        }
        else if (value2 % this.n == 0) {
            this.m = this.m * (value2 / this.n);
            this.n = value2;
            this.m -= value1;
            int nod = gcd(this.m, this.n);
            this.m /= nod;
            this.n /= nod;
//            System.out.println("Числитель: " +this.m+ " Знаменатель: " +this.n);
        }
        else if (this.n % value2 == 0) {
            value1 = value1 * (this.n / value2);
            this.m -= value1;
            int nod = gcd(this.m, this.n);
            this.m /= nod;
            this.n /= nod;
//            System.out.println("Числитель: " +this.m+ " Знаменатель: " +this.n);
        }
        else {
            int nok = lcm(this.n, value2);
            this.m = this.m * (nok / this.n);
            this.n = nok;
            value1 = value1 * (nok / value2);
            this.m -= value1;
            int nod = gcd(this.m, this.n);
            this.m /= nod;
            this.n /= nod;
//            System.out.println("Числитель: " +this.m+ " Знаменатель: " +this.n);
        }
    }

    //НОД
    int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
    //НОК
    int lcm(int a,int b){
        return a / gcd(a,b) * b;
    }
}
