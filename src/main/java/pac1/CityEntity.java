package pac1;

import javax.persistence.*;

/**
 * Created by Helig on 01.01.2019.
 */
@Entity
@Table(name = "city", schema = "new_schema", catalog = "")
public class CityEntity {
    private int idCity;
    private int codeCity;
    private String nameCity;

    @Id
    @Column(name = "idCity")
    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    @Basic
    @Column(name = "CodeCity")
    public int getCodeCity() {
        return codeCity;
    }

    public void setCodeCity(int codeCity) {
        this.codeCity = codeCity;
    }

    @Basic
    @Column(name = "NameCity")
    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (idCity != that.idCity) return false;
        if (codeCity != that.codeCity) return false;
        if (nameCity != null ? !nameCity.equals(that.nameCity) : that.nameCity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCity;
        result = 31 * result + codeCity;
        result = 31 * result + (nameCity != null ? nameCity.hashCode() : 0);
        return result;
    }
}
