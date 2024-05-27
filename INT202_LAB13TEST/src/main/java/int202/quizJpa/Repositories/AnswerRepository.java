package int202.quizJpa.Repositories;

import int202.quizJpa.Entities.Answer;
import int202.quizJpa.services.EntityManagerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


import java.util.List;

public class AnswerRepository extends BaseRepository<Answer, Long> {
    public EntityManager getEntityManager(){
        return EntityManagerService.getEntityManager();
    }

    public Answer find(Long id){
        EntityManager entityManager = getEntityManager();
        Answer answer = entityManager.find(Answer.class, id);
        entityManager.close();
        return answer;
    }

    public List<Answer> findAll(){
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT a FROM Answer a");
        List<Answer> answers = query.getResultList();
        entityManager.close();
        return answers;
    }

    public boolean save(Answer answer){
        try{
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(answer);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }catch (Exception e){
            System.out.println("ERROR : " + e.getMessage());
            return false;
        }
    }

    public boolean update(Answer answer){
        try{
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(answer);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }catch (Exception e){
            System.out.println("ERROR : " + e.getMessage());
            return false;
        }
    }

    public boolean delete(Long id){
        try{
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Answer answer = entityManager.find(Answer.class, id);
            entityManager.remove(entityManager.contains(answer) ? answer : entityManager. merge(answer));
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }catch (Exception e){
            System.out.println("ERROR : " + e.getMessage());
            return false;
        }
    }


}
