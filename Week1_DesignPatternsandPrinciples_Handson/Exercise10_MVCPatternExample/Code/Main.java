public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Dharshini");
        student.setId("6426413"); // Updated ID
        student.setGrade("A");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentGrade("A+");
        System.out.println("\nUpdating grade...\n");
        controller.updateView();
    }
}
