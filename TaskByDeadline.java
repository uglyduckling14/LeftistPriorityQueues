public class TaskByDeadline extends Task {
    //priority is based on deadline(second number);
    public TaskByDeadline(int ID, int start, int deadline, int duration) {
        super(ID, start,deadline,duration);
    }

    public int compareTo(Task task){
        return Integer.compare(this.deadline,task.deadline);
    }
}
