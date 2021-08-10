import java.util.ArrayList;
public class studentcca {
  private String cca;
  private String student;
    public studentcca(String cca,String student) {
      super();
      this.cca = cca;
      this.student=student;
  }
    public String getstudent() {
      return student;
    }

    public void setstudent(String student) {
      this.student = student;
    }
    public static boolean add(ArrayList<studentcca>  sclist, studentcca A) {
        sclist.add(A);
        return true;
        
      }

}
