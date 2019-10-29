
package rsa1;
import java.math.BigInteger;
import java.util.*;

public class Rsa1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Prime number-p: ");
        BigInteger p = BigInteger.valueOf(sc.nextInt());
        //BigInteger p = BigInteger.valueOf(17);
        
        System.out.println("Prime number-q: ");
        BigInteger q = BigInteger.valueOf(sc.nextInt());
        //BigInteger q = BigInteger.valueOf(11);
        
        //n = p*q
        BigInteger n = p.multiply(q);
        System.out.println("n: " + n);
        
        //phi = (p-1)*(q-1)
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("phi: " + phi);
        
        System.out.println("Prime number-e: ");
        BigInteger e = BigInteger.valueOf(sc.nextInt());
        //BigInteger e = BigInteger.valueOf(7);
        
        //d = x, x * e = 1 % phi
        BigInteger d = e.modInverse(phi);
        System.out.println("d: " + d);
        
        System.out.println("Message: ");
        BigInteger m = BigInteger.valueOf(sc.nextInt());
        //BigInteger m = BigInteger.valueOf(88);
        
        //Encryption
        BigInteger val = m . modPow(e, n);
        System.out.println("Encrypted Message: " + val);
        
        //Decryption
        val = val . modPow(d, n);
        System.out.println("Decrypted Message: " + val);
    }
}
