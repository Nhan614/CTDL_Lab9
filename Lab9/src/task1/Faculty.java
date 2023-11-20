package task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses = new ArrayList<>();

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		int index = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getStudents().size() > courses.get(index).getStudents().size()
					&& courses.get(i).getType().equals("TH")) {
				index = i;
			}
		}
		return courses.get(index);

	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> m1 = new HashMap<>();
		for (int i = 0; i < courses.size(); i++) {
			for (Student s : courses.get(i).getStudents()) {
				List<Student> students = new ArrayList<>();
				if (!m1.containsKey(s.getYear())) {
					students.add(s);
					m1.put(s.getYear(), students);
				} else {
					students = m1.get(s.getYear());
					if (!students.contains(s)) {
						students.add(s);
					}
				}
			}
		}
		return m1;
	}

	public Set<Course> filterCourses(String type) {
		Set<Course> t1 = new TreeSet<>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				return o2.getStudents().size() - o1.getStudents().size();
			}
		});
		for (Course arr : courses) {
			if (arr.getType().equals(type)) {
				t1.add(arr);
			}
		}
		return t1;
	}

	public static void main(String[] args) {
		Student s1 = new Student("001", "Nguyen Trong Nhan ", 2004);
		Student s2 = new Student("002", "Nguyen Trong Nhan 2", 2003);
		Student s3 = new Student("003", "Nguyen Trong Nhan 3", 2005);
		Student s4 = new Student("004", "Nguyen Trong Nhan 4", 2005);
		Student s5 = new Student("005", "Nguyen Trong Nhan 5", 2004);
		List<Student> ls1 = new ArrayList<>();
		ls1.add(s1);
		ls1.add(s2);

		List<Student> ls2 = new ArrayList<>();

		ls2.add(s4);
		ls2.add(s2);
		ls2.add(s3);

		Course c1 = new Course("201", "Toan", "LT", ls1, "Nguyen Van A");
		Course c2 = new Course("202", "CTDL", "TH", ls2, "Nguyen Van B");
		Course c3 = new Course("203", "HDH", "LT", ls2, "Nguyen Van C");
		Course c4 = new Course("204", "GTNM", "TH", ls1, "Nguyen Van D");

		List<Course> lc1 = new ArrayList<>();
		lc1.add(c1);
		lc1.add(c2);
		lc1.add(c3);
		lc1.add(c4);

		Faculty f1 = new Faculty("A", "HCM", lc1);

		System.out.println(f1.getMaxPracticalCourse());
		System.out.println();
		System.out.println(f1.groupStudentsByYear());
		System.err.println();
		System.err.println(f1.filterCourses("LT"));
	}
}
