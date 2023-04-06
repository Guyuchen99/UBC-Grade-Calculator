package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Represents a log of grade calculator system events
 */

public class EventLog implements Iterable<Event> {
    private static EventLog theLog;
    private Collection<Event> events;

    // EFFECTS: prevent external construction using the Singleton Design Pattern
    private EventLog() {
        events = new ArrayList<Event>();
    }

    // EFFECTS: create an instance of EventLog if it doesn't already exist and returns it
    public static EventLog getInstance() {
        if (theLog == null)
            theLog = new EventLog();

        return theLog;
    }

    // EFFECTS: adds an event to the EventLog
    public void logEvent(Event e) {
        events.add(e);
    }

    // EFFECTS: clears the EventLog and logs the event.
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }

}
