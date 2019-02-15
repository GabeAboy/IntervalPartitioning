import java.util.ArrayList;
import java.util.List;

public class Class {
	int classRoomUniqueId;
	int endTime;
	List<Lecture> lectureArray;
	
	
	Class(int classRoomUniqueId,int endTime){
		this.classRoomUniqueId=classRoomUniqueId;
		this.lectureArray  = new ArrayList<Lecture>();
		this.endTime=endTime;
	}
	
	int getClassRoomID() {
		return this.classRoomUniqueId;
	}
	
	int getEndTime() {
		return this.endTime;
	}
	
	public void addClass() {
		
	}
	public void setEndTime() {
		
	}

}
