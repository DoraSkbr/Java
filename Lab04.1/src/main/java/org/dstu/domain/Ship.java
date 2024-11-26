package org.dstu.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Ship {
    private int id;
    private String name;
    private Integer tonnage;
    private String type;
    private Integer length;
    private Integer width;
    private Integer enginePower;
    private Port port;


    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "tonnage")
    public Integer getTonnage() {
        return tonnage;
    }

    public void setTonnage(Integer tonnage) {
        this.tonnage = tonnage;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "length")
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Basic
    @Column(name = "width")
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Basic
    @Column(name = "enginePower")
    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "port_id")
    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return id == ship.id && Objects.equals(name, ship.name) && Objects.equals(tonnage, ship.tonnage) && Objects.equals(type, ship.type) && Objects.equals(length, ship.length) && Objects.equals(width, ship.width) && Objects.equals(enginePower, ship.enginePower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tonnage, type, length, width, enginePower);
    }
}
