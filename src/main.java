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
        
		String fileName = "classSchedule.txt";
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
	  System.out.println("\n");
	  PriorityQueueExample();
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
    public static void PriorityQueueExample() {
    	PriorityQueue<Class> ClassPriorityQueue = new PriorityQueue<>(5, (a,b) -> a.getLastFinishTime() - b.getLastFinishTime());
    	 Lecture n  = new Lecture("a",1,5);
    	 Lecture b  = new Lecture("b",4,9);
    	 Lecture c  = new Lecture("c",6,7);
    	 Lecture d  = new Lecture("d",2,4);
    	 
    	 Class classOne = new Class(1);
    	 classOne.addLecture(b);
    	 classOne.addLecture(n);
    	 
    	 Class classTwo = new Class(2);
    	 classTwo.addLecture(c);
    	 classTwo.addLecture(d);
    	 ClassPriorityQueue.add(classTwo);
    	 ClassPriorityQueue.add(classOne);
    	 while (!ClassPriorityQueue.isEmpty()) {
   		  
 		  	//lectureArray.add(LecturePriorityQueue.poll());
   		  Class x = ClassPriorityQueue.poll();
   		  System.out.print("Last fin time "+x.getLastFinishTime());
           x.printClasses();
         }
    }
    public static void IntervalPartitioning(List<Lecture> lectureArray) {

    	//TODO This comparator class isn't working all the time
    	
        PriorityQueue<Class> ClassPriorityQueue = new PriorityQueue<>(5, (a,b) -> a.getLastFinishTime() - b.getLastFinishTime());
        Lecture n  = lectureArray.get(0); 
        Class defaultInsertion = new Class(0);
        defaultInsertion.addLecture(n);
        ClassPriorityQueue.add(defaultInsertion);

        for(int j = 1; j<lectureArray.size(); j++) {
        	
//        	int s_j = lectureArray.get(j).getStartTime();
//        	int classPque = ClassPriorityQueue.peek().getLastFinishTime();
        	//Remove Class with min lastFinishTime
        	Class lastFinishTimeClass = ClassPriorityQueue.poll();	
        	if(lectureArray.get(j).getStartTime() >= lastFinishTimeClass.getLastFinishTime()) {
        		lastFinishTimeClass.addLecture(lectureArray.get(j));
        		ClassPriorityQueue.add(lastFinishTimeClass);  	
        	}
        	else {
        		ClassPriorityQueue.add(lastFinishTimeClass);
        		Class newClassAllocation = new Class(j);
        		newClassAllocation.addLecture(lectureArray.get(j));
        		ClassPriorityQueue.add(newClassAllocation);
        		ClassPriorityQueue.comparator();
        	}
		}
        
        
      System.out.println("About to print classes " + ClassPriorityQueue.size());
  	  while (!ClassPriorityQueue.isEmpty()) {
  		  Class x = ClassPriorityQueue.poll();
  		  System.out.print("Last fin time "+x.getLastFinishTime());
          x.printClasses();
        }
    }
    
}
