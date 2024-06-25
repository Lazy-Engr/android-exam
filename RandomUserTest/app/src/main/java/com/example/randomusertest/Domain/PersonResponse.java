package com.example.randomusertest.Domain;

import java.util.List;

/**
 * The type Person response.
 */
public class PersonResponse {
    private List<Result> results;

    /**
     * Gets results.
     *
     * @return the results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * The type Result.
     */
    public static class Result {
        private Name name;
        private String email;
        private String phone;
        private String age;
        private String birthday;
        private String address;
        private String contactPerson;
        private String contactPersonNumber;

        /**
         * Gets name.
         *
         * @return the name
         */
        public Name getName() {
            return name;
        }

        /**
         * Gets contact person.
         *
         * @return the contact person
         */
        public String getContactPerson() {
            return contactPerson;
        }

        /**
         * Gets contact person number.
         *
         * @return the contact person number
         */
        public String getContactPersonNumber() {
            return contactPersonNumber;
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
         * Gets address.
         *
         * @return the address
         */
        public String getAddress() {
            return address;
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
         * Gets phone.
         *
         * @return the phone
         */
        public String getPhone() {
            return phone;
        }

        /**
         * Gets birthday.
         *
         * @return the birthday
         */
        public String getBirthday() {
            return birthday;
        }

    }

    /**
     * The type Name.
     */
    public static class Name {
        private String first;
        private String last;

        /**
         * Gets first.
         *
         * @return the first
         */
        public String getFirst() {
            return first;
        }

        /**
         * Gets last.
         *
         * @return the last
         */
        public String getLast() {
            return last;
        }
    }
}
