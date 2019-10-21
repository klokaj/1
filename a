import java.util.*;

//kkk
public class DataFrame {
    ArrayList<Column> data;
    public DataFrame(String[] _col, String[] _types){
        data = new ArrayList<Column>();
        for(int i = 0; i< _col.length ; i++) {
           Column newColumn = new Column(_col[i], _types[i]);
           data.add(newColumn);
        }
    }

    public DataFrame(ArrayList<Column> _data){
        data = new ArrayList<Column>();
        for(Column col: _data) {
            data.add( col );
        }
    }

    public int size(){
        return data.get(0).data.size();
    }

    public ArrayList<Object> get(String _colname){
        for(Column col : data){
            if(col.name == _colname){
                return col.data;
            }
        }
        return null;
    }

    public DataFrame get(String [] cols, boolean copy){
        ArrayList<Column> tmpy = new ArrayList<>();

        for(String colname : cols) {
            for (Column col : data) {
                if (colname == col.name) {
                    if(copy == false){
                        tmpy.add(col);
                    }
                    else{
                        tmpy.add(new Column(col.name, col.type, (ArrayList<Object>) col.data.clone()));
                    }
                }
            }

        }
        return new DataFrame(tmpy);
    }

    public void add(Object[] values){
        for(Column col : data){
            col.data.add(values[data.indexOf(col)]);
        }
    }

    public Object[] getRow(int rowIndex){
        Object[] row = new Object[data.size()];
        for(Column col : data){
            row[data.indexOf(col)] = col.data.get(rowIndex);
        }
        return row;
    }

    public String[] getColnames(){
        String[] colnames = new String[data.size()];
        for(Column col : data){
            colnames[data.indexOf(col)] = col.name;
        }
        return colnames;
    }

    public String[] getTypes(){
        String[] types = new String[data.size()];
        for(Column col : data){
            types[data.indexOf(col)] = col.type;
        }
        return types;
    }

    public DataFrame iloc(int i){
        DataFrame df = new  DataFrame(getColnames(), getTypes());
        df.add(getRow(i));
        return df;
    }

    public DataFrame iloc(int  from, int to){
        DataFrame df = new  DataFrame(getColnames(), getTypes());

        for(int i = from; i < to; i++){
            df.add(getRow(i));
        }
        return df;
    }
}
