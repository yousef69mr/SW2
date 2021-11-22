package sw2phases;

import java.util.*;

public class Account {

    private Users user;

    public Account(Users user) {

        this.user = user;

    }

    Users getUser() {
        return this.user;
    }

    public Users signUp(Users u) {
        u.setType();
        TransportationSystem system = new TransportationSystem("uber");
        
        if ("Driver".equals(u.getType())) {

           
            if (u.isValidInput()) {

                if (!system.getAllRequests().contains(u)) {
                    system.getAllRequests().add(u);
                }
                return u;
            } else {
                return null;
            }
        } else {

            if (u.isValidInput()) {
                if (!system.getAllClients().contains(u)) {
                    system.getAdmin().addClient((Client) u);
            
                }
                return u;
            } else {
                return null;
            }
        }

    }
    

}
