package com.bionic.baglab.domains;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by potaychuk on 28.03.2017.
 */
@Entity
@Table(name = "orderstatus", schema = "baglab")
public class OrderStatusEntity {
    private int idOrderStatus;
    private String code;
    private String description;
    private Collection<OrderEntity> orders;


    //    private int deleted;

    @Id
    @Column(name = "`idorder_status`")
    public int getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(int idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }


    @Column(name = "`code`")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "`description`", columnDefinition = "MEDIUMTEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Basic
//    @Column(name = "deleted")
//    public int getDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(int deleted) {
//        this.deleted = deleted;
//    }
    @OneToMany(mappedBy = "orderStatus")
    public Collection<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Collection<OrderEntity> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderStatusEntity that = (OrderStatusEntity) o;

        if (idOrderStatus != that.idOrderStatus) return false;
//        if (deleted != that.deleted) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrderStatus;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
//        result = 31 * result + (int) deleted;
        return result;
    }
}