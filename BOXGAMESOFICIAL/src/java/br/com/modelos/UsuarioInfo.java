/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bonato
 */
@Entity
@Table(name = "usuario_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioInfo.findAll", query = "SELECT u FROM UsuarioInfo u"),
    @NamedQuery(name = "UsuarioInfo.findByEmail", query = "SELECT u FROM UsuarioInfo u WHERE u.email = :email"),
    @NamedQuery(name = "UsuarioInfo.findBySexo", query = "SELECT u FROM UsuarioInfo u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "UsuarioInfo.findByTelefone", query = "SELECT u FROM UsuarioInfo u WHERE u.telefone = :telefone"),
    @NamedQuery(name = "UsuarioInfo.findByNascimento", query = "SELECT u FROM UsuarioInfo u WHERE u.nascimento = :nascimento")})
public class UsuarioInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SEXO")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONE")
    private int telefone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public UsuarioInfo() {
    }

    public UsuarioInfo(String email) {
        this.email = email;
    }

    public UsuarioInfo(String email, String sexo, int telefone, Date nascimento) {
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioInfo)) {
            return false;
        }
        UsuarioInfo other = (UsuarioInfo) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UsuarioInfo[ email=" + email + " ]";
    }
    
}
