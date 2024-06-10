package sit.int202.quizjpaprojectnew.repositories;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.quizjpaprojectnew.entities.Question;
import sit.int202.quizjpaprojectnew.service.EntityManagerService;

import java.util.List;

public class QuestionRepository {
    private EntityManager getEntityManager(){
        return EntityManagerService.getEntityManager();
    }

    public Question find(Long id){
        EntityManager entityManager = getEntityManager();
        Question question = entityManager.find(Question.class, id);
        entityManager.close();
        return question;
    }

    public List<Question> findAll(){
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT q FROM questions q");
        List<Question> questions = query.getResultList();
        entityManager.close();
        return questions;
    }

    public boolean save(Question question){
        try{
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(question);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }catch (Exception e){
            System.out.println("ERROR : " + e.getMessage());
            return false;
        }
    }

    public boolean update(Question question){
        try{
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(question);
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
            Question question = entityManager.find(Question.class, id);
            entityManager.remove(entityManager.contains(question) ? question : entityManager. merge(question));
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }catch (Exception e){
            System.out.println("ERROR : " + e.getMessage());
            return false;
        }
    }

}
