package brunocapobiancocom.example.pizzeria.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"password","authorities","AccountNonExpired","enabled", "accountNonLocked","credentialsNonExpired", "username"})
@RequiredArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails
{
    @Id
    @GeneratedValue
    private UUID idUser;
    @NonNull
    private String nome;
    @NonNull
    private String cognome;
    @NonNull
    private String nickname;
    @NonNull
    private String address;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @Enumerated(EnumType.STRING)
    @NonNull
    private ROLE role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
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


