package com.wit.Sets.models;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unknownTasks;

    public Set<Task> getAnnsTasks() {return annsTasks;}
    public Set<Task> getBobsTasks() {return bobsTasks;}
    public Set<Task> getCarolsTasks() {return carolsTasks;}
    public Set<Task> getUnknownTasks() {return unknownTasks;}

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unknownTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unknownTasks = unknownTasks;
    }

    public Set<Task> getTasks(String taskOwner){
return annsTasks;
    }
}
