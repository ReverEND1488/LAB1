
package distsys;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;



public class DistSys {

    static void call(){
        final Teachers t = new Teachers();
        final Diciplines d = new Diciplines();
        Comparator comparator1 = Teacher.TeacherT_NameComparator;
        Comparator comparator2 = Teacher.TeacherD_NameComparator;
        Comparator comparator3 = Dicipline.DiciplineD_NameComparator;
        Comparator comparator4 = Dicipline.DiciplineD_SubareaComparator;
        final SQLite sqlite = new SQLite();
        Connection connection = null;
        Statement statement = null;
        
        connection = sqlite.getConnection();
        statement = sqlite.getStatement();
        for(Teacher teacher : sqlite.getAllTeachers()) t.addTeacher(teacher);
        for(Dicipline dicipline : sqlite.getAllDisciplines()) d.addDicipline(dicipline);
        
        System.out.println("To start(continue) working you should choose table: 1 => teachers   2 => disciplines.");
        System.out.print("Print and confirm 1 or 2 to continue... ");
        
        Scanner scan = new Scanner(System.in);
        int choose = Integer.parseInt(scan.nextLine());
        int finish = 0;
        int max_id = d.getSize();
        
        if (choose == 1)
        {
            System.out.println("You are working with teachers table now.");
            System.out.println("1 => Show table");
            System.out.println("2 => Add teacher");
            System.out.println("3 => Update informarion");
            System.out.println("4 => Remove teacher");
            System.out.println("5 => Search for a teacher");
            System.out.println("6 => Ooops, wrong button, go to diciplines");
            System.out.println("7 => I'm done, finish it (EXIT from this table)");
            for (int p = 0; p<100; p++){
            System.out.print("According to your desires, choose proper number and confirm it... ");
            int chosen = Integer.parseInt(scan.nextLine());
            switch (chosen)
            {
                case 1: 
                    ArrayList <Teacher> teachers = Teacher.sortAndPrint(t, comparator1);
                    if(!teachers.isEmpty())
                    {  
                        for(Teacher i: teachers) {
                        System.out.println(i);
                        }
                    }
                    else System.out.println("No teachers here. ERROR");
                break;
                case 2: 
                    System.out.println("Input new teacher's id (or use old id and t_name to add new subject for teacher)... ");
                    int id = Integer.parseInt(scan.nextLine());
                    System.out.println("Input new teacher's surname and initials as in an example (Ivanov I.I.)... ");
                    String name = scan.nextLine();
                    System.out.println("Input school discipline to be taught by the teacher... ");
                    String lesson = scan.nextLine();
                    Teacher teacher = new Teacher(id, name, lesson);
                    if(t.addTeacher(teacher))
                    {
                        try
                        {
                            statement.execute(sqlite.CreateT(id, name, lesson));
                            System.out.println("New teacher was added");
                        }
                        catch (Exception ex)
                        {
                            System.out.println("There is a mistake with this query! " + ex.getMessage());
                        }
                    }
                    else
                    {
                        System.out.println("This teacher is already exists");
                    }
                break;
                case 3: {
                    System.out.println("Input teacher's id, whose info you want to update... ");
                    id = Integer.parseInt(scan.nextLine());
                    System.out.println("Input teacher's surname and initials as in an example (Ivanov I.I.), whose info you want to update... ");
                    name = scan.nextLine();
                    System.out.println("Input school discipline to be taught by the teacher, whose info you want to update... ");
                    lesson = scan.nextLine();
                    System.out.println("Input new name of school subject... ");
                    String updateinfo = scan.nextLine();
                    try
                    {
                        statement.executeUpdate(sqlite.UpdateT(id, name, lesson, updateinfo));
                        System.out.println("Information about chosen teacher was changed");
                        t.changeTeacher(new Teacher(id, name, lesson), new Teacher (id, name, updateinfo));
                    }
                    catch (Exception ex)
                        {
                            System.out.println("There is a mistake with this query! " + ex.getMessage());
                        }
                break;
                }
                case 4: 
                    System.out.println("Input teacher's id, who should be deleted... ");
                    id = Integer.parseInt(scan.nextLine());
                    System.out.println("Input teacher's surname and initials as in an example (Ivanov I.I.), who should be deleted... ");
                    name = scan.nextLine();
                    System.out.println("Input school discipline to be taught by the teacher, who should be deleted... ");
                    lesson = scan.nextLine();
                    try
                    {
                        statement.execute(sqlite.DeleteT(id, name, lesson));
                        System.out.println("Teacher has been deleted");
                        t.deleteTeacher(new Teacher(id, name, lesson));
                    }
                    catch (Exception ex)
                        {
                            System.out.println("There is a mistake with this query! " + ex.getMessage());
                        }
                break;
                case 5: 
                    System.out.println("Input and confirm: 1 => to search by name;  2 => to search by discipline... ");
                    int typeOfSearch = Integer.parseInt(scan.nextLine());
                    if (typeOfSearch == 1) 
                    {
                    System.out.println("Input teacher's name to search... ");
                    name = scan.nextLine();
                    ArrayList <Teacher> temp_teachers = Teacher.search(t, name, comparator1);
                    for(Teacher i: temp_teachers) {System.out.println(i);}
                    }
                    else if (typeOfSearch == 2)
                    {
                        System.out.println("Input discipline to search... ");
                    lesson = scan.nextLine();
                    ArrayList <Teacher> temp_teachers = Teacher.search1(t, lesson, comparator2);
                    for(Teacher i: temp_teachers) {System.out.println(i);}
                    }
                    else System.out.print("Mistakes were made, u r 2 stupid 2 work with such easy prog, see u next time!");
                break;
                case 6: call()
                        ;
                break;
                case 7: finish = 1;
                break;
                default: System.out.print("Mistakes were made, u r 2 stupid 2 work with such easy prog, see u next time!");
                break;
            }
            if(finish>0) break;
        }
        }
        else if (choose == 2)
        {
            System.out.println("You are working with diciplines table now.");
            System.out.println("1 => Show table");
            System.out.println("2 => Add dicipline");
            System.out.println("3 => Update informarion");
            System.out.println("4 => Remove dicipline");
            System.out.println("5 => Search for a dicipline");
            System.out.println("6 => Ooops, wrong button, go to teachers");
            System.out.println("7 => I'm done, finish it (EXIT from this table)");
            for (int p = 0; p<100; p++){
            System.out.print("According to your desires, choose proper number and confirm it... ");
            int chosen = Integer.parseInt(scan.nextLine());
            switch (chosen)
            {
                case 1: 
                    ArrayList <Dicipline> disciplines = Dicipline.sortAndPrint(d, comparator3);
                    if(!disciplines.isEmpty())
                    {  
                        for(Dicipline i: disciplines) {
                        System.out.println(i);
                        }
                    }
                    else System.out.println("No disciplines here. ERROR");
                break;
                case 2: 
                    max_id++;
                    System.out.println("Input new discipline's name... ");
                    String name = scan.nextLine();
                    System.out.println("Input school discipline's subject area... ");
                    String area = scan.nextLine();
                    Dicipline dicipline = new Dicipline(max_id, name, area);
                    if(d.addDicipline(dicipline))
                    {
                        try
                        {
                            statement.execute(sqlite.CreateD(name, area));
                            System.out.println("New discipline was added");
                        }
                        catch (Exception ex)
                        {
                            System.out.println("There is a mistake with this query! " + ex.getMessage());
                        }
                    }
                    else
                    {
                        System.out.println("This discipline is already exists");
                    }
                break;
                case 3: 
                    System.out.println("Input discipline's id, whisch info you want to update... ");
                    int id = Integer.parseInt(scan.nextLine());
                    System.out.println("Input and confirm 1-3: 1 => change name of discipline   2 => change subject area    3 => both...");
                    int change = Integer.parseInt(scan.nextLine());
                    String updateinfo1 = "";
                    String updateinfo2 = "";
                    switch (change)
                    {
                        case 1: 
                            System.out.println("Input new name for discipline... ");
                            updateinfo1 = scan.nextLine();
                            d.changeDicipline1(id, updateinfo1);
                        break;
                        case 2: 
                            System.out.println("Input new subject area for discipline... ");
                            updateinfo2 = scan.nextLine();
                            d.changeDicipline2(id, updateinfo2);
                        break;
                        case 3: 
                            System.out.println("Input new name for discipline... ");
                            updateinfo1 = scan.nextLine();
                            System.out.println("Input new subject area for discipline... ");
                            updateinfo2 = scan.nextLine();
                            d.changeDicipline3(id, new Dicipline(id, updateinfo1, updateinfo2));
                        break;
                        default: System.out.print("Mistakes were made, u r 2 stupid 2 work with such easy prog, see u next time!");
                        break;
                    }
                    try
                    {
                        switch (change)
                        {
                            case 1: statement.executeUpdate(sqlite.UpdateD1(id, updateinfo1));
                                break;
                            case 2: statement.executeUpdate(sqlite.UpdateD2(id, updateinfo2));
                                break;
                            case 3: statement.executeUpdate(sqlite.UpdateD3(id, updateinfo1, updateinfo2));
                                break;
                        }
                        System.out.println("Information about chosen discipline was changed");
                    }
                    catch (Exception ex)
                        {
                            System.out.println("There is a mistake with this query! " + ex.getMessage());
                        }
                break;
                case 4: 
                    System.out.println("Input discipline's id, which should be deleted... ");
                    id = Integer.parseInt(scan.nextLine());
                    try
                    {
                        statement.execute(sqlite.DeleteD(id));
                        System.out.println("Discipline has been deleted");
                        d.deleteDicipline(id);
                    }
                    catch (Exception ex)
                        {
                            System.out.println("There is a mistake with this query! " + ex.getMessage());
                        }
                break;
                case 5: 
                    System.out.println("Input and confirm: 1 => to search by name;  2 => to search by subject area... ");
                    int typeOfSearch = Integer.parseInt(scan.nextLine());
                    if (typeOfSearch == 1) 
                    {
                    System.out.println("Input discipline's name to search... ");
                    name = scan.nextLine();
                    ArrayList <Dicipline> temp_diciplines = Dicipline.search(d, name, comparator3);
                    for(Dicipline i: temp_diciplines) {System.out.println(i);}
                    }
                    else if (typeOfSearch == 2)
                    {
                    System.out.println("Input subject area to search... ");
                    String subarea = scan.nextLine();
                    ArrayList <Dicipline> temp_diciplines = Dicipline.search1(d, subarea, comparator4);
                    for(Dicipline i: temp_diciplines) {System.out.println(i);}
                    }
                    else System.out.print("Mistakes were made, u r 2 stupid 2 work with such easy prog, see u next time!");
                break;
                case 6: call();
                break;
                case 7: finish = 1;
                break;
                default: System.out.print("Mistakes were made, u r 2 stupid 2 work with such easy prog, see u next time!");
                break;
            }
            if(finish>0) break;
        }
        }
        else
        {
            System.out.print("Mistakes were made, u r 2 stupid 2 work with such easy prog, see u next time!");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome  to distance learning software module!");
        System.out.println("This module allows you to work with a database of teachers and subjects assigned to them.");
        System.out.println("/******************/");
        System.out.println("WARNING!!! To exit this program, you must close all tables you've opened before.");
        System.out.println("Responsibility for incorrectly selected items and further performance of the program lies with the user, not the developer.");
        //System.out.println("if u fucked up, reboot the program");
        System.out.println("/******************/");
        System.out.println("");
        call();
    }
    
}
