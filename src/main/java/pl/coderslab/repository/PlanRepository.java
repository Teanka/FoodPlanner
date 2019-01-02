package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.dto.RecipePlanDTO;
import pl.coderslab.model.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long>
{
    @Query(value = "SELECT count(*) FROM plan p WHERE p.admin_id = ?1", nativeQuery = true)
    int getUserPlansCount(Long userId);

    @Query(nativeQuery = true, name = "LastPlanResult")
    List<RecipePlanDTO> findUserLastPlan(Long userId); // mapped to RecipePlanDTO in Plan entity

    @Query(nativeQuery = true, name = "UserPlanResult")
    List<RecipePlanDTO> findUserPlan(Long planId, Long userId); // mapped to RecipePlanDTO in Plan entity

    @Query(value = "SELECT name FROM plan WHERE id = (SELECT MAX(id) FROM plan WHERE admin_id = ?1)", nativeQuery = true)
    String getLastPlanName(Long userId);

    List<Plan> findAllByAdminId(Long userId);
}
