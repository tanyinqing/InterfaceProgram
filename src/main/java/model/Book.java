package model;

import java.io.Serializable;

public class Book implements Serializable {
    // 主键用封装类  比较大用 长整型
    private  Integer id;//这个不能错  否则会出问题
    private  String title;
    private  double price;
    private  int amount;
    private  String pubTime;
    private  int userId;
    private  User  user;

    public Book() {
    }

    //[java.lang.Integer, java.lang.String, java.math.BigDecimal, java.lang.Integer, java.sql.Date]
    public Book(Integer id, String title, double price, int amount, String pubTime, int userId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.pubTime = pubTime;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", pubTime='" + pubTime + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }
}
