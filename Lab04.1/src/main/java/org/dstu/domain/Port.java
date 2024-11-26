package org.dstu.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Port {
    private int id;
    private String location;
    private  Integer depth;
    private String operatingHours;
    private String facilities;
    private Set<Ship> staff = new LinkedHashSet<>();

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
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "depth")
    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    @Basic
    @Column(name = "operatingHours")
    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    @Basic
    @Column(name = "facilities")
    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    @OneToMany(mappedBy = "port")
    public Set<Ship> getStaff() {
        return staff;
    }

    public void setStaff(Set<Ship> staff) {
        this.staff = staff;
    }
}
