package distsys;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Diciplines {
    private Set <Dicipline> diciplines = new HashSet<>();
    Diciplines () {}
    public Set <Dicipline> getDiciplines()
    {
        return diciplines;
    }
    public boolean addDicipline (Dicipline dicipline)
    {
        return diciplines.add(dicipline);
    }
    
    public int getSize()
    {
        return diciplines.size();
    }
        
     public boolean changeDicipline1(int value, String newValue){
        Dicipline dcp=null;
        Iterator<Dicipline>it=diciplines.iterator();
        String text= "";

        while (it.hasNext()){
            dcp=it.next();
            text = dcp.getD_subarea();
            if(dcp.getD_id()==value){
                break;
            }
            else dcp=null;
        }

        if(dcp!=null){
               diciplines.remove(dcp);
               diciplines.add(new Dicipline(value, newValue, text));
           
            return true;
        }
        else {
            return false;
        }
    }
     
     public boolean changeDicipline2(int value, String newValue){
        Dicipline dcp=null;
        Iterator<Dicipline>it=diciplines.iterator();
        String text= "";

        while (it.hasNext()){
            dcp=it.next();
            text = dcp.getD_name();
            if(dcp.getD_id()==value){
                break;
            }
            else dcp=null;
        }

        if(dcp!=null){
               diciplines.remove(dcp);
               diciplines.add(new Dicipline(value, text, newValue));
           
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean changeDicipline3(int value,Dicipline newValue){
        Dicipline dcp=null;
        Iterator<Dicipline>it=diciplines.iterator();


        while (it.hasNext()){
            dcp=it.next();
            if(dcp.getD_id()==value){
                break;
            }
            else dcp=null;
        }

        if(dcp!=null){
               diciplines.remove(dcp);
               diciplines.add(newValue);
           
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean deleteDicipline(int value){
        Dicipline dcp=null;
        Iterator<Dicipline>it=diciplines.iterator();


        while (it.hasNext()){
            dcp=it.next();
            if(dcp.getD_id()==value){
                break;
            }
            else dcp=null;
        }

        if(dcp!=null){
               diciplines.remove(dcp);           
            return true;
        }
        else {
            return false;
        }
    }
}
