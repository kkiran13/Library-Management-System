package com.library.storage;

import com.library.model.BookBody;
import com.library.utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by kkiran on 2/12/18.
 */
public class MySqlStorage {

    public void newBookStorage(BookBody book) {
        Session session = HibernateUtil.getSessionJavaConfigFactory(book.getClass()).getCurrentSession();
        try {
            //start transaction
            session.beginTransaction();
            //Save the Model object
            session.save(book);
            //Commit transaction
            session.getTransaction().commit();
            System.out.println("Added book ID="+book.getId());
            //terminate session factory, otherwise program won't end
            session.close();
        } catch (Exception e) {
            System.out.println("Add book storage exception: "+e.getMessage());
        }
    }

    public void deleteBookStorage(BookBody book) {
        Session session = HibernateUtil.getSessionJavaConfigFactory(book.getClass()).getCurrentSession();
        try {
            //start transaction
            session.beginTransaction();
            //Save the Model object
            session.delete(book);
            //Commit transaction
            session.getTransaction().commit();
            System.out.println("Delete book ID="+book.getId());
            //terminate session factory, otherwise program won't end
            session.close();
        } catch (Exception e) {
            System.out.println("Delete book storage exception: "+e.getMessage());
        }
    }

}
