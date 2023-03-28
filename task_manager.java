import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

final class Task
{
    private String title;

    private Date date;

    private boolean favourite;

    public Task(String title, int year, int month, int day, int hours, int minutes)
    {
        this.title = title;
        this.date = new Date(year, month, day, hours, minutes);
        this.favourite = false;
    }

    public void makeFavourite()
    {
        this.favourite = true;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getDate()
    {
        return this.date.getYear() + "." + this.date.getMonth() + "." + this.date.getDate();
    }

    public String getTime()
    {
        return this.date.getHours() + ":" + this.date.getMinutes();
    }

    public boolean is_favourite()
    {
        return this.favourite;
    }

    public void setDate(int year, int month, int day)
    {
        this.date.setYear(year);
        this.date.setMonth(month);
        this.date.setDate(day);
    }

    public void setTime(int hour, int minutes)
    {
        this.date.setHours(hour);
        this.date.setMinutes(minutes);
    }
}

final class TaskManager
{
    private ArrayList<Task> tasks;

    public TaskManager()
    {
        this.tasks = new ArrayList<Task>();
    }

    public void add_task(Task task)
    {
        this.tasks.add(task);
    }

    public void get_data(String title)
    {
        for (int i = 0; i < this.tasks.size(); i++)
        {
            if (tasks.get(i).getTitle().equals(title))
            {
                System.out.println("Title: " + this.tasks.get(i).getTitle());
                System.out.println("Date: " + this.tasks.get(i).getDate());
                System.out.println("Time: " + this.tasks.get(i).getTime());
                System.out.println("Favourite: " + this.tasks.get(i).is_favourite());
            }
        }
    }

    public void makeFavouriteTask(String title)
    {
        for (int i = 0; i < this.tasks.size(); i++)
        {
            if (tasks.get(i).getTitle().equals(title))
            {
                this.tasks.get(i).makeFavourite();
            }
        }
    }

    public void show_tasks()
    {
        for (int i = 0; i < this.tasks.size(); i++)
        {
            int index = i+1;
            System.out.println("#" + index + " " + this.tasks.get(i).getTitle() + " " + this.tasks.get(i).getDate() + " " + this.tasks.get(i).getTime());
        }
    }

    public void changeDate(String title)
    {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < tasks.size(); i++)
        {
            if (this.tasks.get(i).getTitle().equals(title))
            {
                System.out.print("Enter year: ");
                int year = scanner.nextInt();

                System.out.print("Enter month: ");
                int month = scanner.nextInt();

                System.out.print("Enter day: ");
                int day = scanner.nextInt();

                this.tasks.get(i).setDate(year, month, day);
            }
        }
    }

    public void changeTime(String title)
    {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < this.tasks.size(); i++)
        {
            if (this.tasks.get(i).getTitle().equals(title))
            {
                System.out.print("Enter hours: ");
                int hours = scanner.nextInt();

                System.out.print("Enter minutes: ");
                int minutes = scanner.nextInt();

                this.tasks.get(i).setTime(hours, minutes);
            }
        }

    }

    public void deleteTask(String title)
    {
        for (int i = 0; i < this.tasks.size(); i++)
        {
            if (this.tasks.get(i).getTitle().equals(title))
            {
                tasks.remove(i);
                System.out.println(title + " has been deleted");
            }
        }
    }
}

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        TaskManager manager = new TaskManager();

        int choose;

        while (true)
        {
            System.out.print("Choose action:\n1. add task\n2. show tasks\n3. get task data\n4. make favourite task\n5. change date\n6. change time\n7. delete task\n\nAction: ");
            choose = scanner.nextInt();

            String title;

            int year, month, day, hour, minutes;

            switch (choose)
            {
                case 1:

                    System.out.print("Enter title: ");
                    title = scanner.next();

                    System.out.print("Enter year: ");
                    year = scanner.nextInt();

                    System.out.print("Enter month: ");
                    month = scanner.nextInt();

                    System.out.print("Enter day: ");
                    day = scanner.nextInt();

                    System.out.print("Enter hour: ");
                    hour = scanner.nextInt();

                    System.out.print("Enter minutes: ");
                    minutes = scanner.nextInt();

                    Task task = new Task(title, year, month, day, hour, minutes);

                    manager.add_task(task);

                    break;

                case 2:

                    manager.show_tasks();

                    break;

                case 3:

                    System.out.print("Enter title: ");
                    title = scanner.next();

                    manager.get_data(title);

                    break;

                case 4:

                    System.out.print("Enter title: ");
                    title = scanner.next();

                    manager.makeFavouriteTask(title);

                    break;

                case 5:

                    System.out.print("Enter title: ");
                    title = scanner.next();

                    manager.changeDate(title);
                    break;

                case 6:

                    System.out.print("Enter title: ");
                    title = scanner.next();

                    manager.changeTime(title);
                    break;

                case 7:

                    System.out.print("Enter title: ");
                    title = scanner.next();

                    manager.deleteTask(title);
                    break;

            }
        }
    }
}
