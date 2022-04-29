package az.iktlab.groupj4web.dao.entity;

import az.iktlab.groupj4web.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person", schema = "group_j4")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;

    @Column(name = "p_name",
            length = 32,
            nullable = false,
            unique = true)
    private String name;

    @Column(name = "p_surname")
    private String surname;

    @Column(name = "p_age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "p_gender")
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = CardEntity.class)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private CardEntity card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "person_images", schema = "group_j4",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id", referencedColumnName = "id"))
    private List<ImageEntity> images;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "people_employees", schema = "group_j4",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
    private List<EmployeeEntity> employees;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}