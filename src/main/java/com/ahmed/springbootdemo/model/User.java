package com.ahmed.springbootdemo.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "app_user")
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is Requiered")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must be at most 60")
    private int age;

    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
     */
}