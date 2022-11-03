package by.korotkevich.entity;

public class Product {

    private int id;

    private String name;

    private String date;

    private String authorName;

    private String publisherName;

    public Product(int id, String name, String date, String authorName, String publisherName) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.authorName = authorName;
        this.publisherName = publisherName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id +
                ", name= " + name +
                ", date= " + date +
                ", author= " + authorName +
                ", publisher= " + publisherName;
    }
}
