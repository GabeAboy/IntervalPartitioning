import java.util.ArrayList;
import java.util.List;

public class Class {
	
	private int classId;
	private List<Lecture> lectureArray = new ArrayList();
	
	Class(int classId){
		this.classId=classId;
	}

	public void addLecture(Lecture item) {
		this.lectureArray.add(item);
	}
	public int getLastFinishTime() {
		int max=0;
		for(Lecture x: this.lectureArray) {
			if(max<x.getEndTime()) {
				max=x.getEndTime();
			}
		}
		return max;
	}
	public void printClasses() {
		System.out.println("Class Room " + this.classId + " Schedule");
		for(Lecture x:this.lectureArray) {
			System.out.println("\t("+ x.getClassName()+","+x.getStartTime()+","+x.getEndTime()+")");
		}
	}

}
