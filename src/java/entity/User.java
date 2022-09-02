/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class User {
    private int idUser;
    private String firstName;
    private String lastName ;
    private  String streetAddress ;
    private String town ;
    private  String city ;
    private int phone ;
    private String email;
    private String userName;
    private  String password ;

    public User() {
    }

    public User(int idUser, String firstName, String lastName, String streetAddress, String town, String city, int phone, String email, String userName, String password) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.town = town;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
        this.password=password;
    }
    
      public User( String firstName, String lastName, String streetAddress, String town, String city, int phone, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.town = town;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "user{" + "idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", streetAddress=" + streetAddress + ", town=" + town + ", city=" + city + ", phone=" + phone + ", email=" + email + ", userName=" + userName +", password= "+password +'}';
    }
    
    
}
