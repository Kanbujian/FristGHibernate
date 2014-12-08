package com.test.DAO;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("deprecation")
public class HibernateUtil {
    private static final ThreadLocal<Session> threadLocal =new ThreadLocal<Session>();
    public  static SessionFactory sessionFactory=null;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration cfg=new Configuration().configure();
            sessionFactory = cfg.buildSessionFactory(new ServiceRegistryBuilder().buildServiceRegistry());
        } catch (Exception e) {
            // Make sure you log the exception, as it might be swallowed
            System.out.println("创建会话工厂失败." );
            e.printStackTrace();
        }
    }

   

    public static Session getSession() throws HibernateException {
    	System.out.println("正在获取session");
    	Session s = (Session) threadLocal.get();
        
        // Open a new Session, if this thread has none yet
        if (s == null||!s.isOpen()) {
            if(sessionFactory==null){
            	rebuildSessionFactory();
            	
            }
            	s = (sessionFactory!=null)?sessionFactory.openSession():null;
            // Store it in the ThreadLocal variable
            threadLocal.set(s);
        }
        return s;
    }

    private static void rebuildSessionFactory() {
		// TODO Auto-generated method stub
    	 try {
             // Create the SessionFactory from hibernate.cfg.xml
         	Configuration cfg=new Configuration().configure();
             sessionFactory = cfg.buildSessionFactory(new ServiceRegistryBuilder().buildServiceRegistry());
         } catch (Exception e) {
             // Make sure you log the exception, as it might be swallowed
             System.out.println("创建会话工厂失败1." );
             e.printStackTrace();
         }
	}

	public static void closeSession() throws HibernateException {
        Session s = (Session) threadLocal.get();
        if (s != null)
            s.close();
       threadLocal.set(null);
    }
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}