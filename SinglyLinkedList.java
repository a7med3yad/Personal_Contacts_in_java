public class SinglyLinkedList {
    private Node head;
    private Node tail;
    String reset = "\u001B[0m"; 
    String blue = "\u001B[34m";
    public void insertToHead(String name,String phone_number) {
        if (head == null) {
            head = tail = new Node(name,phone_number);
        } else {
            head = new Node(name,phone_number, head);
        }
    }

    public void insertToTail(String name,String phone_number) {
        if (head == null) {
            head = tail = new Node(name,phone_number);
        } else {
            tail.next = new Node(name,phone_number);
            tail = tail.next;
        }
    }

    // Delete element from the head
   /*  public String deleteFromHead() {
        if (head == null) {
            System.out.println("No Node to remove");
            return "🙂";
        }
        String name = head.name;
        String phone_number =head.phone_number;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return "Name : "+name+"\n"+"Phone Number : "+phone_number;
    }

    // Delete element from the tail
    public String deleteFromTail() {
        if (head == null) {
            System.out.println("No Node to remove");
            return "🙂";
        }
        String name = head.name;
        String phone_number =head.phone_number;
        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }
        return "Name : "+name+"\n"+"Phone Number : "+phone_number;
    }
*/
    public void deleteNode(String name) {
        if (head == null) return;

        if (head.name.equals(name)) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
        } else {
            Node pred = head;
            Node tmp = head.next;

            while (tmp != null &&!tmp.name.equals(name)) {
                pred = tmp;
                tmp = tmp.next;
            }

            if (tmp != null) {
                pred.next = tmp.next;
                if (tmp == tail) {
                    tail = pred;
                }
            }
        }
    }

    public void printLinkedList() {
        if (!(head == null)) {
            Node tmp = head;
            while (tmp != null) {
                System.out.println(reset+"|"+blue+" Name : "+reset+tmp.name+blue+" , Phone no : "+reset+tmp.phone_number+" | ");
                tmp = tmp.next;
            }
        }
    }
    public void update(String name,String new_name , String new_phone) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.name.equals(name)) {
                tmp.name=new_name;
                tmp.phone_number=new_phone;
                return;
            }
            tmp = tmp.next;
        }
        System.out.println("Contact does not exist");
    }

    public boolean isInList(String name) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.name.equals(name)) {
                System.out.println("Contact Found");
                System.out.println(reset+"|"+blue+" Name : "+reset+tmp.name+blue+" , Phone no : "+reset+tmp.phone_number+" | ");
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

   
}
