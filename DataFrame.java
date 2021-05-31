import java.util.*;

//kkk
public class DataFrame{
    ArrayList<Column> data;

    public  DataFrame(){}
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

    public Column getColumn(String _colname){
        for(Column col : data){
            if(col.name == _colname){
                return col;
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

    public class DataFramesSet implements Groupby{
        ArrayList<DataFrame> data;
        public DataFramesSet(){
            data = new ArrayList<DataFrame>();
        }

        public DataFrame max() {
            DataFrame tmpy = new DataFrame(data.get(0).getColnames(), data.get(0).getTypes());

            for (DataFrame df : data){
                Object[] maxValues = new Object[df.data.size()];
                Object max = new Object();
                for(Column col : df.data){
                    max = col.data.get(0);

                    for(Object elem : col.data){
                        if(elem > max){
                            max = elem;
                        }
                    }
                    maxValues[df.data.indexOf(col)] = max;
                }

                tmpy.add(maxValues);

            }

            return tmpy;
        }


    }

    public DataFramesSet groupby(String colname){
        Column col = getColumn(colname);
        DataFramesSet dfs = new DataFramesSet();
        ArrayList<Object> tmpy = new ArrayList<>();
        ArrayList<Integer> listOfIndex = new ArrayList<>();

        for(Object val : col.data){
            if(tmpy.contains(val)){
               // System.out.print("existing value");
                continue;
            }


            System.out.print("new value");
            tmpy.add(val);

            listOfIndex = col.getAllIndex(val);
            System.out.print(listOfIndex+"\n");
            DataFrame df = new DataFrame(getColnames(), getTypes());
            for(Integer index : listOfIndex){
                df.add(getRow(index));
            }

            dfs.data.add(df);
        }
        return dfs;
    }

}
