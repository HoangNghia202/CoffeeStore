/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Menu {
    private int id ;
    private String  type ;
    private String name; 
    private String describe ;
    private float price ;
    private  String imgLink ;

    public Menu() {
    }

    public Menu(int id, String type, String name, String describe, float price, String imgLink) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.imgLink = imgLink;
    }
    
     public Menu( String type, String name, String describe, float price, String imgLink) {
        this.type = type;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.imgLink = imgLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Override
    public String toString() {
        return "menu{" + "id=" + id + ", type=" + type + ", name=" + name + ", describe=" + describe + ", price=" + price + ", imgLink=" + imgLink + '}';
    }
    
}
