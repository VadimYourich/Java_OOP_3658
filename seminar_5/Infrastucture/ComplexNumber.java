package seminar_5.Infrastucture;

/**
 * Класс комлексное число
 */

public class ComplexNumber {
    double real;
    double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    /**
     * Метод сложения комплесных чисел
     */

    public ComplexNumber addition(ComplexNumber a) {
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = real + real1;
        double newImaginary = imaginary + imaginary1;
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Метод вычитания комплесных чисел
     */

    public ComplexNumber subtraction(ComplexNumber a) {
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = real - real1;
        double newImaginary = imaginary - imaginary1;
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Метод умножения комплесных чисел
     */

    public ComplexNumber multiplication(ComplexNumber a) {
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = real*real1 - imaginary *imaginary1;
        double newImaginary = imaginary *real1 + real*imaginary1;
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Метод деления комплесных чисел
     */

    public ComplexNumber division(ComplexNumber a) {
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = (real*real1 + imaginary *imaginary1)/(real1*real1 + imaginary1*imaginary1);
        double newImaginary = (imaginary *real1 - real*imaginary1)/(real1*real1 + imaginary1*imaginary1);
        return new ComplexNumber(newReal,newImaginary);
    }

    @Override
    public String toString() {
        StringBuilder complex = new StringBuilder();
        if(imaginary > 0){
            complex.append("(").append(real).append(" + ").append(imaginary).append("i").append(")");
        }else if(imaginary < 0){
            complex.append("(").append(real).append(imaginary).append("i").append(")");
        }else{
            complex.append(real);
        }
        return complex.toString();
    }
}
