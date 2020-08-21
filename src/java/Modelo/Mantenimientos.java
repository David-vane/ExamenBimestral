/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "mantenimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimientos.findAll", query = "SELECT m FROM Mantenimientos m")
    , @NamedQuery(name = "Mantenimientos.findByIdVehiculo", query = "SELECT m FROM Mantenimientos m WHERE m.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Mantenimientos.findByCedulaCliente", query = "SELECT m FROM Mantenimientos m WHERE m.cedulaCliente = :cedulaCliente")
    , @NamedQuery(name = "Mantenimientos.findByFechaMan", query = "SELECT m FROM Mantenimientos m WHERE m.fechaMan = :fechaMan")
    , @NamedQuery(name = "Mantenimientos.findByDescripcion", query = "SELECT m FROM Mantenimientos m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Mantenimientos.findByKilometrajeVehiculo", query = "SELECT m FROM Mantenimientos m WHERE m.kilometrajeVehiculo = :kilometrajeVehiculo")})
public class Mantenimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "IdVehiculo")
    private Integer idVehiculo;
    @Size(max = 11)
    @Column(name = "CedulaCliente")
    private String cedulaCliente;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaMan")
    @Temporal(TemporalType.DATE)
    private Date fechaMan;
    @Size(max = 70)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "KilometrajeVehiculo")
    private Integer kilometrajeVehiculo;

    public Mantenimientos() {
    }

    public Mantenimientos(Date fechaMan) {
        this.fechaMan = fechaMan;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Date getFechaMan() {
        return fechaMan;
    }

    public void setFechaMan(Date fechaMan) {
        this.fechaMan = fechaMan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getKilometrajeVehiculo() {
        return kilometrajeVehiculo;
    }

    public void setKilometrajeVehiculo(Integer kilometrajeVehiculo) {
        this.kilometrajeVehiculo = kilometrajeVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaMan != null ? fechaMan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimientos)) {
            return false;
        }
        Mantenimientos other = (Mantenimientos) object;
        if ((this.fechaMan == null && other.fechaMan != null) || (this.fechaMan != null && !this.fechaMan.equals(other.fechaMan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Mantenimientos[ fechaMan=" + fechaMan + " ]";
    }

    public Mantenimientos(Integer idVehiculo, String cedulaCliente, Date fechaMan, String descripcion, Integer kilometrajeVehiculo) {
        this.idVehiculo = idVehiculo;
        this.cedulaCliente = cedulaCliente;
        this.fechaMan = fechaMan;
        this.descripcion = descripcion;
        this.kilometrajeVehiculo = kilometrajeVehiculo;
    }
    
}
