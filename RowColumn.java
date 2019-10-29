
package rowcolumn1;
import java.util.Scanner;

class Rowcolumn1
{
	public static String encrypt(String s,int col,int[] key)
	{
		int row=s.length()/col;
		if(s.length()%col!=0)
		{
			for(int in=s.length()%col;in<col;in++)
				s+='x';
			row++;
		}
		char[][] pmat=new char[row][col];
		int k=0;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				pmat[i][j]=s.charAt(k++);
			}
		}
		System.out.println("PLAIN TEXT MATRIX : ");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(pmat[i][j]+ "  ");
			}
			System.out.println();
		}
		String e="";
		for(int x=1;x<=col;x++)
		{
			for(int y=0;y<col;y++)
			{
				if(key[y]==x)
				{
					for(int z=0;z<row;z++)
					{
						e+=pmat[z][y];
					}	
				}
			}
		}
		return e;
	}

	public static String decrypt(String e,int col,int[] key)
	{
		int[] dkey=new int[col];
		int k=0;
		for(int p=1;p<=col;p++)
		{
			for(int q=0;q<col;q++)
			{
				if(key[q]==p)
					dkey[k++]=q+1;
			}
		}
		int row=e.length()/col;
		if(e.length()%col!=0)
		{
			row++;
		}
		char[][] dmat=new char[row][col];
		int l=0;
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				dmat[j][i]=e.charAt(l++);
			}
		}
		System.out.println("CIPHER TEXT MATRIX : ");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(dmat[i][j]+ "  ");
			}
			System.out.println();
		}
		String d="";
		for(int x=0;x<row;x++)
		{
			for(int y=0;y<col;y++)
			{
				for(int z=0;z<col;z++)
				{
					if(dkey[z]-1==y)
					{
						d+=dmat[x][z];
					}	
				}
			}
		}
		return d;
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String str;
		System.out.println("Enter a plain text : ");
		str=scanner.nextLine();
		int colcnt;
		System.out.println("Enter the column count : ");
		colcnt=scanner.nextInt();
		System.out.println("Enter key column : ");
		int[] key=new int[colcnt];
		for(int i=0;i<colcnt;i++)
		{
			key[i]=scanner.nextInt();
		}
		String en="";
		en=encrypt(str,colcnt,key);
		System.out.println("ENCRYPTION : "+en);
		String de="";
		de=decrypt(en,colcnt,key);
		System.out.println("DECRYPTION : "+de);
	}
}

/*Enter a plain text : 
symmetrickeycryptography
Enter the column count : 
6
Enter key column : 
6
1
4
2
5
3
PLAIN TEXT MATRIX : 
s  y  m  m  e  t  
r  i  c  k  e  y  
c  r  y  p  t  o  
g  r  a  p  h  y  
ENCRYPTION : yirrmkpptyoymcyaeethsrcg
CIPHER TEXT MATRIX : 
y  m  t  m  e  s  
i  k  y  c  e  r  
r  p  o  y  t  c  
r  p  y  a  h  g  
DECRYPTION : symmetrickeycryptography*/
