package com.exterro.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class SessionFactoryProvider {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	//private static final Logger logger = LoggerFactory.getLogger(SessionFactoryProvider.class);
	private SessionFactoryProvider() {
	}

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception ex) {
			// Make sure you log the exception, as it might be swallowed
			//logger.error("Initial SessionFactory creation failed." + ex);
			System.out.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
	//	logger.info("Session Created");
		System.out.println("Session Created");
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		
		getSessionFactory().close();
		//logger.info("Session Closed");
		System.out.println("Session Closed");
	}

}
