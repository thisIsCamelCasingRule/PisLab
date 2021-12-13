package entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Meal")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    @Id
    int id;
    String name;
    double calories;
    double fats;
    double proteins;
    double carbohydrates;

    public Meal(String name, double calories, double fats, double proteins, double carbohydrates){
        this.name = name;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.proteins = proteins;

    }
}
