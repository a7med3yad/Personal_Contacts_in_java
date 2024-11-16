public class Node {
    String name;
    String phone_number;
    Node next;

    Node(String name,String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
        this.next = null;
    }
    Node(String name,String phone_number, Node next) {
        this.name = name;
        this.phone_number=phone_number;
        this.next = next;
    }
}
