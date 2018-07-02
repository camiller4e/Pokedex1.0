package db;

import models.Pokemon;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBPokemon {

    private static Session session;
    private static Transaction transaction;

    public static void save(Pokemon pokemon) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(pokemon);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Pokemon pokemon) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(pokemon);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Pokemon> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Pokemon> results = null;
        try {
            Criteria criteria = session.createCriteria(Pokemon.class);
            results = criteria.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Pokemon find(int id) {
        Pokemon result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Pokemon.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Pokemon)criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void deleteAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Pokemon.class);
            List<Pokemon> results = criteria.list();
            transaction = session.beginTransaction();
            for(Pokemon pokemon : results){
                session.delete(pokemon);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
