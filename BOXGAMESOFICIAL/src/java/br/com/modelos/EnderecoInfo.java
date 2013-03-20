/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bonato
 */
@Entity
@Table(name = "endereco_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnderecoInfo.findAll", query = "SELECT e FROM EnderecoInfo e"),
    @NamedQuery(name = "EnderecoInfo.findById", query = "SELECT e FROM EnderecoInfo e WHERE e.id = :id"),
    @NamedQuery(name = "EnderecoInfo.findByRua", query = "SELECT e FROM EnderecoInfo e WHERE e.rua = :rua"),
    @NamedQuery(name = "EnderecoInfo.findByNumero", query = "SELECT e FROM EnderecoInfo e WHERE e.numero = :numero"),
    @NamedQuery(name = "EnderecoInfo.findByComplemento", query = "SELECT e FROM EnderecoInfo e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "EnderecoInfo.findByCep", query = "SELECT e FROM EnderecoInfo e WHERE e.cep = :cep"),
    @NamedQuery(name = "EnderecoInfo.findByCidade", query = "SELECT e FROM EnderecoInfo e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "EnderecoInfo.findByEstado", query = "SELECT e FROM EnderecoInfo e WHERE e.estado = :estado")})
public class EnderecoInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "RUA")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEP")
    private int cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CIDADE")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Endereco endereco;

    public EnderecoInfo() {
    }

    public EnderecoInfo(Integer id) {
        this.id = id;
    }

    public EnderecoInfo(Integer id, String rua, int numero, String complemento, int cep, String cidade, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnderecoInfo)) {
            return false;
        }
        EnderecoInfo other = (EnderecoInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EnderecoInfo[ id=" + id + " ]";
    }
    
}
