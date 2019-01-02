package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query(value = "SELECT count(*) FROM recipe r WHERE r.admin_id = ?1", nativeQuery = true)
    int getUserRecipesCount(Long userId);

    @Query("SELECT r from Recipe r where r.admin.id =?1")
    List<Recipe> getRecipesByUserId(Long userId);

    Recipe getOneByIdAndAdminId(Long recipeId, Long userId);

    List<Recipe> findAllByOrderByIdDesc();
}

