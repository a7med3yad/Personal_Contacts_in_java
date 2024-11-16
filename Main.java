import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Main{
    static String green = "\u001B[32m";
    static String red = "\u001B[31m";
    static HashTable h =new HashTable(7);
    static Scanner cs = new Scanner(System.in);

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main (String[]args) {
        String filePath = "C:/Users/ahmed/Downloads/Synthetic_Phone_Number_Dataset.csv"; 
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine(); 
            String[] headers = headerLine.split(","); 

            int nameIndex = -1;
            int phoneIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].trim().equalsIgnoreCase("Name")) {
                    nameIndex = i;
                } else if (headers[i].trim().equalsIgnoreCase("Phone Number")) {
                    phoneIndex = i;
                }
            }

            if (nameIndex == -1 || phoneIndex == -1) {
                System.out.println("Could not find 'name' or 'phone' columns.");
                return;
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                h.InsertNewContact(values[nameIndex],values[phoneIndex]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(green+"Welcome to our Telecom Company ...\nHow Can I help you ?"+red);
        customer();
    }


    public static void customer(){
        b:while (true) { 
            System.out.println(green+"1.Add Contact\n2.Search for a contact\n3.Update Contact\n4.Show Contact List\n5.Exit"+red);

            String option = cs.nextLine();
            String name;
            String phone_no;
            switch (option) {
                case "1" -> {
                    System.out.println(green+"Enter your name.."+red);
                    name =cs.nextLine();
                    System.out.println(green+"Enter your phone no.."+red);
                    phone_no =cs.nextLine();
                    h.InsertNewContact(name, phone_no);
                }
                case "2" -> {
                    System.out.println(green+"Enter your name.."+red);
                    name =cs.nextLine();
                    h.SearchContact(name);
                }
                case "3" -> {
                    System.out.println(green+"You must be admin to access these information\nplease Enter your username.."+red);
                    String username = cs.nextLine();
                    System.out.println(green+"Enter your password.."+red);
                    String password =cs.nextLine();
                    if(check(username,password)){
                        System.out.println(green+"Enter your name.."+red);
                        name =cs.nextLine();
                        System.out.println(green+"Enter your new name.."+red);
                        String new_name =cs.nextLine();
                        System.out.println(green+"Enter your new phone no.."+red);
                        phone_no=cs.nextLine();
                        h.UpdateContact(name, new_name, phone_no);
                    }else{
                        System.out.println(green+"Invalid Username You can't access contacts.."+red);
                    }
                }
                case "4" -> {
                    System.out.println(green+"You must be admin to access these information\nplease Enter your username.."+red);
                    String username = cs.nextLine();
                    System.out.println(green+"Enter your password.."+red);
                    String password =cs.nextLine();
                    if(check(username,password)){
                        h.DisplayAllContacts();
                    }
                    else{
                        System.out.println(green+"Invalid Username You can't access contacts.."+red);
                    }
                }
                case "5" -> {
                    System.out.println(green+"Thanks you for visit our Telecome Company.."+red);
                    break b;
                }
                default -> System.out.println(green+"Not Valid option Please Try again.."+red);
            }
        }
    } 
    public static boolean check(String username, String password) {
        return username.equals("ahmed")&&password.equals("1234");
    }

}
