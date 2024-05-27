package org.example;

import java.util.Objects;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
            this.country = country;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }

    public static boolean isPostalCodeValid(String postalCode) {
        postalCode = postalCode.toUpperCase(); // Normalize the postal code to uppercase
        int length = postalCode.length();

        if (length == 6) {
            return isCharDigit(postalCode);
        } else if (length == 7 && postalCode.charAt(3) == ' ') {
            return isCharDigit(postalCode.substring(0, 3) + postalCode.substring(4));
        }

        return false;
    }

    private static boolean isCharDigit(String postalCode) {
        return Character.isLetter(postalCode.charAt(0)) &&
                Character.isDigit(postalCode.charAt(1)) &&
                Character.isLetter(postalCode.charAt(2)) &&
                Character.isDigit(postalCode.charAt(3)) &&
                Character.isLetter(postalCode.charAt(4)) &&
                Character.isDigit(postalCode.charAt(5));
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNo=" + streetNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return streetNo == address.streetNo &&
                Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(province, address.province) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(country, address.country);
    }

    public int getStreetNo() {
        return streetNo;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
