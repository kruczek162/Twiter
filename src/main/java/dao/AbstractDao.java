package dao;

import hibernate.util.HibernateConfig;


import javax.persistence.EntityManager;

public abstract class AbstractDao {
    protected final HibernateConfig hibernateConfig = HibernateConfig.getInstance();
    protected final EntityManager entityManager = hibernateConfig.getEntityManager();


}
