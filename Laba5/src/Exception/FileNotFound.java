package Exception;

import java.io.*;

public class FileNotFound {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
			try {
				//PrintStream out = new PrintStream(new File("C:\\data.txt"));
				PrintStream out = new PrintStream(new File(".\\data.txt"));
				out.printf("conversion from decimal number system to quaternary:\n");
				for (int k = 1; k < 20; k++)
				{
					int dec = k;
					int dec_2 = dec;
					int i = 0;
					int j = 0;
					char[] str;
					str = new char[8];
					char[] fourth;
					fourth = new char[8];
					int rem = 0;
					while (dec_2 != 0)
					{
					if ((dec_2 % 8) == 4) {dec+=3*Math.pow(4.0,i);}
					else {if ((dec_2 % 8) == 5) {dec +=1*Math.pow(4.0,i);}
							else if ((dec_2 % 8) == 6) {dec -=1*Math.pow(4.0,i);}
								else {if ((dec_2 % 8) == 7) dec -= 3*Math.pow(4.0,i);}}
						dec_2/=4;
						i++;
					}
					i = 0;
					while (dec != 0)
					{
						rem = dec % 4;
						str[i] = (char)(rem+48);
						dec /= 4;
						i++;
					}
					out.printf("from %d in decimal to ", k);
					for (j = 0; j < i; j++)
					{
						fourth[j]= str[i-j-1];
						out.printf("%c", fourth[j]);
					}
					out.printf(" in reflex fourth code\n");
					
				}
				//out.printf("");
				out.close();
			}
			catch (FileNotFoundException ex) {
				System.out.println("Writing error, get message:");
				System.out.println(ex.getMessage());
			}
			catch (IOException ex) {
				System.out.println("Writing error, get message:");
				System.out.println(ex.getMessage());
			}
			finally {
				try 
				{
					FileReader reader = new FileReader(".\\data.txt");
					int c;
					while ((c = reader.read()) != -1) {
						System.out.print((char)c);
					}
				}
				catch (FileNotFoundException ex) {
					System.out.println("Reading error, get message:");
					System.out.println(ex.getMessage());
				}
				catch (IOException ex) {
					System.out.println("Reading error, get message:");
					System.out.println(ex.getMessage());
				}
				}
	}

}
