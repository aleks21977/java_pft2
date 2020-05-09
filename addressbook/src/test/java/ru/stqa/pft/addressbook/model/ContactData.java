package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String firtsName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String email;
    private final String group;

    public ContactData(String firtsName, String lastName, String address, String phone,
                       String email, String group) {
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.group = group;
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

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firtsName, that.firtsName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firtsName, lastName);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firtsName='" + firtsName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
