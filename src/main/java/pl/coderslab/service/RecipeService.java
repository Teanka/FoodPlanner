package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dto.RecipeDTO;
import pl.coderslab.model.Recipe;
import pl.coderslab.repository.RecipeRepository;

import java.util.List;

@Service
@Transactional
public class RecipeService
{
    @Autowired
    RecipeRepository recipeRepository;

    public int getUserRecipesCount(Long userId)
    {
        return recipeRepository.getUserRecipesCount(userId);
    }

    public List<Recipe> findAllRecipesByUserId(Long userId)
    {
        return recipeRepository.getRecipesByUserId(userId);
    }

    public void save(Recipe recipe)
    {
        recipeRepository.save(recipe);
    }

    public RecipeDTO getOneIfUserCan(Long recipeId, Long userId)
    {
        Recipe recipe = recipeRepository.getOneByIdAndAdminId(recipeId, userId);
        return createRecipeDTO(recipe);
    }

    public List<Recipe> findAll() // with reverse order
    {
        return recipeRepository.findAllByOrderByIdDesc(); // return from newest to oldest
    }

    public RecipeDTO getOne(Long id)
    {
        Recipe recipe = recipeRepository.getOne(id);
        return createRecipeDTO(recipe);
    }


    private RecipeDTO createRecipeDTO(Recipe recipe)
    {
        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setCreated(recipe.getCreated());
        recipeDTO.setDescription(recipe.getDescription());
        recipeDTO.setId(recipe.getId());
        recipeDTO.setIngredients(recipe.getIngredients());
        recipeDTO.setName(recipe.getName());
        recipeDTO.setPreparation(recipe.getPreparation());
        recipeDTO.setPreparationTime(recipe.getPreparationTime());
        recipeDTO.setUpdated(recipe.getUpdated());

        return recipeDTO;
    }

    public Recipe find(Long id)
    {
        return recipeRepository.findOne(id);
    }

    public void update(Recipe recipe)
    {
        recipeRepository.save(recipe);
    }

    public void delete(Long id)
    {
        recipeRepository.delete(id);
    }
}
