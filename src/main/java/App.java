import beans.Client;
import beans.Event;
import loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private final Client client;
    private final EventLogger eventLogger;

    public App(EventLogger eventLogger, Client client){
        this.eventLogger = eventLogger;
        this.client = client;
    }

    public static void main(String[] args) {
//        ApplicationContext parent = new ClassPathXmlApplicationContext("spring.xml");
//        ApplicationContext child = new ClassPathXmlApplicationContext("spring.xml", parent);

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        for(int i = 0; i < 5; i++) {
            app.logEvent((Event) ctx.getBean("event"));
        }

        ctx.close();
    }

    public void logEvent(Event e) {
        this.eventLogger.logEvent(e);;
    }
}
