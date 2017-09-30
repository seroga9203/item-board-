package spring;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextHolder {

    private static final AbstractXmlApplicationContext context;

    static {
        try {
            context = new ClassPathXmlApplicationContext("spring-config.xml");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error initializing context");
        }
    }

    public static AbstractXmlApplicationContext getContext() {
        return context;
    }
}
