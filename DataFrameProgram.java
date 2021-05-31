import java.util.*;

public class DataFrameProgram {
    public static void main(String[] argv){
        DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"},
                new String[]{"int","double","MyCustomType"});


       df.add(new Object[]{0, 2 ,"MyCustomType"});
       df.add(new Object[]{8 , 7,  "row2"});
        df.add(new Object[]{4, 1 ,"MyCustomType"});
        df.add(new Object[]{8 , 1,  "row2"});
        df.add(new Object[]{3, 2 ,"MyCustomType"});
        df.add(new Object[]{8 , 4,  "row2"});
        df.add(new Object[]{5, 2 ,"MyCustomType"});
        df.add(new Object[]{8 , 0,  "row2"});

        DataFrame.DataFramesSet size = df.groupby("kol1");
        DataFrame max = size.max();

        System.out.print(size.data.get(1).data.get(2).data);
       //DataFrame dff = df.iloc(2);
       // System.out.print(df.get("kol2"));
        //System.out.print(dff.get("kol2"));
    }
}
