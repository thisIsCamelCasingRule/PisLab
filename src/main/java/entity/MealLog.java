package entity;

import lombok.*;
import org.eclipse.persistence.annotations.SerializedObject;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;


@Entity
@Table(name = "Meal_log")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "userId")
    int userId;
    @Column(name = "mealId")
    int mealId;
}
