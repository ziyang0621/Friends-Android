package com.ziyang0621.friends;

/**
 * Created by ziyang0621 on 3/10/15.
 */
public class Friend {

    private int _id;
    private String name;
    private String phone;
    private String email;

    public Friend(int _id, String name, String phone, String email) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
}
