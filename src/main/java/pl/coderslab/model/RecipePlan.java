package pl.coderslab.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "recipe_plan")
public class RecipePlan implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

//    @Id
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

//    @Id
    @ManyToOne
    @JoinColumn(name = "day_name_id")
    private DayName dayName;

    @Column(name = "order_no")
    private Integer order;

    @Column(name = "meal_name")
    private String mealName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayName getDayName()
    {
        return dayName;
    }

    public void setDayName(DayName dayName)
    {
        this.dayName = dayName;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

    public Plan getPlan()
    {
        return plan;
    }

    public void setPlan(Plan plan)
    {
        this.plan = plan;
    }

    public Integer getOrder()
    {
        return order;
    }

    public void setOrder(Integer order)
    {
        this.order = order;
    }

    public String getMealName()
    {
        return mealName;
    }

    public void setMealName(String mealName)
    {
        this.mealName = mealName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipePlan that = (RecipePlan) o;
        return Objects.equals(recipe, that.recipe) &&
                Objects.equals(plan, that.plan) &&
                Objects.equals(dayName, that.dayName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(recipe, plan, dayName);
    }

    @Override
    public String toString()
    {
        return "RecipePlan{" +
                "order=" + order +
                ", mealName='" + mealName + '\'' +
                '}';
    }
}
