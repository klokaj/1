import java.util.*;

public class Column {
    String name;
    String type;
    ArrayList<Object> data;

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
}
