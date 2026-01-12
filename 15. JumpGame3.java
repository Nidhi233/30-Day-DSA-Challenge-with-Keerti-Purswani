class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(arr[curr]==0){
                return true;
            }
            if(arr[curr]==-1){
                continue;
            }
            int jump = arr[curr];
            arr[curr] = -1;
            if(curr+jump <n){
                q.add(jump+curr);
            }
            if(curr-jump>=0){
                q.add(curr-jump);
            }

        }
        return false;
    }
}

// class Solution {
//     // no subproblem => no dp
//     // no tree => as cycles present
//     // form graph - can do dfs or bfs
//     public boolean canReach(int[] arr, int start) {
//         int n = arr.length;
//         boolean ans = dfs(arr, start, n);
//         return ans;
//     }
//     private static boolean dfs(int[] arr, int i, int n){
//         if(i<0 || i>=n){
//             return false;
//         }

//         if(arr[i] == -1){ //visited
//             return false;
//         }

//         if(arr[i]==0){
//             return true;
//         }

//         int jump = arr[i];
//         arr[i] = -1; // mark visited as arr[] is non-neg
//         return dfs(arr, i+jump, n) || dfs(arr, i-jump, n);
//     }
// }
