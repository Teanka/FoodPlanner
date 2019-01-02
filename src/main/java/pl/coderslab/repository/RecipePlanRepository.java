package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.RecipePlan;

public interface RecipePlanRepository extends JpaRepository<RecipePlan, Long>
{
    public RecipePlan findByRecipeId(Long id);
}
