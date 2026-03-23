public abstract class Attachment {
    private final String content;
    
    public Attachment(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
}
