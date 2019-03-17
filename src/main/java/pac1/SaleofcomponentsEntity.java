package pac1;

import javax.persistence.*;

/**
 * Created by Helig on 29.12.2018.
 */
@Entity
@Table(name = "saleofcomponents", schema = "new_schema", catalog = "")
public class SaleofcomponentsEntity {
    private int idSaleOfComponents;
    private int salesCode;
    private int codeManufacturer;
    private int amount;
    private String codeCustomer;
    private int accessoryCode;

    @Id
    @Column(name = "idSaleOfComponents")
    public int getIdSaleOfComponents() {
        return idSaleOfComponents;
    }

    public void setIdSaleOfComponents(int idSaleOfComponents) {
        this.idSaleOfComponents = idSaleOfComponents;
    }

    @Basic
    @Column(name = "SalesCode")
    public int getSalesCode() {
        return salesCode;
    }

    public void setSalesCode(int salesCode) {
        this.salesCode = salesCode;
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
    @Column(name = "Amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "CodeCustomer")
    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleofcomponentsEntity that = (SaleofcomponentsEntity) o;

        if (idSaleOfComponents != that.idSaleOfComponents) return false;
        if (salesCode != that.salesCode) return false;
        if (codeManufacturer != that.codeManufacturer) return false;
        if (amount != that.amount) return false;
        if (codeCustomer != null ? !codeCustomer.equals(that.codeCustomer) : that.codeCustomer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSaleOfComponents;
        result = 31 * result + salesCode;
        result = 31 * result + codeManufacturer;
        result = 31 * result + amount;
        result = 31 * result + (codeCustomer != null ? codeCustomer.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "AccessoryCode")
    public int getAccessoryCode() {
        return accessoryCode;
    }

    public void setAccessoryCode(int accessoryCode) {
        this.accessoryCode = accessoryCode;
    }
}
