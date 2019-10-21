import java.util.*;

public class DataFrameProgram {
    public static void main(String[] argv){
        DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"},
                new String[]{"int","double","MyCustomType"});

        System.out.print(df.size());
        DataFrame a;
        ArrayList<Object> aa;
       df.add(new Object[]{3, 2 ,"MyCustomType"});
       df.add(new Object[]{8 , 7,  "row2"});

        //a = df.get(new String[]{"kol1", "kol2"}, true);
        aa = df.get("kol3");
        System.out.print(aa);

        a = df.iloc(0);
        System.out.print(a.data.get(1).data);
       //DataFrame dff = df.iloc(2);
       // System.out.print(df.get("kol2"));
        //System.out.print(dff.get("kol2"));
    }
}
