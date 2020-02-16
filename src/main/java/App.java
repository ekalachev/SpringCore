import beans.Client;
import beans.Event;
import beans.EventType;
import loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private final Client client;
    private final EventLogger eventLogger;
    private final Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
//        ApplicationContext parent = new ClassPathXmlApplicationContext("spring.xml");
//        ApplicationContext child = new ClassPathXmlApplicationContext("spring.xml", parent);

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        for (int i = 0; i < 5; i++) {
            if (i % 2.0 == 0)
                app.logEvent(EventType.INFO, (Event) ctx.getBean("event"));
            else
                app.logEvent(EventType.ERROR, (Event) ctx.getBean("event"));
        }

        ctx.close();
    }

    public void logEvent(EventType type, Event event) {
        EventLogger logger = loggers.get(type);

        if (logger == null) {
            logger = this.eventLogger;
        }

        logger.logEvent(event);
    }
}
