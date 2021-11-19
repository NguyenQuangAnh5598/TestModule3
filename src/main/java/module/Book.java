package module;

public class Book {
    private int id;
    private String bookCode;
    private String bookName;
    private String author;
    private String description;
    private int count;

    public Book() {
    }

    public Book(int id, String bookCode, String bookName, String author, String description, int count) {
        this.id = id;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.count = count;
    }

    public Book(String bookCode, String bookName, String author, String description, int count) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
