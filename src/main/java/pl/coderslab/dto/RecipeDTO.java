package pl.coderslab.dto;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RecipeDTO
{
    private Long id;

    private String name;

    private String ingredients;

    private String description;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Integer preparationTime;

    private String preparation;

    public List<String> getIngridientsList() // call this method in jsp
    {
        List<String> ingridientsList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(this.ingredients, ",");
        while (st.hasMoreTokens())
        {
            ingridientsList.add(st.nextToken().trim());
        }
        return ingridientsList;
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

    @Override
    public String toString()
    {
        return "RecipeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", preparationTime=" + preparationTime +
                ", preparation='" + preparation + '\'' +
                '}';
    }
}
