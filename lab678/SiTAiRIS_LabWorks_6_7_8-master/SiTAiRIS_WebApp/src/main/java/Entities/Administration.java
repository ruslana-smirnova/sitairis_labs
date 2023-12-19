package Entities;

public class Administration {
    private String passNumber;
    private String post;
    private String fullName;
    private int age;
    private int stage;

    public Administration(String passNumber, String post, String fullName, int age, int stage) {
        this.passNumber = passNumber;
        this.post = post;
        this.fullName = fullName;
        this.age = age;
        this.stage = stage;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getPost() {
        return post;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public int getStage() {
        return stage;
    }
}
