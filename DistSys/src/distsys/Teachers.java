package distsys;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Teachers {
    private Set <Teacher> teachers = new HashSet<>();
    Teachers () {}
    public Set <Teacher> getTeachers()
    {
        return teachers;
    }
    public boolean addTeacher (Teacher teacher)
    {
        return teachers.add(teacher);
    }
        
    public boolean changeTeacher(Teacher value,Teacher newValue){
        boolean flag=false;
        Iterator<Teacher> it=teachers.iterator();

        while (it.hasNext()){
            if(it.next().equals(value)){
                flag=true;
                break;
            }
        }

        if(flag=true){
            teachers.remove(value);
            teachers.add(newValue);
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean deleteTeacher(Teacher value){
        boolean flag=false;
        Iterator<Teacher> it=teachers.iterator();

        while (it.hasNext()){
            if(it.next().equals(value)){
                flag=true;
                break;
            }
        }

        if(flag=true){
            teachers.remove(value);
            //teachers.add(newValue);
            return true;
        }
        else {
            return false;
        }
    }
    
}
