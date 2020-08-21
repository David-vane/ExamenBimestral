/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByIDVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.iDVehiculo = :iDVehiculo")
    , @NamedQuery(name = "Vehiculo.findByA\u00f1o", query = "SELECT v FROM Vehiculo v WHERE v.a\u00f1o = :a\u00f1o")
    , @NamedQuery(name = "Vehiculo.findByNumPasajeros", query = "SELECT v FROM Vehiculo v WHERE v.numPasajeros = :numPasajeros")
    , @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculo.findByCilindraje", query = "SELECT v FROM Vehiculo v WHERE v.cilindraje = :cilindraje")
    , @NamedQuery(name = "Vehiculo.findByPaisFabrica", query = "SELECT v FROM Vehiculo v WHERE v.paisFabrica = :paisFabrica")
    , @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa")
    , @NamedQuery(name = "Vehiculo.findByConcensionario", query = "SELECT v FROM Vehiculo v WHERE v.concensionario = :concensionario")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVehiculo")
    private Integer iDVehiculo;
    @Column(name = "A\u00f1o")
    private Integer año;
    @Column(name = "NumPasajeros")
    private Integer numPasajeros;
    @Size(max = 50)
    @Column(name = "Modelo")
    private String modelo;
    @Size(max = 50)
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Cilindraje")
    private Integer cilindraje;
    @Size(max = 20)
    @Column(name = "PaisFabrica")
    private String paisFabrica;
    @Size(max = 10)
    @Column(name = "Placa")
    private String placa;
    @Size(max = 15)
    @Column(name = "concensionario")
    private String concensionario;

    public Vehiculo() {
    }

    public Vehiculo(Integer iDVehiculo) {
        this.iDVehiculo = iDVehiculo;
    }

    public Integer getIDVehiculo() {
        return iDVehiculo;
    }

    public void setIDVehiculo(Integer iDVehiculo) {
        this.iDVehiculo = iDVehiculo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Integer getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(Integer numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getPaisFabrica() {
        return paisFabrica;
    }

    public void setPaisFabrica(String paisFabrica) {
        this.paisFabrica = paisFabrica;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getConcensionario() {
        return concensionario;
    }

    public void setConcensionario(String concensionario) {
        this.concensionario = concensionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDVehiculo != null ? iDVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.iDVehiculo == null && other.iDVehiculo != null) || (this.iDVehiculo != null && !this.iDVehiculo.equals(other.iDVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Vehiculo[ iDVehiculo=" + iDVehiculo + " ]";
    }
    
}
