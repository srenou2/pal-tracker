package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

     private HashMap<Long,TimeEntry> myMap;
    public InMemoryTimeEntryRepository() {
        myMap = new HashMap<Long,TimeEntry>();
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        TimeEntry mytimeEntry = new TimeEntry(myMap.size()+1, timeEntry.getId(), timeEntry.getUserId(), timeEntry.getDate(),timeEntry.getHours() );
         myMap.put(Long.valueOf(myMap.size())+1,mytimeEntry);
        return mytimeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return myMap.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(myMap.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry mytimeEntry = new TimeEntry(id, timeEntry.getId(), timeEntry.getUserId(), timeEntry.getDate(),timeEntry.getHours() );
         myMap.put(id,mytimeEntry);
        return mytimeEntry;
    }

    @Override
    public void delete(Long id) {
        myMap.remove(id);
    }
}
