import java.io.File;
import java.io.IOException;
import java.util.*;

public class main {

	public static void main(String[] args) {
		
 
        // Need to do heap sort OR ADD TO A VECTORE

        // New pQueue of classrooms
		List<Lecture> lectureArray = new ArrayList<Lecture>();
	
		Comparator<Lecture> LectureStartTimeComparator = new Comparator<Lecture>() {
            @Override
            public int compare(Lecture one, Lecture two) {
                return one.getStartTime() - two.getStartTime();
            }
        };
        PriorityQueue<Lecture> LecturePriorityQueue = new PriorityQueue<>(LectureStartTimeComparator);
        
		String fileName = ReadUserInput();
		// Read from file populate pQueue
		try {
			File file = new File(fileName); 
			Scanner sc = new Scanner(file); 
				  
		    while (sc.hasNextLine()) {
		    	
		    	String newLine = sc.nextLine();
		    	
		    	String className = newLine.substring(1, 2);
		    	int startTime = Integer.parseInt(newLine.substring(4, 5));
		    	int endTime = Integer.parseInt(newLine.substring(7, 8));
		    	LecturePriorityQueue.add(new Lecture(className,startTime,endTime));
		    	
		    }
		      
		}
		catch(IOException e) {
			System.out.println("error, file name is incorrect reRun the program");
			
		}
		
		
		// Start working on priority queue...
		
	  // Print PQueue
	  while (!LecturePriorityQueue.isEmpty()) {
//		  System.out.println("sdasd");
		  	lectureArray.add(LecturePriorityQueue.poll());
            //System.out.println(ClassPriorityQueue.remove().getStartTime());
        }
	  IntervalPartitioning(lectureArray);
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
    public static void IntervalPartitioning(List<Lecture> lectureArray) {
    	// This lambda is the condition that restructures the pQueue

        Comparator<Class> ClassEndTimeComparator = new Comparator<Class>() {
            @Override
            public int compare(Class one, Class two) {
                return one.getEndTime() - two.getEndTime();
            }
        };
        PriorityQueue<Class> ClassPriorityQueue = new PriorityQueue<>(ClassEndTimeComparator);

//    	Sort lectures by start time so s(1)  s(2)  ...  s(n).
//    	cnew = new Classroom({1}, f(1))) // add a new classroom
        Lecture n  = lectureArray.remove(0); 
//    	d 1 // d = number of allocated classrooms
        int classRoom=1;
        Class defaultInsertion = new Class(classRoom,n.endTime);
//    	Q.insert(cnew)
        ClassPriorityQueue.add(defaultInsertion);

//    	for j = 2 to n {
        for(int j = 2; j<lectureArray.size(); j++) {
//    		c  Q.findMin() // c = classroom with the smallest lastFin
        	// If the queue is always sorted by smallest fin time
        	Class c = ClassPriorityQueue.
//    		if ( s(j) >= c.lastFin ) // c is compatible with j
//    		c.Lecs.insert(j)
//    		Q.increaseKey(c, f(j))
//    	else
//    		cnew = new Classroom({j}, f(j)))
//    		Q.insert(cnew)
//    		d
		}
    }
    
}
