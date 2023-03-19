import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) {
        //simpleQueueTest();
        //scheduleTasks("taskset1.txt");
        //scheduleTasks("taskset2.txt");
        //scheduleTasks("taskset3.txt");
        scheduleTasks("taskset4.txt");
        //scheduleTasks("taskset5.txt");
    }

    public static void scheduleTasks(String taskFile) {
        // TODO: Uncomment code here as you complete the tasks and scheduling algorithm
        ArrayList<Task> tasksByDeadline = new ArrayList<>();
        ArrayList<Task> tasksByStart = new ArrayList<>();
        ArrayList<Task> tasksByDuration = new ArrayList<>();

        readTasks(taskFile, tasksByDeadline, tasksByStart, tasksByDuration);

        schedule("Deadline Priority : "+ taskFile, tasksByDeadline);
        schedule("Startime Priority : " + taskFile, tasksByStart);
        schedule("Duration priority : " + taskFile, tasksByDuration);
    }

    public static void simpleQueueTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(9);
        queue.enqueue(7);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(10);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    /**
     * Reads the task data from a file, and creates the three different sets of tasks for each
     */
    public static void readTasks(String filename,
                                 ArrayList<Task> tasksByDeadline,
                                 ArrayList<Task> tasksByStart,
                                 ArrayList<Task> tasksByDuration) {
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            int i =1;
            while (scan.hasNextLine()) {
                String task = scan.nextLine();
                String[] taskList = task.split("\\s+");
                Task newstart = new TaskByStart(i, Integer.parseInt(taskList[0]), Integer.parseInt(taskList[1]), Integer.parseInt(taskList[2]));
                Task newdeadline = new TaskByDeadline(i, Integer.parseInt(taskList[0]), Integer.parseInt(taskList[1]), Integer.parseInt(taskList[2]));
                Task newduration = new TaskByDuration(i, Integer.parseInt(taskList[0]), Integer.parseInt(taskList[1]), Integer.parseInt(taskList[2]));
                tasksByDeadline.add(newdeadline);
                tasksByDuration.add(newduration);
                tasksByStart.add(newstart);
                i++;
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("File not Found!!!");
            e.printStackTrace();
        }
    }
    /**
     * Given a set of tasks, schedules them and reports the scheduling results
     */
    public static void schedule(String label, ArrayList<Task> tasks) {
        System.out.println(label);
        /*first number = start time;
          second number = deadline;
          third number = duration;
         */
        int unitTime=1;
        int late=0;
        int totalLate = 0;
        PriorityQueue<Task> queue = new PriorityQueue<>();
        for (Task task : tasks) {
            if (unitTime == task.start) {
                queue.enqueue(task);
            }
        }
        while(!tasks.isEmpty()) {
            if(queue.isEmpty()){
                System.out.println("\t Time "+unitTime+":\t --");
            }else {
                Task newTask = queue.dequeue();
                newTask.duration -= 1;
                if (newTask.duration > 0) {
                    System.out.println("\t Time " + unitTime + ":\t" + newTask.toString());
                    queue.enqueue(newTask);
                } else {
                    if (newTask.deadline < unitTime) {
                        System.out.println("\t Time " + unitTime + ":\t" + newTask.toString() + " ** " + "Late " + (unitTime- newTask.deadline));
                        late++;
                        totalLate+=unitTime- newTask.deadline;
                    } else {
                        System.out.println("\t Time " + unitTime + ":\t" + newTask.toString() + " ** ");
                    }
                    tasks.remove(newTask);
                }
            }
            unitTime++;
            for (Task task : tasks) {
                if (unitTime == task.start) {
                    queue.enqueue(task);
                }
            }
        }
        System.out.println("Tasks late "+ late +" Total Late "+ totalLate);
        System.out.println();
    }

}
