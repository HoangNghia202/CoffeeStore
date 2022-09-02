/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Admin {
    private int id;
    private  String adName;
    private String password;
    private String email;

    public Admin(int id, String adName, String password, String email) {
        this.id = id;
        this.adName = adName;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Admin(String adName, String password, String email) {
        this.adName = adName;
        this.password = password;
        this.email = email;
    }
    
    
    
      public Admin( String email, String password) {
        this.password = password;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", adName=" + adName + ", password=" + password + ", email=" + email + '}';
    }

  
    
}
