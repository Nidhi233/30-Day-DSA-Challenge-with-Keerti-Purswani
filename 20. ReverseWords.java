class Solution {
    public String reverseWords(String s) {
        String[] st = s.split(" ");
        int n = st.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            String t = st[left];
            st[left] = st[right];
            st[right] = t;

            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<st.length; i++){
            if(st[i].isEmpty()){
                continue;
            }
            sb.append(st[i] + " ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
