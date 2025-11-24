package vn.hoidanit.laptopshop.entity;

public class User {
    private long id;
    private String email;
    private String pw;

    private String address;
    private String phone;

    public User() {

    }

    public User(long id, String email, String pw, String address, String phone) {
        this.id = id;
        this.email = email;
        this.pw = pw;

        this.address = address;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", pw=" + pw + " address=" + address
                + ", phone=" + phone + "]";
    }

}
