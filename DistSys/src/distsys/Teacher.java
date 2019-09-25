package distsys;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Objects;

public class Teacher extends Teachers {
    private String t_name, d_name;
    private int t_id;
    Teacher (int t_id, String t_name, String d_name)
    {
        this.t_id=t_id;
        this.t_name=t_name;
        this.d_name=d_name;
    }

    public String getT_name() {
        return t_name;
    }

    public String getD_name() {
        return d_name;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    @Override
    public String toString() {
        return "Teacher{" + "t_id=" + t_id + ", name: " + t_name + ", dicipline: " + d_name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.t_name);
        hash = 37 * hash + Objects.hashCode(this.d_name);
        hash = 37 * hash + this.t_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Teacher other = (Teacher) obj;
        if (this.t_id != other.t_id) {
            return false;
        }
        if (!Objects.equals(this.t_name, other.t_name)) {
            return false;
        }
        if (!Objects.equals(this.d_name, other.d_name)) {
            return false;
        }
        return true;
    }
    
    public static Comparator <Teacher> TeacherT_NameComparator = (Teacher q1, Teacher q2) ->
            {
                return q1.t_name.compareTo(q2.t_name);
            };
    
    public static ArrayList search(Teachers l, String t_name, Comparator comparator)
    {
        ArrayList <Teacher> teachers = new ArrayList<>();
        for(Teacher i: l.getTeachers())
        {
            if(i.t_name.equals(t_name)) teachers.add(i);
        }
        Collections.sort(teachers, comparator);
        return teachers;
    }
    
    public static Comparator <Teacher> TeacherD_NameComparator = (Teacher q1, Teacher q2) ->
            {
                return q1.t_name.compareTo(q2.t_name);
            };
    
    public static ArrayList search1(Teachers l, String d_name, Comparator comparator)
    {
        ArrayList <Teacher> teachers = new ArrayList<>();
        for(Teacher i: l.getTeachers())
        {
            if(i.d_name.equals(d_name)) teachers.add(i);
        }
        Collections.sort(teachers, comparator);
        return teachers;
    }
    
    public static ArrayList sortAndPrint(Teachers l, Comparator comparator)
    {
        ArrayList <Teacher> all_teachers = new ArrayList<>();
        for (Teacher i : l.getTeachers())
        {
            all_teachers.add(i);
        }
        Collections.sort(all_teachers, comparator);
        return all_teachers;
    }
    
}
