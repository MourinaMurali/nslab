/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehellman;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class DiffieHellman{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Prime number: ");
        BigInteger p = BigInteger.valueOf(sc.nextInt());
        //BigInteger p = BigInteger.valueOf(353);
        
        //Generate a primitive root for prime number
        BigInteger alpha = BigInteger.valueOf(1);
        for (int i=1; i < p.intValue(); i++) {
            Set<BigInteger> set = new HashSet<BigInteger>();

            for (int j=1; j < p.intValue(); j++) {
                BigInteger x = new BigInteger(Integer.toString(i));
                BigInteger y = new BigInteger(Integer.toString(j));
                
                //tmp= (i^j) % p
                BigInteger tmp = x.modPow(y, p); 
                set.add(tmp);
            }
            
            if(set.size() == p.intValue() - 1){
                alpha = BigInteger.valueOf(i);
                System.out.println("Primitive root: " + alpha);
                break;
            }
        }

        //Generate keys for A
        //pbA = (alpha ^ prA) % p
        
        System.out.println("\nPrivate key-A: ");
        BigInteger prA = BigInteger.valueOf(sc.nextInt());
        //BigInteger prA = BigInteger.valueOf(97);
        BigInteger pbA = alpha.modPow(prA, p);
        System.out.println("Public key-A: " + pbA);
        
        //Generate keys for B
        //pbB = (alpha ^ prB) % p
        
        System.out.println("\nPrivate key-B: ");
        BigInteger prB = BigInteger.valueOf(sc.nextInt());
        //BigInteger prB = BigInteger.valueOf(233);
        BigInteger pbB = alpha.modPow(prB, p);
        System.out.println("Public key-B: " + pbB);

        //sharedKey = (pbB ^ prA) % p
        BigInteger sharedKey = pbB.modPow(prA, p);
        System.out.println("\nShared key generated at A: " + sharedKey);
        
        //sharedKey = (pbA ^ prB) % p
        sharedKey = pbA.modPow(prB, p);
        System.out.println("Shared key generated at B: " + sharedKey);
    }
}
