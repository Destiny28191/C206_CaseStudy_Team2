
public class Student {
	
	private String studentID;
	private String studentPassword;
	private String studentName;
	private String studentClass;
	private String studentTeacher;
	private String studentParentName;
	private String StudentParentEmail;
	private String studentContactNum;
	
	public Student(String studentID, String studentPassword, String studentName,
			String studentClass, String studentTeacher, String studentParentName, String studentParentEmail,
			String studentContactNum) {
		super();
		this.studentID = studentID;
		this.studentPassword = studentPassword;
		this.studentName = studentName;

		this.studentClass = studentClass;
		this.studentTeacher = studentTeacher;
		this.studentParentName = studentParentName;
		StudentParentEmail = studentParentEmail;
		this.studentContactNum = studentContactNum;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentTeacher() {
		return studentTeacher;
	}

	public void setStudentTeacher(String studentTeacher) {
		this.studentTeacher = studentTeacher;
	}

	public String getStudentParentName() {
		return studentParentName;
	}

	public void setStudentParentName(String studentParentName) {
		this.studentParentName = studentParentName;
	}

	public String getStudentParentEmail() {
		return StudentParentEmail;
	}

	public void setStudentParentEmail(String studentParentEmail) {
		StudentParentEmail = studentParentEmail;
	}

	public String getStudentContactNum() {
		return studentContactNum;
	}

	public void setStudentContactNum(String studentContactNum) {
		this.studentContactNum = studentContactNum;
	}
	

	
	
	
}
