package Q6SplittingList;

public class SplitList {
        //Represent a node of the singly linked list
        class Node{
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        //Represent the head and tail of the singly linked list
        public Node head = null;
        public Node tail = null;

        //addNode() will add a new node to the list

        public void addNode(int data) {
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

        //display() will display all the nodes present in the list

        public void display() {
            //Node current will point to head
            Node current = head;

            if(head == null) {
                System.out.println("List is empty");
                return;
            }
            System.out.print( "{ ");
            while(current != null) {
                //Prints each node by incrementing pointer
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.print("}");
        }

        //addAtStart() will add a new node to the beginning of the list
        public void addAtStart(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }


        //countNodes() will count the nodes present in the list
        public int countNodes() {
            int count = 0;
            Node current;
            current = head;
            while (current != null) {
                current = current.next;
                count++;
            }

            return count;
        }
        void splitList() {
               //count nodes
            if (countNodes() % 2 == 0) {
                //for l2
                int k = 0;
                int sumForCounter = countNodes()/2;
                int nodeC = countNodes()/2;
                Node tmp;
                tmp = head;
                Node[] arr = new Node[nodeC];
                for (int a = 1;a<nodeC;a++) tmp = tmp.next;
                while (nodeC>0 && tmp != null) {
                    tmp = tmp.next;
                    if (tmp != null)
                        arr[k] = tmp;
                    k++;
                    nodeC--;
                }
                //for l1
                int nodeCounts = countNodes()/2;
                int count = countNodes()/2;
                int i = 0;
                Node current;
                current = head;

                while (count>0) {
                    current = current.next;
                    i++;
                    count--;
                    if (count == 1) {
                        current.next = null;
                    }
                }
                System.out.println("After Splitting:");
                display();
                SplitList l2 = new SplitList();

                for (int j = 0;j<sumForCounter;j++) {
                    int m  = arr[j].data;
                    l2.addNode(arr[j].data);
                   }
                 l2.display();
                }
            else if (countNodes()%2 != 0) {
                //for l2
                int k = 0;
                int sumForCounter = (countNodes()/2);
                int nodeC = (countNodes()/2);
                Node tmp;
                tmp = head;
                Node[] arr = new Node[nodeC];
                for (int a = 0;a<nodeC;a++) tmp = tmp.next;
                while (nodeC>0 && tmp != null) {
                    tmp = tmp.next;
                    if (tmp != null)
                        arr[k] = tmp;
                    k++;
                    nodeC--;
                }
                //for l1
                int nodeCounts = countNodes()/2+1;
                int count = countNodes()/2+1;
                int i = 0;
                Node current;
                current = head;

                while (count>0) {
                    current = current.next;
                    i++;
                    count--;
                    if (count == 1) {
                        current.next = null;
                    }
                }
                System.out.println("After Splitting:");
                display();
                System.out.println();
                SplitList l2 = new SplitList();

                for (int j = 0;j<sumForCounter;j++) {
                    int m  = arr[j].data;
                    l2.addNode(arr[j].data);
                }
                l2.display();
            }


        }


    public static void main(String[] args) {
        SplitList sl = new SplitList();
        /*
        Use this to check for length 4 (EVEN CASE)
        sl.addNode(1);
        sl.addNode(2);
        sl.addNode(3);
        sl.addNode(4);
         */

        //Length is 7 (ODD CASE)
        sl.addNode(1);
        sl.addNode(2);
        sl.addNode(3);
        sl.addNode(4);
        sl.addNode(5);
        sl.addNode(6);
        sl.addNode(7);

        sl.splitList();
    }
}

