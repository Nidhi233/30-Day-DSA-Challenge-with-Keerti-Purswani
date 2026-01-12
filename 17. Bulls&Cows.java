class Solution {
    public String getHint(String secret, String guess) {
        // x = correct pos
        // y = incorrect pos
        int x=0;
        int y=0;
        char[] sc = secret.toCharArray();
        char[] gu = guess.toCharArray();

        HashMap<Character, Integer> mpp = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<sc.length; i++){
            if(sc[i] == gu[i]){
                x++;
                sc[i] = '#';
                gu[i] = '#';
            } else{
                mpp.put(sc[i], mpp.getOrDefault(sc[i],0)+1);
            }
        }
        System.out.println(x);
        sb.append(String.valueOf(x));
        sb.append('A');

        // mpp has sc numbers+freq
        for(int i=0; i<gu.length; i++){
            if(mpp.containsKey(gu[i])){
                y++;
                mpp.put(gu[i], mpp.get(gu[i])-1);
                if(mpp.get(gu[i])==0){
                    mpp.remove(gu[i]);
                }
            }
        }
        System.out.println(y);
        sb.append(String.valueOf(y));
        sb.append('B');

        return sb.toString();
    }
}
