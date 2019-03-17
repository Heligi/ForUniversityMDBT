package pac1;

import javax.persistence.*;

/**
 * Created by Helig on 29.12.2018.
 */
@Entity
@Table(name = "accessories", schema = "new_schema", catalog = "")
public class AccessoriesEntity {
    private int idAccessories;
    private int accessoryCode;
    private int codeManufacturer;
    private String nameAccessories;
    private int price;

    @Id
    @Column(name = "idAccessories")
    public int getIdAccessories() {
        return idAccessories;
    }

    public void setIdAccessories(int idAccessories) {
        this.idAccessories = idAccessories;
    }

    @Basic
    @Column(name = "AccessoryCode")
    public int getAccessoryCode() {
        return accessoryCode;
    }

    public void setAccessoryCode(int accessoryCode) {
        this.accessoryCode = accessoryCode;
    }

    @Basic
    @Column(name = "codeManufacturer")
    public int getCodeManufacturer() {
        return codeManufacturer;
    }

    public void setCodeManufacturer(int codeManufacturer) {
        this.codeManufacturer = codeManufacturer;
    }

    @Basic
    @Column(name = "NameAccessories")
    public String getNameAccessories() {
        return nameAccessories;
    }

    public void setNameAccessories(String nameAccessories) {
        this.nameAccessories = nameAccessories;
    }

    @Basic
    @Column(name = "Price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessoriesEntity that = (AccessoriesEntity) o;

        if (idAccessories != that.idAccessories) return false;
        if (accessoryCode != that.accessoryCode) return false;
        if (codeManufacturer != that.codeManufacturer) return false;
        if (price != that.price) return false;
        if (nameAccessories != null ? !nameAccessories.equals(that.nameAccessories) : that.nameAccessories != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAccessories;
        result = 31 * result + accessoryCode;
        result = 31 * result + codeManufacturer;
        result = 31 * result + (nameAccessories != null ? nameAccessories.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
