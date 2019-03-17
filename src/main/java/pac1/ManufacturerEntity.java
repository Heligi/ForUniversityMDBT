package pac1;

import javax.persistence.*;

/**
 * Created by Helig on 29.12.2018.
 */
@Entity
@Table(name = "manufacturer", schema = "new_schema", catalog = "")
public class ManufacturerEntity {
    private int idmanufacturer;
    private int codeManufacturer;
    private String nameManu;

    @Id
    @Column(name = "idmanufacturer")
    public int getIdmanufacturer() {
        return idmanufacturer;
    }

    public void setIdmanufacturer(int idmanufacturer) {
        this.idmanufacturer = idmanufacturer;
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
    @Column(name = "NameManu")
    public String getNameManu() {
        return nameManu;
    }

    public void setNameManu(String nameManu) {
        this.nameManu = nameManu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManufacturerEntity that = (ManufacturerEntity) o;

        if (idmanufacturer != that.idmanufacturer) return false;
        if (codeManufacturer != that.codeManufacturer) return false;
        if (nameManu != null ? !nameManu.equals(that.nameManu) : that.nameManu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmanufacturer;
        result = 31 * result + codeManufacturer;
        result = 31 * result + (nameManu != null ? nameManu.hashCode() : 0);
        return result;
    }
}
