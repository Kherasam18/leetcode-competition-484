public class Question2 {
    public int centeredSubarrays(int[] nums) {
        int[] arr = nums;
        int count = 0;
        int n = arr.length;

        for(int start=0; start<n; start++){
            int sum=0;
            Set<Integer> elements = new HashSet<>();

            for(int end=start; end<n; end++){
                sum += arr[end];
                elements.add(arr[end]);

                if(elements.contains(sum))
                    count++;
            }
        }
        return count;
    }
}
