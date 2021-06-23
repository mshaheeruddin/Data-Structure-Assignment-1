package Q4StudentRegistraition;

import java.util.ArrayList;
import java.util.NoSuchElementException;

    public class StudentRegistration {
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_RED = "\u001B[31m";


        String name;
        static class Node {
            String data;
            Node next;

            public Node() {

            }

            public Node(String name) {
                this.data = name;
                this.next = null;
            }
        }
        public Node head = null;
        public Node tail = null;



        void addName(String Name) {
            Node node = new Node(Name);
            if (head == null ) {
                head = node;
            }
            head.data = Name;

        }




        //Add Course
        void addCourse(String courseName) {
            Node newNode = new Node();
            newNode.data = courseName;
            if (head.next == null && tail == null) {
                head.next = newNode;
                tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;

        }
        public void display() {
            System.out.println();
            Node current = head;

            if (head == null) {
                System.out.println("No Record Found");
                return;
            }
            System.out.print("Student Name: " + head.data + " ---> Courses: ");
            while (current.next != null) {
                //Prints each node by incrementing pointer
                System.out.print(current.next.data);
                if (current.next.next != null) {
                    System.out.print(",");
                }
                current = current.next;
            }
        }
        // Remove Course
        void dropCourse(String courseName) {

            Node tmp = head;
            Node prev = null;

            //introduce a node prev which would follow the one to be deleted
            while (tmp != null && tmp.data != courseName) {
                prev = tmp;
                tmp = tmp.next;
            }
            //KeyNotFount
            if (tmp == null) {
                System.out.println();
                System.out.println(ANSI_YELLOW + "Hey " + head.data + "! Course Can't be dropped because entered Course is INVALID!" + ANSI_RESET);
            }


            try {
                //Unlink
                prev.next = tmp.next;
                System.out.println();
                System.out.println(ANSI_GREEN + "Course: " + tmp.data + " is dropped successfully!" + ANSI_RESET);
                System.out.println("Here is your updated registry:");
                display();
            } catch (Exception e) {

            }
        }
    }
