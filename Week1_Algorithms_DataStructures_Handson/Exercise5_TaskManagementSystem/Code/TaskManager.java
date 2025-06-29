public class TaskManager {
    Task head = null;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println("Task added.");
    }

    public void searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list empty.");
            return;
        }
        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }
        Task current = head;
        while (current.next != null) {
            if (current.next.taskId == id) {
                current.next = current.next.next;
                System.out.println("Task deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(1, "Design Database", "Pending");
        manager.addTask(2, "Implement API", "In Progress");
        manager.addTask(3, "Test Application", "Pending");

        System.out.println("\nAll Tasks:");
        manager.displayTasks();

        System.out.println("\nSearching Task ID 2:");
        manager.searchTask(2);

        System.out.println("\nDeleting Task ID 2:");
        manager.deleteTask(2);

        System.out.println("\nTasks after deletion:");
        manager.displayTasks();
    }
}
