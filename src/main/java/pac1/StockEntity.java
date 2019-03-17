package pac1;

import javax.persistence.*;

/**
 * Created by Helig on 01.01.2019.
 */
@Entity
@Table(name = "stock", schema = "new_schema", catalog = "")
public class StockEntity {
    private int idStock;
    private int stockCode;
    private int accessoryCode;
    private Integer quantityInStock;
    private int codeCity;

    @Id
    @Column(name = "idStock")
    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    @Basic
    @Column(name = "StockCode")
    public int getStockCode() {
        return stockCode;
    }

    public void setStockCode(int stockCode) {
        this.stockCode = stockCode;
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
    @Column(name = "QuantityInStock")
    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Basic
    @Column(name = "CodeCity")
    public int getCodeCity() {
        return codeCity;
    }

    public void setCodeCity(int codeCity) {
        this.codeCity = codeCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockEntity that = (StockEntity) o;

        if (idStock != that.idStock) return false;
        if (stockCode != that.stockCode) return false;
        if (accessoryCode != that.accessoryCode) return false;
        if (codeCity != that.codeCity) return false;
        if (quantityInStock != null ? !quantityInStock.equals(that.quantityInStock) : that.quantityInStock != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStock;
        result = 31 * result + stockCode;
        result = 31 * result + accessoryCode;
        result = 31 * result + (quantityInStock != null ? quantityInStock.hashCode() : 0);
        result = 31 * result + codeCity;
        return result;
    }
}
