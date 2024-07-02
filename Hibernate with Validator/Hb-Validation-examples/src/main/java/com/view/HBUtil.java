package com.view;



	import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

	public class HBUtil {
		private static StandardServiceRegistry registry=null;
		private static SessionFactory sessionFactory=null;
		public static SessionFactory getSessionFactory() {
			if(registry!=null) {
				try {

			registry=new StandardServiceRegistryBuilder().configure("hibernet.cfg.xml").build();
					MetadataSources sources=new MetadataSources(registry);
			        Metadata metadata=sources.getMetadataBuilder().build();
			        sessionFactory=metadata.getSessionFactoryBuilder().build();
				}
				catch(Exception e) {
					if(registry!=null) {
						StandardServiceRegistryBuilder.destroy(registry);
					}
					e.printStackTrace();
				}
			}
			return sessionFactory;
		}

	}
	
	
	
	
