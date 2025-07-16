import java.util.HashSet;
import java.util.Set;


public class User {
    private String name;
    private Set<Role> roles;

    public User(String name) {
        this.name = name;
        this.roles = new HashSet<>();
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasPermission(String permission) {
        for (Role role : roles) {
            if (role.getPermissions().contains(permission)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
