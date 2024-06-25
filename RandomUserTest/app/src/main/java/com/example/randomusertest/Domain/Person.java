package com.example.randomusertest.Domain;

import java.io.Serializable;

/**
 * The type Person.
 */
public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String birthday;
    private String age;
    private String email;
    private String mobile;
    private String address;
    private String contactPerson;
    private String contactPhone;

    /**
     * Instantiates a new Person.
     *
     * @param firstName     the first name
     * @param lastName      the last name
     * @param birthday      the birthday
     * @param age           the age
     * @param email         the email
     * @param mobile        the mobile
     * @param address       the address
     * @param contactPerson the contact person
     * @param contactPhone  the contact phone
     */
    public Person(String firstName, String lastName, String birthday, String age, String email, String mobile,
                  String address, String contactPerson, String contactPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.age = age;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
// Getters and setters
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public String getAge() {
        return age;
    }


    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Gets mobile.
     *
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets contact person.
     *
     * @return the contact person
     */
    public String getContactPerson() {
        return contactPerson;
    }

}

