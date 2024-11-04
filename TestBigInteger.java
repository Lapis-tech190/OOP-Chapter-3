import java.math.BigInteger;
public class TestBigInteger {
    public static void main(String[] args) {
        BigInteger i1 = new BigInteger("123456789098765432155555");
        BigInteger i2 = new BigInteger("246801357983863598023235");


        BigInteger sum = i1.add(i2);
         System.out.println("The addition is: " + sum);

        BigInteger product = i1.multiply(i2);
         System.out.println("The multiplication is: " + product);
    }
}