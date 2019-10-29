
package railfencecipher;
import java.util.*;

 class RailFenceCipher
{
    public static String Encrypt(String plainText,int depth)
    {
        int len=plainText.length();
        int c=len/depth;
        char mat[][]=new char[depth][c];
        int k=0;
        String cipherText="";
        for(int i=0;i< c;i++)
        {
           for(int j=0;j< depth;j++)
           {
                if(k!=len)
                    mat[j][i]=plainText.charAt(k++);
                else
                    mat[j][i]='X';
           }
        }
        for(int i=0;i< depth;i++)
        {
            for(int j=0;j< c;j++)
            {
                cipherText+=mat[i][j];
            }
        }
        return cipherText;
    }
      
    public static String Decrypt(String cipherText,int depth)
    {
        int len=cipherText.length();
        int c=len/depth;
        char mat[][]=new char[depth][c];
        int k=0;
        String plainText="";
        for(int i=0;i< depth;i++)
        {
            for(int j=0;j< c;j++)
            {
                   mat[i][j]=cipherText.charAt(k++);
            }
        }
        for(int i=0;i< c;i++)
        {
            for(int j=0;j< depth;j++)
            {
                   plainText+=mat[j][i];
            }
        }
   
  return plainText;
 }
 public static void main(String args[])throws Exception
 {
    Scanner scn=new Scanner(System.in);
    System.out.println("Enter plain text:");
    String plainText=scn.nextLine();
    System.out.println("Enter depth for Encryption:");
    int depth=scn.nextInt();
    String cipherText=Encrypt(plainText,depth);
    System.out.println("Encrypted text is:\n"+cipherText);
    String decryptedText=Decrypt(cipherText, depth);
    System.out.println("Decrypted text is:\n"+decryptedText);
   
 }
}

/*
Enter plain text:
railfencecipher
Enter depth for Encryption:
3
Encrypted text is:
rlnchafcieieepr
Decrypted text is:
railfencecipher
*/
