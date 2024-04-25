package model;

public class Users {
    private int id;
    private int storeId;
    private String type;
    private String name;
    private String phone_number;
    private String password;

    public Users() {
        id = -1;
        storeId = -1;
        type = "";
        name = "";
        phone_number = "";
        password = "";
    }

    public Users(int id, int storeId, String type, String name, String phone_number, String password) {
        setId(id);
        setStoreId(storeId);
        setType(type);
        setName(name);
        setPhoneNumber(phone_number);
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
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

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
