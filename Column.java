import java.util.*;

public class Column {
    String name;
    String type;
    ArrayList data;

    public Column(String _col,String _type){
        name = _col;
        type = _type;
        data = new ArrayList<>();
    }

    public Column(String _col, String _type, ArrayList<Object> _data){
        name = _col;
        type = _type;
        data = new ArrayList<>(_data);
    }

    public ArrayList<Integer> getAllIndex(Object value){
        ArrayList<Integer> tmpy = new ArrayList<>();
        int i  = 0;
        for(Object elem : data){
            if (elem == value){
                tmpy.add(i);
            }
            i++;
        }

        return tmpy;
    }
}
