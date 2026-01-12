class Solution {
    public int flipLights(int n, int presses) {
        // 1 to n bulbs
        // status after x presses?

        if(presses==0){
            return 1;
        }
        n = Math.min(n, 6); // patterns repeat after 6 bulbs
        Set<String> seen = new HashSet<>();

        // 4 buttons -> 16 combinations
        for(int mask = 0; mask<16; mask++){
            int count = Integer.bitCount(mask);
            if(count>presses){
                continue;
            }
            if((count-presses)%2 !=0){
                continue;
            }

            int[] bulb = new int[n];
            for(int i=0; i<n; i++){
                bulb[i] = 1; //on
            }

            if((mask & 1) !=0){ //b1: flip all 
                for(int i=0; i<n; i++){
                    bulb[i]^=1;
                }
            }
            if((mask & 2) !=0){ //b2: flip even
                for(int i=1; i<n; i=i+2){
                    bulb[i]^=1;
                }
            }
            if((mask & 4) !=0){ //b3: flip odd
                for(int i=0; i<n; i=i+2){
                    bulb[i]^=1;
                }
            }
            if((mask & 8) !=0){ //b4: flip third
                for(int i=0; i<n; i=i+3){
                    bulb[i]^=1;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int b : bulb) sb.append(b);
            seen.add(sb.toString());
        }

        return seen.size();
    }
}
