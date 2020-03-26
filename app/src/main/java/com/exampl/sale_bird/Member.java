package com.exampl.sale_bird;
public class Member {
    private String Name=null;
   // ,Email,Password,Phone;
   private String Email=null;
    private String Password=null;
    private String Phone=null;
    private String Address=null;

    public Member() {

    }



    public Member(String name, String email, String password, String phone, String Address){

        Name=name;
        Email=email;
        Password=password;
        Phone=phone;
       // Address=address;
        this.Address=Address;
}

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password=password;
    }
}
