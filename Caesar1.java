package caesar1;
import java.util.*;

public class Caesar1
{
    public static String Encrypt(String text , int key) //Caesar Encryption
    {
	String encText = "";
        for(int i=0;i<text.length();i++)
        {
            char ch = text.charAt(i);
            if(ch >= 'a' && ch <= 'z')
            {
                ch = (char)(ch+key);
                if(ch > 'z')
                {
                    ch = (char)(ch - 'z' + 'a' - 1);
                }
                encText += ch;
            }
            else if(ch >= 'A' && ch <= 'Z')
            {
                ch = (char)(ch+key);
                if(ch > 'Z')
                {
                    ch = (char)(ch - 'Z' + 'A' - 1);
                }
                encText += ch;
           }
           else
           {
                encText += ch;
           }
        }
        return encText;
    }

    public static String Decrypt(String text , int key) //Caesar Decryption
    {
        String decText = "";
        for(int i=0;i<text.length();i++)
        {
            char ch = text.charAt(i);
            if(ch >= 'a' && ch <= 'z')
            {
                ch = (char)(ch-key);
                if(ch < 'a')
                {
                    ch = (char)(ch + 'Z' - 'A' + 1);
                }
                decText += ch;
            }
            else if(ch >= 'A' && ch <= 'Z')
            {
                ch = (char)(ch-key);
                if(ch < 'A')
                {
                    ch = (char)(ch + 'Z' + 'A' + 1);
                }
                decText += ch;
            }
            else
            {
                decText += ch;
            }
        }
        return decText;
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("CAESAR CIPHER");
        System.out.println("Enter plain text ");
        String plText = in.nextLine();
        System.out.println("Enter key ");
        int key = in.nextInt();
        String cipherText = Encrypt(plText,key);
        String decipherText = Decrypt(cipherText,key);
        System.out.println("After Encryption :");
        System.out.println("Cipher text is "+cipherText);
        System.out.println("After Decryption :");
        System.out.println("Deciphered text is "+decipherText);
    }
       
}

 /*
Sample i/o
plain text : Mourina Murali
key : 3
cipher text : Prxulqd Pxudol
decipher text : Mourina Murali
*/
