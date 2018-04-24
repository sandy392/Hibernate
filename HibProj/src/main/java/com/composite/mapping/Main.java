package com.composite.mapping;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String args[]) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
              
            transaction = session.beginTransaction();
                        
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setItemName("Groceries");
            purchaseOrder.setCity("Hyderabad");
            purchaseOrder.setStreet("Ameerpet");
            session.save(purchaseOrder);
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}