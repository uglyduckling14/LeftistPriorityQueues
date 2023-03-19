public class TaskByDuration extends Task{
    public TaskByDuration(int ID, int start, int deadline, int duration) {
        super(ID, start,deadline,duration);
    }
    public int compareTo(Task task){
        return Integer.compare(this.duration,task.duration);
    }
}
