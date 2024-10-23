import java.util.*;

public class Operator {
    String name;
    ArrayList<Integer> baseStation;
    static Map<String, ArrayList<Integer>>operators=new LinkedHashMap<>();

    public Operator(){}

    public Operator(String name, ArrayList<Integer> baseStation) {
        this.name = name;
        this.baseStation = baseStation;
        if (operators.containsKey(this.name))
        {
            operators.get(this.name).addAll(this.baseStation);
        } else {
        operators.put(this.name, this.baseStation);}
    }

    public Map<String, Integer> checkCoverage(int x, int y){
        Map<String, Integer> res=new LinkedHashMap<>();

        for(Map.Entry<String, ArrayList<Integer>> entr : operators.entrySet()){
            int service = 0;
            for (int i = 0; i <entr.getValue().size() ; i+=3) {
                int s= (int) (Math.pow((entr.getValue().get(i)-x),2) +  Math.pow((entr.getValue().get(i+1)-y),2));
                if (s <= Math.pow(entr.getValue().get(i+2), 2)) {service=1;}
                    if(res.containsKey(entr.getKey())){
                        res.put(entr.getKey(),service+=service);}
                    else res.put(entr.getKey(),service);
            }
        }
        return res;
    }
}
