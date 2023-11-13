package com.wit.Sets.models;

import java.util.*;

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

    // Yalnızca Set ile yapılan, dizi şeklinde gönderme ile. bana daha kolay gelen (but doesn't work) // ClassCastExc err
    public Set<Task> getTasksExample(String taskOwner){
        if(taskOwner.equalsIgnoreCase("ann")){
            return annsTasks;
        }
        if(taskOwner.equalsIgnoreCase("bob")){
            return bobsTasks;
        }
        if(taskOwner.equalsIgnoreCase("carol")){
            return carolsTasks;
        }
        if(taskOwner.equalsIgnoreCase("all")){
            return  getUnionsExample(annsTasks,bobsTasks,carolsTasks);
        }
        return new HashSet<>();  // hiçbiri gelmezse boş bir array gönderdim.
    }
    public Set<Task> getUnionsExample(Set<Task>... toBeUnions) {
        Set<Task> totals = new LinkedHashSet<>();  // COPY
        for(Set<Task> G: toBeUnions){
            totals.add((Task)G);
        }
        return totals;
    }

    // Alternative (but works code)
    public Set<Task> getTasks(String taskOwner){
        if(taskOwner.equalsIgnoreCase("ann")){
            return annsTasks;
        }
        if(taskOwner.equalsIgnoreCase("bob")){
            return bobsTasks;
        }
        if(taskOwner.equalsIgnoreCase("carol")){
            return carolsTasks;
        }
        if(taskOwner.equalsIgnoreCase("all")){
            List<Set<Task>> arrayList = new ArrayList<>();
            arrayList.add(annsTasks);
            arrayList.add(bobsTasks);
            arrayList.add(carolsTasks);
            return  getUnion(arrayList);
        }
        return new HashSet<>();
    }
    public Set<Task> getUnion(List<Set<Task>> toBeUnion){
        Set<Task> total = new LinkedHashSet<>();  // HashSet<>(); verseydim bir sıralama olmayacaktı
        for(Set<Task> oneTaskSeti: toBeUnion){
            total.addAll(oneTaskSeti);
        }
        return total;
    }

    public Set<Task> getIntersect(Set<Task> firstCircle, Set<Task> secondCircle){
        Set<Task> inters = new HashSet<>(firstCircle);  // COPY
        inters.retainAll(secondCircle);
        return inters;

//        firstCircle.retainAll(secondCircle);
//        return firstCircle;
    }

    public Set<Task> getDifference(Set<Task> firstCircle, Set<Task> secondCircle){
        Set<Task> differs = new HashSet<>(firstCircle);  // COPY
        differs.removeAll(secondCircle);  // Neyin neyden farkı olduğuna dkkat et ! // 1. setten 2. seti siliyor.
        return differs;
    }
}
