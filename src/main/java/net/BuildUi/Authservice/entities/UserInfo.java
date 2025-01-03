package net.BuildUi.Authservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class UserInfo {
    @Setter
    @Id
    @Column(name = "user_id")
    private String userId;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_role")
    )
    private Set<UserRoles> roles = new HashSet<>();

}
