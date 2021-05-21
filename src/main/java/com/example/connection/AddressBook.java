package com.example.connection;

import java.util.Objects;

public class AddressBook {
    private long id;
    private String email;
    private String fName;
    private String lName;
    private String location;
    private String phoneNo;
    private String title;

    public AddressBook(long id, String email, String fName, String lName, String location, String phoneNo, String title) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.location = location;
        this.phoneNo = phoneNo;
        this.title = title;
    }

    public AddressBook() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return id == that.id && Objects.equals(email, that.email) && Objects.equals(fName, that.fName) && Objects.equals(lName, that.lName) && Objects.equals(location, that.location) && Objects.equals(phoneNo, that.phoneNo) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, fName, lName, location, phoneNo, title);
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
