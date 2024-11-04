public class MyComplex {
    public static void main(String[] args) { MyComplex complex1 = new MyComplex(3.0, 4.0);
        MyComplex complex2 = new MyComplex(1.0, 2.0);

        System.out.println("complex1: " + complex1);
        System.out.println("complex2: " + complex2);

        System.out.println("Magnitude of complex1: " + complex1.magnitude());

        System.out.println("complex1 + complex2: " + complex1.addNew(complex2));
        System.out.println("complex1 - complex2: " + complex1.subtractNew(complex2));

        System.out.println("Is complex1 real? " + complex1.isReal());
        System.out.println("Is complex2 imaginary? " + complex2.isImaginary());
    }



    double real;
    double image;

    public MyComplex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImage() {
        return image;
    }

    public void setImage(double image) {
        this.image = image;
    }

    public void setValue(double real, double image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public String toString() {
        return "(" + real + " + " + image + "i)";
    }

    public boolean isReal() {
        return image == 0;
    }

    public boolean isImaginary() {
        return real == 0;
    }

    public boolean equals(double real, double image) {
        return this.real == real && this.image == image;
    }

    public boolean equals(MyComplex another) {
        return this.real == another.real && this.image == another.image;
    }

    public double magnitude() {
        return Math.sqrt(real * real + image * image);
    }

    public MyComplex addInto(MyComplex right) {
        this.real += right.real;
        this.image += right.image;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.real, this.image + right.image);
    }

    public MyComplex subtractInto(MyComplex right) {
        this.real -= right.real;
        this.image -= right.image;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.real, this.image - right.image);
    }
}
