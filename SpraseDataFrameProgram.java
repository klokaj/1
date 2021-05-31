import java.util.*;

public class SpraseDataFrameProgram {

   // private COOValue ;

    public static void main(String[] argv) {
        SparseDataFrame df = new SparseDataFrame(new String[]{"kol1", "kol2", "kol3"},
                new String[]{"int", "double", "MyCustomType"}, 0);
        df.add(new Integer[]{1, 1, 0});
        df.add(new Integer[]{0, 1, 0});
        df.add(new Integer[]{0, 1, 0});
        df.add(new Integer[]{3, 1, 0});


        DataFrame df1 = new  DataFrame(new String[]{"kol1","kol2","kol3"},
                new String[]{"int","double","MyCustomType"});

        System.out.print(df1.size());
        DataFrame a;
        ArrayList<Object> aa;
        df1.add(new Object[]{0, 2 ,0});
        df1.add(new Object[]{8 , 0, 1});
        df1.add(new Object[]{0 , 0, 1});
        df1.add(new Object[]{0 , 0, 1});
        df1.add(new Object[]{1 , 1, 1});

        SparseDataFrame df3 = new SparseDataFrame(df1, 0);
        // System.out.print(   ((COOValue) df.get("kol1").get(0)).data    );
        System.out.print(df3.data.get(0).data);
    }
}

