package entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String username;
    String password;
    int age;
    double weight;
    double height;
    int lifestyle;
}
