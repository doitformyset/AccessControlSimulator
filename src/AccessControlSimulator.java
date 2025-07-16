import java.security.Permission;
import java.util.*;

public class AccessControlSimulator {

    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Role> roles = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": createUser(); break;
                case "2": createRole(); break;
                case "3": assignRoleToUser(); break;
                case "4": assignPermissionToRole(); break;
                case "5": checkUserPermission(); break;
                case "6": System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice..."); break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nAccess Control Simulator");
        System.out.println("1. Create User");
        System.out.println("2. Create Role");
        System.out.println("3. Assign Role to User");
        System.out.println("4. Assign Permission to Role");
        System.out.println("5. Check if User has Permission");
        System.out.println("6. Exit");
        System.out.println("Enter Choice: ");
    }

    private static void createUser() {
        System.out.println("Enter username: ");
        String input = scanner.nextLine();
        String username = input.toLowerCase();

        // Check if username already exists
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }

        // Create and add the new user
        User user = new User(username);
        users.put(username, user);

        System.out.println("User '" + username + "' created.");
    }

    private static void createRole() {
        System.out.println("Enter role name: ");
        String input = scanner.nextLine();
        String roleName = input.toLowerCase();

        if (roles.containsKey(roleName)) {
            System.out.println("Role already exists.");
            return;
        }

        Role role = new Role(roleName);
        roles.put(roleName, role);

        System.out.println("Role '" + roleName + "' created.");
    }

    private static void assignRoleToUser() {
        System.out.println("Enter username: ");
        String userInput = scanner.nextLine();
        String username = userInput.toLowerCase();

        System.out.println("Enter role name: ");
        String roleInput = scanner.nextLine();
        String roleName = roleInput.toLowerCase();

        User user = users.get(username);
        Role role = roles.get(roleName);

        if (user == null) {
            System.out.println("User '" + username + "' not found.");
        }

        if (role == null) {
            System.out.println("Role '" + roleName + "' not found.");
        }

        if (user == null || role == null) {
            return;
        }

        // Check if user already has the role
        if (user.getRoles().contains(role)) {
            System.out.println("User '" + username + "' already has the role '" + roleName + "'.");
        }

        user.addRole(role);
        System.out.println("Role '" + roleName + "' assigned to user '" + username + "'.");
    }

    private static void assignPermissionToRole() {
        System.out.println("Enter role name: ");
        String input = scanner.nextLine();
        String roleName = input.toLowerCase();

        Role role = roles.get(roleName);

        if (role == null) {
            System.out.println("Role '" + roleName + "' not found");
            return;
        }

        System.out.println("Enter permission name: ");
        String permission = scanner.nextLine().toLowerCase();

        if (role.getPermissions().contains(permission)) {
            System.out.println("Role '" + roleName + "' already has the permission '" + permission + "'!");
            return;
        }

        role.addPermission(permission);
        System.out.println("Permission '" + permission + "' assigned to role '" + roleName + "'.");
    }

    private static void checkUserPermission() {
        System.out.println("Enter username: ");
        String input = scanner.nextLine();
        String username = input.toLowerCase();

        User user = users.get(username);

        if (user == null) {
            System.out.println("User '" + username + "' not found.");
            return;
        }

        System.out.println("Enter permission name: ");
        String permission = scanner.nextLine().toLowerCase();

        boolean hasPermission = user.hasPermission(permission);

        System.out.println("User '" + user.getName() + "' has the permission '" + permission + "': " + hasPermission);
    }
}
