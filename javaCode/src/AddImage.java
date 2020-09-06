public class AddImage {
    private String fileURL;
    private String name;

    public String getFileURL() { return fileURL; }
    public String getName() { return name; }

    public AddImage(String newFileURL, String newName) {
        this.name = newName;
        this.fileURL = newFileURL;
    }
}
