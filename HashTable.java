public class HashTable {
    String red = "\u001B[31m";
    String reset = "\u001B[0m"; 
    String blue = "\u001B[34m";
    @SuppressWarnings("FieldMayBeFinal")
    private int size;
    @SuppressWarnings("FieldMayBeFinal")
    private SinglyLinkedList[] hash_table;

    public HashTable(int size) {
        this.size = size;
        hash_table = new SinglyLinkedList[this.size];

        for (int i = 0; i < this.size; i++) {
            hash_table[i] = new SinglyLinkedList();
        }
    }

    public void InsertNewContact(String name, String phone_number) {
        int index = calcHash(name, this.size);
        hash_table[index].insertToTail(name, phone_number); 
    }

    public void DeleteContact(String name) {
        int index = calcHash(name, this.size);
        hash_table[index].deleteNode(name); 
    }

   
    public void SearchContact(String name) {
        int index = calcHash(name, this.size);
        if (hash_table[index].isInList(name)){}
        else {
            System.out.println(red+"Contact Not Found");
        }
    }
    public void UpdateContact(String name,String new_name,String new_phone) {
        int index = calcHash(name, this.size);
        hash_table[index].update(name, new_name, new_phone);
    }

    public void DisplayAllContacts() {
        for (int i = 0; i < size; i++) {
            System.out.println(reset+"Index : "+i);
            hash_table[i].printLinkedList();
        }
    }

    public static int calcHash(String key, int tableSize) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += Character.getNumericValue(key.charAt(i));
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);

        return Math.abs(hash) % tableSize;
    }  
}
