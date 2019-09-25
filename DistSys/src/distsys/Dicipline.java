package distsys;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Objects;

public class Dicipline extends Diciplines {
    private String d_subarea, d_name;
    private int d_id;
    Dicipline (int d_id, String d_name, String d_subarea)
    {
        this.d_id=d_id;
        this.d_name=d_name;
        this.d_subarea=d_subarea;
    }

    public String getD_name() {
        return d_name;
    }

    public String getD_subarea() {
        return d_subarea;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public void setD_subarea(String d_subarea) {
        this.d_subarea = d_subarea;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.d_subarea);
        hash = 59 * hash + Objects.hashCode(this.d_name);
        hash = 59 * hash + this.d_id;
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
        final Dicipline other = (Dicipline) obj;
        if (this.d_id != other.d_id) {
            return false;
        }
        if (!Objects.equals(this.d_subarea, other.d_subarea)) {
            return false;
        }
        if (!Objects.equals(this.d_name, other.d_name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dicipline{" + "d_id=" + d_id + ", d_name=" + d_name + ", d_subarea=" + d_subarea + '}';
    }
    
    public static Comparator <Dicipline> DiciplineD_NameComparator = (Dicipline q1, Dicipline q2) ->
            {
                return q1.d_name.compareTo(q2.d_name);
            };
    
    public static ArrayList search(Diciplines l, String d_name, Comparator comparator)
    {
        ArrayList <Dicipline> diciplines = new ArrayList<>();
        for(Dicipline i: l.getDiciplines())
        {
            if(i.d_name.equals(d_name)) diciplines.add(i);
        }
        Collections.sort(diciplines, comparator);
        return diciplines;
    }
    
    public static Comparator <Dicipline> DiciplineD_SubareaComparator = (Dicipline q1, Dicipline q2) ->
            {
                return q1.d_subarea.compareTo(q2.d_subarea);
            };
    
    public static ArrayList search1(Diciplines l, String d_subarea, Comparator comparator)
    {
        ArrayList <Dicipline> diciplines = new ArrayList<>();
        for(Dicipline i: l.getDiciplines())
        {
            if(i.d_subarea.equals(d_subarea)) diciplines.add(i);
        }
        Collections.sort(diciplines, comparator);
        return diciplines;
    }
    
    public static ArrayList sortAndPrint(Diciplines l, Comparator comparator)
    {
        ArrayList <Dicipline> all_diciplines = new ArrayList<>();
        for (Dicipline i : l.getDiciplines())
        {
            all_diciplines.add(i);
        }
        Collections.sort(all_diciplines, comparator);
        return all_diciplines;
    }
    
}
