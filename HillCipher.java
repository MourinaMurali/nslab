/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hillcipher;
import java.util.Scanner;
import java.math.*;

public class HillCipher {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Plain Text: ");
        String message = sc.nextLine();
        //String message = "paymoremoney";
        
        int len = (int)Math.ceil(message.length() / 3);
        int plaintext[][] = new int[len][3];
        
        for(int i=0, k=0; i< len; i++) {
            for(int j=0; j< 3; j++, k++)
                plaintext[i][j] = (int)message.charAt(k) - 97;
        }
        
        System.out.println("\nEnter Key Value: ");
        int keyValue[][] = new int[3][3];
        for(int i=0; i< 3; i++) {
            for(int j=0; j< 3; j++)
                keyValue[i][j] = sc.nextInt();
        }
       
        /*
        int keyValue[][] =  {
                                {17, 17, 5},
                                {21, 18, 21},
                                {2, 2, 19}
                            };     
        */
        
        //Encryption
        System.out.println("\nEncrypted Code:");
        int encText[][] = new int[len][3];
        
        for(int i=0; i<len; i++){
            for(int j=0; j<3; j++){
                int sum = 0;
                
                for(int k=0; k<3; k++)
                   sum += plaintext[i][k] * keyValue[k][j];
                
                encText[i][j] = sum % 26;
                System.out.print((char)(encText[i][j] + 97));
            }
        }
        
        //Decryption
        //Find Determinant
        
        int det = keyValue[0][0]*((keyValue[1][1]*keyValue[2][2]) - (keyValue[2][1]*keyValue[1][2])) - 
                  keyValue[0][1]*((keyValue[1][0]*keyValue[2][2]) - (keyValue[1][2]*keyValue[2][0])) +
                  keyValue[0][2]*((keyValue[1][0]*keyValue[2][1]) - (keyValue[1][1]*keyValue[2][0]));
            
        if(det == 0){
            System.out.println("Inverse can't be found!");
            return;
        }
        
        //Find Multiplicative inverse
        //inv = x, x * det = 1 % 26
        
        BigInteger d = BigInteger.valueOf(det);
        BigInteger ts = BigInteger.valueOf(26);
        int inv = d.modInverse(ts).intValue();
        
        //Find Inverse of the keyValue
        int keyInverse[][] = new int[3][3];
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int val =   (
                                (
                                    (keyValue[(j + 1) % 3][(i + 1) % 3] * keyValue[(j + 2) % 3][(i + 2) % 3]) - 
                                    (keyValue[(j + 1) % 3][(i + 2) % 3] * keyValue[(j + 2) % 3][(i + 1) % 3])
                                ) * inv
                            ) % 26;
                if(val < 0)
                    val += 26;
                
                keyInverse[i][j] = val;
            }
        }
        
        //Decryption
        System.out.println("\n\nDecrypted Code:");
        
        for(int i=0; i<len; i++){
            for(int j=0; j<3; j++){
                int sum = 0;
                
                for(int k=0; k<3; k++)
                    sum += encText[i][k] * keyInverse[k][j];
                
                System.out.print((char)(sum % 26 + 97));
            }
        }
    }
}
