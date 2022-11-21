package calculator.models;

public class Operand {

    private Complex value = new Complex(0, 0);

    public double getReal() {
        return value.real();
    }

    public void setReal(double real) {
        value.set_real(real);
    }

    public double getImag() {
        return value.imag();
    }

    public void setImag(double imag) {
        value.set_imag(imag);
    }

    public Complex getValue() {
        return value;
    }

}
