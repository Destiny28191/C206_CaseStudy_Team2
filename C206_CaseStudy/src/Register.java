
public class Register {
	
	private String sID;
	private String sName;
	private String sClass;
	private String sTeacher;
	private String sParentName;
	private String sParentEmail;
	private String sParentContactNum;
	
	public Register(String sID, String sName, String sClass, String sTeacher, String sParentName,
			String sParentEmail, String sParentContactNum) {
		super();
		this.sID = sID;
		this.sName = sName;
		this.sClass = sClass;
		this.sTeacher = sTeacher;
		this.sParentName = sParentName;
		this.sParentEmail = sParentEmail;
		this.sParentContactNum = sParentContactNum;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public String getsTeacher() {
		return sTeacher;
	}

	public void setsTeacher(String sTeacher) {
		this.sTeacher = sTeacher;
	}

	public String getsParentName() {
		return sParentName;
	}

	public void setsParentName(String sParentName) {
		this.sParentName = sParentName;
	}

	public String getsParentEmail() {
		return sParentEmail;
	}

	public void setsParentEmail(String sParentEmail) {
		this.sParentEmail = sParentEmail;
	}

	public String getsParentContactNum() {
		return sParentContactNum;
	}

	public void setsParentContactNum(String sParentContactNum) {
		this.sParentContactNum = sParentContactNum;
	}

}
