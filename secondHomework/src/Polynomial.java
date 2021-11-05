public class Polynomial {
    Fraction fraction1;
    Fraction fraction2;
    Fraction fraction3;
    Fraction fraction4;


    public Polynomial(Fraction fraction1, Fraction fraction2, Fraction fraction3, Fraction fraction4) {
        this.fraction1 = fraction1;
        this.fraction2 = fraction2;
        this.fraction3 = fraction3;
        this.fraction4 = fraction4;
    }

    public Fraction getFraction1() {
        return fraction1;
    }

    public void setFraction1(Fraction fraction1) {
        this.fraction1 = fraction1;
    }

    public Fraction getFraction2() {
        return fraction2;
    }

    public void setFraction2(Fraction fraction2) {
        this.fraction2 = fraction2;
    }

    public Fraction getFraction3() {
        return fraction3;
    }

    public void setFraction3(Fraction fraction3) {
        this.fraction3 = fraction3;
    }

    public Fraction getFraction4() {
        return fraction4;
    }

    public void setFraction4(Fraction fraction4) {
        this.fraction4 = fraction4;
    }

    void addPol(Polynomial obj) {
        fraction1.addition(obj.fraction1.getM(), obj.fraction1.getN());
        fraction2.addition(obj.fraction2.getM(), obj.fraction2.getN());
        fraction3.addition(obj.fraction3.getM(), obj.fraction3.getN());
        fraction4.addition(obj.fraction4.getM(), obj.fraction4.getN());
    }
}
