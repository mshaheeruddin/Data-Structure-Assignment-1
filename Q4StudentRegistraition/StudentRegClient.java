package Q4StudentRegistraition;

import java.util.Scanner;

public class StudentRegClient {
    public static void main(String[] args) throws Exception {
        StudentRegistration studentRegistration = new StudentRegistration();
        StudentRegistration studentRegistration1 = new StudentRegistration();
           studentRegistration.addName("Shaheer");
           studentRegistration.addCourse("CSE121");
           studentRegistration.addCourse("CSE222");

           studentRegistration.dropCourse("CSE121");

           studentRegistration1.addName("Khan");
           studentRegistration1.addCourse("CSE121");
           studentRegistration1.addCourse("CSE121");


        studentRegistration1.display();

    }


}
