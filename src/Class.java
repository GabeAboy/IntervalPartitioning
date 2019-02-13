
public class Class {
	String className;
	int startTime;
	int endTime;
	
	Class(String className,int startTime, int endTime){
		this.className=className;
		this.startTime=startTime;
		this.endTime=endTime;
	}
	
	String getClassName() {
		return this.className;
	}
	int getStartTime() {
		return this.startTime;
	}
	int getEndTime() {
		return this.endTime;
	}

}
