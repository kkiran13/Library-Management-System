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
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(book);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Book ID="+book.getId());
        //terminate session factory, otherwise program won't end
        session.close();
    }

}
