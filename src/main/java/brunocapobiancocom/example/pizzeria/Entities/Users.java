package brunocapobiancocom.example.pizzeria.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString

public class Users implements UserDetails
{
    @Id
    @GeneratedValue
    private UUID idUser;
    private String nome;
    private String cognome;
    private String nickname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private TIPO tipo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}


