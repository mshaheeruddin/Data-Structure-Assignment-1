package Q5LinkedListOfWords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LLOfWords {
    class Node{
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(String data) {
        //Create a new node
        Node newNode = new Node(data);

        //Checks if the list is empty
        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }
    }

    public void display() {
        //Node current will point to head
        Node current = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(current != null) {
            //Prints each node by incrementing pointer
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public Node[] ArrayOfLL (File inputfile) {
        LLOfWords[] arr = new LLOfWords[26];

        for (int i = 0; i < 26; i++) arr[i] = new LLOfWords();
        try {
            File myFile = inputfile;
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = "";

            String[] result = null;
            while ((line = reader.readLine()) != null) {

                //split when ot sees gap and store it in result
                result = line.split(" ");

            for (int i = 0;i< result.length ; i++) {
                //for words starting with lowercase letter
                int index = result[i].charAt(0) - 'a';
                if (index >= 0)
                arr[index].addNode(result[i]);
                else if (index < 0) {
                    //for words starting with uppercase letters
                    index = result[i].charAt(0)- 'A';
                    arr[index].addNode(result[i]);

                }
              }
            }
            //printing array of Linked List arranged alphabetically.
            for (int i = 0;i<arr.length;i++) {
                  arr[i].display();
            }
            reader.close();

        } catch(Exception ex){
            ex.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) {
          LLOfWords ll = new LLOfWords();
          //RelativePath
          ll.ArrayOfLL(new File("C:\\Users\\Muhammad Shaheer\\Desktop\\IBA\\Third Semester\\Data Structure\\Assignment1\\src\\Q5LinkedListOfWords\\text"));
    }
}
