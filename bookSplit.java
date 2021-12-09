/*** COSC 2100 –Fall2020
 * Assignment#1
 * Read a text file and split the text file into different text files with a certain number of lines per file
 * @author Max Steffen
 * */

package wk01.Assignments;
import java.util.*;
import java.io.*;

public class bookSplit {

	public static void main(String[] args) throws FileNotFoundException 
	{
		int count = 0; //counts how many lines are in the given file
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file name (without .txt)");	 
		String fileName = scan.next();		//acquires the wanted file from the user
		Scanner testFile = new Scanner(new File(fileName + ".txt"));	//file used to gather count variable data
		Scanner scanFile = new Scanner(new File(fileName + ".txt"));	//file used for the rest of the program
		System.out.println("How many lines do you want in each split file?");
		int lines = scan.nextInt();		//saves how many lines are wanted in each new file
		
		while(testFile.hasNextLine())		//makes the count variable hold the 
		{									//number of lines in the given text file
			testFile.nextLine();
			count++;
		}

		int remainder = count%lines;		//saves the remainder when dividing the number of lines by the number of wanted lines
		count = count - remainder;		//removes the remainder gained above from the count variable
		 		
		System.out.println("Files Generated:");
		  int lineCounter = 1;  // helps each file to have the intended number of lines
		for(int fileAmount = 1; fileAmount <= count/lines; fileAmount++) //for loop makes the new files (NOTE: file amount may be off by 1, this error is fixed in line # )

		{
			File temp = new File(fileName + "-" + fileAmount + ".txt");
			PrintWriter newFiles = new PrintWriter(temp);
				while(lineCounter<=lines)		//while loop adds the needed lines to each file
				{
					newFiles.println(scanFile.nextLine());
					lineCounter ++;
				}
				newFiles.close();

			lineCounter = 1;		//resets counter to 1
			System.out.println(temp);
		}
		
		
		if(remainder>0)		//takes care of remainder file if count%lines != 0 in line 30
		{
			
			File temp = new File(fileName + "-" + ((count/lines)+1) + ".txt");
			PrintWriter newFiles = new PrintWriter(temp);
			while(lineCounter<=remainder)
			{
				newFiles.println(scanFile.nextLine());
				lineCounter ++;
			}
			newFiles.close();

			lineCounter = 1;
			System.out.println(temp);
				

		}
		
		System.out.println("**bookSplit completed successfully**");

		
	}

}
