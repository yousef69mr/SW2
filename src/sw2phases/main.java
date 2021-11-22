package sw2phases;

import java.util.*;

public class main {

    public static void main(String[] args) {

        TransportationSystem system = TransportationSystem.getInstance("uber");
        Administrator admin = system.getAdmin();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter choice");
        String input = scan.next();

        switch (input) {

            case ("Driver"):

                Driver d = new Driver();
                //Account account = new Account(d);
                d.getAccount().signUp(d);

                System.out.println("Enter your Name");
                String name = scan.next();
                d.setName(name);
                System.out.println("Enter your Phone Number");
                String phone = scan.next();
                d.setPhoneNumber(phone);
                System.out.println("Enter your Email");
                String email = scan.next();
                d.setEmail(email);
                System.out.println("Enter your Password");
                String pass = scan.next();
                d.setPassword(pass);
                System.out.println("Enter your National ID");
                String id = scan.next();
                d.setNationalID(id);
                System.out.println("Enter your Licence Number");
                String licence = scan.next();
                d.setDriverLicence(licence);
                 Driver d2 = new Driver(name,phone,email,pass,id,licence);
               admin.approveDriver(d2);
               d2.addFavouriteArea("mmmmm");
               d2.DisplayData();
                break;
                
            case "Client":
                Client  c = new Client();
               
   
                c.getAccount().signUp(c);

                System.out.println("Enter your Name");
                 name = scan.next();
                c.setName(name);
                System.out.println("Enter your Phone Number");
                 phone = scan.next();
                c.setPhoneNumber(phone);
                System.out.println("Enter your Email");
                 email = scan.next();
                c.setEmail(email);
                System.out.println("Enter your Password");
                pass = scan.next();
                c.setPassword(pass);
                Client c1=new Client(name,phone,email,pass);
                c1.DisplayData();
                
        }

    }
}
