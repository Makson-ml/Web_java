import java.util.List;
import java.util.ArrayList;

public class SmartCopier {

    public static <E> void copyElements(List<? super E> dest, List<? extends E> src) {
        if (dest == null || src == null) return;
        
        dest.clear();
        for (E element : src) {
            dest.add(element);
        }
    }

    public static void main(String[] args) {
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("1"));
        photos.add(new Photo("2"));
        
        List<Attachment> dest1 = new ArrayList<>();
        copyElements(dest1, photos);
        System.out.println(dest1.size() == 2 ? "Test 1 PASSED" : "Test 1 FAILED");

        List<Video> videos = new ArrayList<>();
        videos.add(new Video("A"));
        
        List<Attachment> dest2 = new ArrayList<>();
        dest2.add(new Photo("old"));
        copyElements(dest2, videos);
        System.out.println(dest2.size() == 1 && dest2.get(0) instanceof Video 
            ? "Test 2 PASSED" : "Test 2 FAILED");

        List<Attachment> emptySrc = new ArrayList<>();
        List<Attachment> dest3 = new ArrayList<>();
        dest3.add(new Sticker("x"));
        copyElements(dest3, emptySrc);
        System.out.println(dest3.isEmpty() ? "Test 3 PASSED" : "Test 3 FAILED");
    }
}
