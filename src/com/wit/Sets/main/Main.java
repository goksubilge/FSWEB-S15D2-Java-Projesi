package com.wit.Sets.main;

import com.wit.Sets.enums.Priority;
import com.wit.Sets.enums.Status;
import com.wit.Sets.models.Task;
import com.wit.Sets.models.TaskData;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("java collecs", "Write List", "ann", Priority.LOW, Status.ASSIGNED);
        Task task2 = new Task("java collecs", "Write Set", "bob", Priority.MED, Status.IN_QUEUE);
        Task task3 = new Task("java collecs", "Write Map", "carol", Priority.HIGH, Status.IN_PROGRESS);
        Task task4 = new Task("java collecs", "Write Queue", "Bella", Priority.LOW, Status.ASSIGNED);
        Task task5 = new Task("java collecs", "Write Stack", "Pamela", Priority.MED, Status.IN_QUEUE);
        Task task6 = new Task("java collecs", "Write Collection", "Bilge", Priority.HIGH, Status.IN_PROGRESS);
        Task task7 = new Task("java collecs", "Write Set", "bob", Priority.MED, Status.IN_QUEUE);

        Set<Task> Totalss = new HashSet<>();
        Totalss.add(task1);
        Totalss.add(task2);
        Totalss.add(task3);
        Totalss.add(task4);
        Totalss.add(task5);
        Totalss.add(task6);
        Totalss.add(task7);

        Set<Task> anns = new LinkedHashSet<>();
        anns.add(task1);
        anns.add(task2);

        Set<Task> bobs = new LinkedHashSet<>();
        bobs.add(task3);
        bobs.add(task2);

        Set<Task> carols = new LinkedHashSet<>();
        carols.add(task4);  // Bella'yı Carol'a atadım. o yüzden fark aldığımda atanmayan task sonucunda  yok.
        carols.add(task7);

        Set<Task> unassigned = new LinkedHashSet<>();
        unassigned.add(task2);

        TaskData taskData = new TaskData(anns, bobs, carols, unassigned );

        System.out.println(taskData.getTasks("ann"));
        System.out.println(taskData.getTasks("bob"));
        System.out.println(taskData.getTasks("carol"));
        System.out.println(taskData.getTasks("all"));
        System.out.println(taskData.getTasks("Bilge"));
        System.out.println(taskData.getTasks("all").size());
        System.out.println("Differences");
        System.out.println(taskData.getDifference(Totalss,taskData.getTasks("all")));
        System.out.println("Intersections");
        System.out.println("ANN + CAROL" + taskData.getIntersect(anns,carols));
        System.out.println("ANN + BOB" + taskData.getIntersect(anns,bobs));
        System.out.println("BOB + CAROL" + taskData.getIntersect(bobs,carols));
    }
}