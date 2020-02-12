package loggers;

import beans.Event;
import beans.EventType;

public interface EventLogger {
    void logEvent(Event event);
}
