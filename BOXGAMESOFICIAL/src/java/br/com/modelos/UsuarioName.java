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
@Table(name = "usuario_name")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioName.findAll", query = "SELECT u FROM UsuarioName u"),
    @NamedQuery(name = "UsuarioName.findByEmail", query = "SELECT u FROM UsuarioName u WHERE u.email = :email"),
    @NamedQuery(name = "UsuarioName.findByNome", query = "SELECT u FROM UsuarioName u WHERE u.nome = :nome"),
    @NamedQuery(name = "UsuarioName.findBySobrenome", query = "SELECT u FROM UsuarioName u WHERE u.sobrenome = :sobrenome")})
public class UsuarioName implements Serializable {
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
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SOBRENOME")
    private String sobrenome;
    @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public UsuarioName() {
    }

    public UsuarioName(String email) {
        this.email = email;
    }

    public UsuarioName(String email, String nome, String sobrenome) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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
        if (!(object instanceof UsuarioName)) {
            return false;
        }
        UsuarioName other = (UsuarioName) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UsuarioName[ email=" + email + " ]";
    }
    
}
