import java.io.File;
import java.io.IOException;
import java.util.*;

public class IntervalPartitioning {
	public static void main(String[] args) {

		// Declare lecture array, use Comparator to run a min heap sort on Lecture start time
		List<Lecture> lectureArray = new ArrayList<Lecture>();
		Comparator<Lecture> LectureStartTimeComparator = new Comparator<Lecture>() {
            public int compare(Lecture one, Lecture two) {
                return one.getStartTime() - two.getStartTime();
            }
        };
        PriorityQueue<Lecture> LecturePriorityQueue = new PriorityQueue<>(LectureStartTimeComparator);     
		
        String fileName = ReadUserInput();
		try {
			File file = new File(fileName); 
			@SuppressWarnings("resource")
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
		// Run "heap sort" using the priority queue, popping with poll removes the minimum start time lecture
		// The reason why I did this was to not create my own sort. I could have used array sort with another Comparator.
	  while (!LecturePriorityQueue.isEmpty()) {
		  	lectureArray.add(LecturePriorityQueue.poll());
      }
	  
	  // Execute interval scheduling on the sorted by minimum start time array
	  PriorityQueue<Class> ClassPriorityQueue = IntervalPartitioning(lectureArray);
	  
	  // Print results
	  System.out.println("About to print " + ClassPriorityQueue.size()+" classes");
	  while (!ClassPriorityQueue.isEmpty()) {
		  Class lowestFinishTimeClass = ClassPriorityQueue.poll();
		  System.out.print("Class last finish time "+lowestFinishTimeClass.getLastFinishTime());
		  lowestFinishTimeClass.printClasses();
      }
	}

	// TODO this read from file doesn't take into account multiple digit numbers
	// This is a fault of the implementation, but doesn't not compromise the algorithm results 
    public static String ReadUserInput() {
    	Scanner reader = new Scanner(System.in);
    	String userInput="";
    	System.out.println("Enter your file name: ");
    	try {
    		userInput = reader.nextLine();
    		
    	}catch(InputMismatchException a) {		
    		System.out.println("Please enter an existing file name");
    		ReadUserInput();
    	}
    	reader.close();
    	return userInput;
    }
    
    // Implementation of Interval Partitioning using the java library priorityQueue, and its Comparator parameter to maintain
    // a minimumLastFinish time as the head of the queue.
    public static PriorityQueue<Class> IntervalPartitioning(List<Lecture> lectureArray) {
    	Comparator<Class> ClassEndTimeComparator = new Comparator<Class>() {
            public int compare(Class one, Class two) {
                return one.getLastFinishTime() - two.getLastFinishTime();
            }
        };
        
        PriorityQueue<Class> ClassPriorityQueue = new PriorityQueue<>(ClassEndTimeComparator);
        Lecture minStartTimeLecture  = lectureArray.get(0); 
        Class defaultInsertionClass = new Class(1);
        defaultInsertionClass.addLecture(minStartTimeLecture);
        ClassPriorityQueue.add(defaultInsertionClass);

        for(int j = 1; j<lectureArray.size(); j++) {
        	Class lastFinishTimeClass = ClassPriorityQueue.poll();	
        	if(lectureArray.get(j).getStartTime() >= lastFinishTimeClass.getLastFinishTime()) {
        		lastFinishTimeClass.addLecture(lectureArray.get(j));
        		ClassPriorityQueue.add(lastFinishTimeClass);  	
        	}
        	else {
        		ClassPriorityQueue.add(lastFinishTimeClass);
        		Class newClassAllocation = new Class(j+1);
        		newClassAllocation.addLecture(lectureArray.get(j));
        		ClassPriorityQueue.add(newClassAllocation);
        		ClassPriorityQueue.comparator();
        	}
		}
        return ClassPriorityQueue;
    }
}
