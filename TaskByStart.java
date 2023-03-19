public class TaskByStart extends Task {
    public TaskByStart(int ID, int start, int deadline, int duration) {
        super(ID, start,deadline,duration);
    }
    public int compareTo(Task task){
        if(this.start == task.start){
            return Integer.compare(this.deadline,task.deadline);
        }else{
            return Integer.compare(this.start,task.start);
        }
    }
}
