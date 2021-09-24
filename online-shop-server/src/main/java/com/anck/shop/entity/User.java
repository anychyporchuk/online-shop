package com.anck.shop.entity;

import com.anck.shop.entity.SchemaMetadata.UserTable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = UserTable.TABLENAME)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = UserTable.ID)
    private Long id;

    @Column(name = UserTable.FIRSTNAME)
    private String firstName;

    @Column(name = UserTable.LASTNAME)
    private String lastName;

    @Column(name = UserTable.PHONENUMBER)
    private String phoneNumber;

    @Column(name = UserTable.EMAIL)
    private String email;

    @Column(name = UserTable.PASSWORD)
    private char[] password;

    @Column(name = UserTable.REGISTEREDAT)
    private LocalDateTime registeredAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumber, email);
    }
}
