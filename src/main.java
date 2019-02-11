import java.io.File;
import java.io.IOException;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = ReadUserInput();
		try {
			File file = 
				      new File(fileName); 
				    Scanner sc = new Scanner(file); 
				  
				    while (sc.hasNextLine()) 
				      System.out.println(sc.nextLine());
		}catch(IOException e) {
			System.out.println("error");
		}
		System.out.println(fileName);
	}
	// String function should read input and return string for java open file
    public static String ReadUserInput() {
    	Scanner reader = new Scanner(System.in);
    	// Default value, that is never used because catch statement
    	String userInput="";
    	System.out.println("Enter a Number: ");
    	try {
    		// Try to open file here
    		userInput = reader.nextLine();
    		
    	}catch(InputMismatchException a) {
    		
    		System.out.println("Please enter an existing file name");
    		ReadUserInput();
    	}
    	
    	reader.close();
    	return userInput;
    }
}
