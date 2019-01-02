--SQL pobierający szczegóły posiłków w określonym planie
SELECT day_name.name as day_name, meal_name, recipie.name as recipie_name, recipie.description as recipie_description
FROM `recipie_plan`
JOIN day_name on day_name.id=day_name_id
JOIN recipie on recipie.id=recipie_id WHERE plan_day_id = 1 -- zamiast 1 należy wstawić id planu do pobrania --
ORDER by day_name.order, recipie_plan.order


-- SQL - pobiera najnowszy plan dla zadanego użytkownika (tabela admins)
SELECT day_name.name as day_name, meal_name,  recipie.name as recipie_name, recipie.description as recipie_description
FROM `recipie_plan`
JOIN day_name on day_name.id=day_name_id
JOIN recipie on recipie.id=recipie_id WHERE
plan_day_id =  (SELECT MAX(id) from plan WHERE admin_id = 1) -- zamiast 1 należy wstawić id użytkownika (tabela admins) --
ORDER by day_name.order, recipie_plan.order