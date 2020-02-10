package loggers;

import beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger  extends FileEventLogger implements EventLogger {
    private int cacheSize;
    List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);

        this.cache = new ArrayList<Event>();
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event) {
        cache.add(event);

        if(cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : this.cache) {
            super.logEvent(event);
        }
    }

    private void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
