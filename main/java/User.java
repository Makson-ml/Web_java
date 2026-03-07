import java.util.Objects;

public final class User {
    
    private final long id;
    private final String email;
    private final int age;

    public User(long id, String email, int age) {
        if (email == null || email.isEmpty()) {
            throw new InvalidFieldException("Email cannot be null or empty");
        }
        if (age < 0 || age > 150) {
            throw new InvalidFieldException("Age must be 0..150");
        }
        this.id = id;
        this.email = email;
        this.age = age;
    }

    public long getId() { return id; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, age);
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", email='" + email + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        System.out.println("=== User Tests ===");
        
        User u1 = new User(1L, "a@b.com", 20);
        User u2 = new User(1L, "a@b.com", 20);
        User u3 = new User(2L, "c@d.com", 30);
        
        System.out.println("u1.equals(u1): " + u1.equals(u1));
        System.out.println("u1.equals(null): " + u1.equals(null));
        System.out.println("u1.equals(new Object()): " + u1.equals(new Object()));
        System.out.println("u1.equals(u2): " + u1.equals(u2));
        System.out.println("u1.equals(u3): " + u1.equals(u3));
        
        System.out.println("\nhashCode test:");
        System.out.println("u1.hashCode() == u2.hashCode(): " + (u1.hashCode() == u2.hashCode()));
        
        System.out.println("\ntoString test:");
        System.out.println("toString: " + u1.toString());
        System.out.println("Contains 'id=1': " + u1.toString().contains("id=1"));
        
        System.out.println("\n--- Test validation ---");
        try {
            new User(1L, "", 20);
            System.out.println("ERROR: should have thrown");
        } catch (InvalidFieldException e) {
            System.out.println("OK (empty email): " + e.getMessage());
        }
        
        try {
            new User(1L, "test@test.com", 200);
            System.out.println("ERROR: should have thrown");
        } catch (InvalidFieldException e) {
            System.out.println("OK (bad age): " + e.getMessage());
        }
        
        System.out.println("\n=== All User tests done ===");
    }
}
