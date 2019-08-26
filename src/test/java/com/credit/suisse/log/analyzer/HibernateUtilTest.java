package com.credit.suisse.log.analyzer;

import com.credit.suisse.log.analyzer.utility.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

/*
 * Class to test Hibernate Utilities.
 * Author ; Harish Deore
 */
public class HibernateUtilTest {

    @Test
    public void testSessionFactoryLoad() {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Assert.assertNotNull(sessionFactory);
    }

    @Test
    public void testGetSessionFactoryLoad() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Assert.assertNotNull(sessionFactory);
    }
}
