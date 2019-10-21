package vignerecipher;
import java.util.*;

public class VignereCipher 
{
    public static String Encrypt(String text,String key)
    {
        String encMessage = "";
        int  kit =0;
        for(int mit=0;mit<text.length();mit++)
        {
            char ch = text.charAt(mit);
            if(ch == ' ')
            {
                encMessage += ch;
            }
            else
            {
                kit %= key.length();
                int c1 = text.charAt(mit) - 'a';
                int c2 = key.charAt(kit++) - 'a';
                char c3 = 'a';
                c3 += (c1+c2)%26;
                encMessage += c3;
            }
        }
        return encMessage;        
    }
    public static String Decrypt(String text,String key)
    {
        String decMessage = "";
        int kit = 0;
        for(int mit=0;mit<text.length();mit++)
        {
            char ch = text.charAt(mit);
            if(ch == ' ')
            {
                decMessage += ch;
            }
            else
            {
                kit %= key.length();
                int c1 = text.charAt(mit) - 'a';
                int c2 = key.charAt(kit++) - 'a';
                char c3 = 'a';
                c3 += (c1-c2+26)%26;
                decMessage += c3;
            }
        }
        return decMessage;
    }
    public static void main(String[] args) 
    {
       Scanner in = new Scanner(System.in);
       System.out.println("VIGNERE CIPHER");
       System.out.println("Enter plain text");
       String plText = in.nextLine();
       System.out.println("Enter key");
       String key = in.nextLine();
       String cipherText = Encrypt(plText,key);
       String decipherText = Decrypt(cipherText,key);
       System.out.println("After encryption ");
       System.out.println("Cipher text is : "+cipherText);
       System.out.println("After decryption ");
       System.out.println("Deciphered text is : "+decipherText);
    }
}

/*
Plain text show me the demo
key variety
cipher text nhfe qx rce umqh
deciphered text show me the demo
*/
