package custom_sorting;

import java.util.Comparator;

import sdbs.Student;

public class SortStudentByMarks implements Comparator<Student> {

	@Override
	
	public int compare(Student x, Student y) {
		
		return x.getmarks()-y.getmarks();
	}

	
	
}
