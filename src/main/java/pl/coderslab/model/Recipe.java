package pl.coderslab.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "recipe")
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(columnDefinition = "TEXT", nullable = false)
    private String ingredients;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    private LocalDateTime created;

    private LocalDateTime updated;

    @Column(name = "preparation_time")
    private Integer preparationTime;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String preparation;

    @ManyToOne
    private Admin admin;

    @OneToMany(mappedBy = "recipe")
    private List<RecipePlan> recipePlans;

    public List<RecipePlan> getRecipePlans()
    {
        return recipePlans;
    }

    public void setRecipePlans(List<RecipePlan> recipePlans)
    {
        this.recipePlans = recipePlans;
    }

    @PrePersist
    public void prePersist()
    {
        created = LocalDateTime.now(); // this field will be autofilled
    }

    @PreUpdate
    public void preUpdate()
    {
        updated = LocalDateTime.now();  // this field will be autofilled
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(String ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public LocalDateTime getCreated()
    {
        return created;
    }

    public void setCreated(LocalDateTime created)
    {
        this.created = created;
    }

    public LocalDateTime getUpdated()
    {
        return updated;
    }

    public void setUpdated(LocalDateTime updated)
    {
        this.updated = updated;
    }

    public Integer getPreparationTime()
    {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime)
    {
        this.preparationTime = preparationTime;
    }

    public String getPreparation()
    {
        return preparation;
    }

    public void setPreparation(String preparation)
    {
        this.preparation = preparation;
    }

    public Admin getAdmin()
    {
        return admin;
    }

    public void setAdmin(Admin admin)
    {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", preparationTime=" + preparationTime +
                ", preparation='" + preparation + '\'' +
                ", admin=" + admin +
                ", recipePlans=" + recipePlans +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
