import java.util.ArrayList;
import java.util.List;

public class Class {
	
	private int classId;
	private int lastFinTime;
	private List<Lecture> lectureArray = new ArrayList<Lecture>();
	
	Class(int classId){
		this.classId=classId;
	}

	public void addLecture(Lecture item) {
		this.lectureArray.add(item);
		if(this.lastFinTime < item.getEndTime()) {
			this.lastFinTime = item.getEndTime();
		}
	}
	public int getLastFinishTime() {
		return this.lastFinTime;
	}
	public int getClassId() {
		return this.classId;
	}
	public void printClasses() {
		System.out.println(", class room #" + this.classId + " schedule");
		for(Lecture x:this.lectureArray) {
			System.out.println("\t("+ x.getClassName()+","+x.getStartTime()+","+x.getEndTime()+")");
		}
	}

}
