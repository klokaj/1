import java.util.*;
public class SparseDataFrame extends DataFrame {
   // ArrayList<ArrayList<COOValue>> v;
    int size = 0;
    Object hide;

    public SparseDataFrame(String[] _col, String[] _types, Object _hide){
        super(_col, _types);
        hide = _hide;
    }

    public SparseDataFrame(DataFrame _df, Object _hide){
        data = new ArrayList<Column>();
        hide = _hide;

        for(Column col : _df.data){
            data.add(new Column(col.name, col.type));
            for(Object elem : col.data){
                if( hide != (elem)){
                    data.get(  _df.data.indexOf(col)    ).data.add( new COOValue(col.data.indexOf(col), elem));
                }
            }
        }
    }


    public void add(Object[] values){

        int i = 0;
        for(Object v : values){
            if(v != hide){
                data.get(i).data.add(new COOValue(size, v));
            }

            i++;
            if(i >= data.size()){
                break;
            }
        }

        size++;
    }

    public int getSize(){
        return size;
    }

    public Object getValue(int _col, int _row){

        Column col = data.get(_col);
        for(Object elem : col.data){
            if(((COOValue)elem).index == _row){
                return ((COOValue)elem).index;
            }

            if(((COOValue)elem).index > _row){
                return hide;
            }
        }
        return null;
    }

    public Object[] getRow(int rowIndex){
        Object[] row = new Object[data.size()];
        for(Column col : data){
            row[data.indexOf(col)] = getValue(data.indexOf(col), rowIndex);
        }
        return row;
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
