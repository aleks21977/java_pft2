package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firtsName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String email;

    public ContactData(String firtsName, String lastName, String address, String phone, String email) {
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
