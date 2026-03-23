import java.util.ArrayList;
import java.util.List;

public class GenericPost<T extends Attachment> {
    private final List<T> attachments = new ArrayList<>();

    public void add(T item) {
        if (item != null) attachments.add(item);
    }

    public T getLast() {
        return attachments.isEmpty() ? null : attachments.get(attachments.size() - 1);
    }

    public int count() {
        return attachments.size();
    }

    public static void main(String[] args) {
        GenericPost<Photo> photoPost = new GenericPost<>();
        photoPost.add(new Photo("Cat"));
        Photo lastPhoto = photoPost.getLast();
        System.out.println(lastPhoto != null ? "Test 1 PASSED: PhotoPost" : "Test 1 FAILED");

        GenericPost<Attachment> mixedPost = new GenericPost<>();
        mixedPost.add(new Video("Lecture"));
        mixedPost.add(new Sticker("Fire"));
        
        Attachment last = mixedPost.getLast();
        System.out.println(last instanceof Sticker ? "Test 2 PASSED: MixedPost" : "Test 2 FAILED");

        GenericPost<Attachment> empty = new GenericPost<>();
        System.out.println(empty.getLast() == null ? "Test 3 PASSED: Empty post" : "Test 3 FAILED");
    }
}
