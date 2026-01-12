public class Question1 {
    public int residuePrefixes(String s) {
        boolean[] seen = new boolean[26];
        int distinct = 0;
        int res = 0;

        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(!seen[index]){
                seen[index] = true;
                distinct++;
            }
            int prefixLen = i+1;
            if(distinct == prefixLen%3)
                res++;
        }
        return res;
    }
}
