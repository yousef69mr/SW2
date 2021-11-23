package sw2phases;

import java.util.*;

public class Account {

    private Users user;
    TransportationSystem system;

    public Account(Users user) {

        this.user = user;
        this.system = new TransportationSystem("uber");

    }

    Users getUser() {
        return this.user;
    }

    public Users signUp(Users u) {
        u.setType();

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

    public void logIn(String name, String pass) {
        if ("Driver".equals(user.getType())) {
            for (int i = 0; i < system.getAllDrivers().size(); i++) {
                if (system.getAllDrivers().get(i).getName().equalsIgnoreCase(name) && system.getAllDrivers().get(i).getPassword().equals(pass)) {
                    System.out.println(system.getAllDrivers().get(i));
                }
            }
        } else if ("Client".equals(user.getType())) {
            for (int i = 0; i < system.getAllClients().size(); i++) {
                if (system.getAllClients().get(i).getName().equalsIgnoreCase(name) && system.getAllClients().get(i).getPassword().equals(pass)) {
                    System.out.println(system.getAllClients().get(i));
                }
            }
        }
    }

}
