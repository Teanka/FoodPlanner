package pl.coderslab.model;

import pl.coderslab.dto.RecipePlanDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "plan")
@SqlResultSetMapping(
        name = "LastPlanResult", // resultSet name
        classes = {
                @ConstructorResult(
                        targetClass = RecipePlanDTO.class, // target mapping class
                        columns = {
                                @ColumnResult(name = "day_name"), // column names returned by query in RIGHT order
                                @ColumnResult(name = "meal_name"),
                                @ColumnResult(name = "recipe_name"),
                                @ColumnResult(name = "recipe_id", type = Long.class) // target class (DTO) must have constructor for this columns in RIGHT order
                        }
                )
        }
)
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "LastPlanResult", // result set mapping name
                query = "SELECT day_name.name as day_name, meal_name,  recipe.name as recipe_name, recipe.id as recipe_id\n" +
                        "FROM recipe_plan\n" +
                        "       JOIN day_name on day_name.id=day_name_id\n" +
                        "       JOIN recipe on recipe.id=recipe_id WHERE\n" +
                        "    plan_id =  (SELECT MAX(id) from plan WHERE admin_id = ?1)\n" +
                        "ORDER by day_name.order_no, recipe_plan.order_no",
                resultClass = RecipePlanDTO.class, // this query will be mapped to RecipePlanDTO class
                resultSetMapping = "LastPlanResult") // result set mapping name
        ,
        @NamedNativeQuery(
                name = "UserPlanResult", // result set mapping name
                query = "SELECT day_name.name as day_name, meal_name,  recipe.name as recipe_name, recipe.id as recipe_id\n" +
                        "FROM recipe_plan\n" +
                        "       JOIN day_name on day_name.id=day_name_id\n" +
                        "       JOIN recipe on recipe.id=recipe_id WHERE\n" +
                        "    plan_id = ?1 AND admin_id = ?2\n" +
                        "ORDER by day_name.order_no, recipe_plan.order_no",
                resultClass = RecipePlanDTO.class, // this query will be mapped to RecipePlanDTO class
                resultSetMapping = "LastPlanResult") // result set mapping name
})
public class Plan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime created;

    @ManyToOne
    private Admin admin;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.REMOVE)
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

    public Admin getAdmin()
    {
        return admin;
    }

    public void setAdmin(Admin admin)
    {
        this.admin = admin;
    }

    @Override
    public String toString()
    {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", admin=" + admin +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(id, plan.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
