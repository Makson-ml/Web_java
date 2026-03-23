import java.util.ArrayList;
import java.util.List;

public class SimplePost {
    private final List<Attachment> items = new ArrayList<>();

    public void addItem(Attachment item) {
        if (item != null) items.add(item);
    }

    public Attachment getLastItem() {
        return items.isEmpty() ? null : items.get(items.size() - 1);
    }

    public int size() {
        return items.size();
    }

    public static void main(String[] args) {
        SimplePost post = new SimplePost();
        post.addItem(new Photo("Sunset"));
        post.addItem(new Video("Travel"));

        Attachment last = post.getLastItem();
        System.out.println(last instanceof Video ? "Test 1 PASSED: Video added" : "Test 1 FAILED");
        System.out.println("Total attachments: " + post.size());
        
        SimplePost empty = new SimplePost();
        System.out.println(empty.getLastItem() == null ? "Test 2 PASSED: Empty post" : "Test 2 FAILED");
    }
}
