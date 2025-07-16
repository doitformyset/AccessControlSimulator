import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class Role {

    private String name;
    private Set<String> permissions;

    public Role(String name) {
        this.name = name;
        this.permissions = new HashSet<>();

    }

    public void addPermission(String permission) {
        permissions.add(permission);
    }

    public String getName() {
        return name;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Role role = (Role) obj;
        return name.equals(role.name);
    }

}
