import java.io.File;
import java.io.IOException;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//This could be priority queue instead of array, lets get there now
		List<Class> classArray = new ArrayList<Class>();
        Comparator<Class> stringLengthComparator = new Comparator<Class>() {
            @Override
            public int compare(Class one, Class two) {
                return one.getEndTime() - two.getEndTime();
            }
        };
        PriorityQueue<Class> ClassPriorityQueue = new PriorityQueue<>(stringLengthComparator);
//		PriorityQueue<String> pQueue = new PriorityQueue<String>(); 
		  

		String fileName = ReadUserInput();
		try {
			File file = new File(fileName); 
			Scanner sc = new Scanner(file); 
				  
		    while (sc.hasNextLine()) {
		    	
		    	String newLine = sc.nextLine();
		    	
		    	String className = newLine.substring(1, 2);
		    	int startTime = Integer.parseInt(newLine.substring(4, 5));
		    	int endTime = Integer.parseInt(newLine.substring(7, 8));
		    	ClassPriorityQueue.add(new Class(className,startTime,endTime));
		    	
		    }
		      
		}
		catch(IOException e) {
			System.out.println("error, file name is incorrect reRun the program");
			
		}	
		// Start working on priority queue...
		
		  while (!ClassPriorityQueue.isEmpty()) {
	            System.out.println(ClassPriorityQueue.remove().getClassName());
	        }
	}
	// String function should read input and return string for java open file
    public static String ReadUserInput() {
    	Scanner reader = new Scanner(System.in);
    	// Default value, that is never used because catch statement
    	String userInput="";
    	System.out.println("Enter your file name: ");
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
