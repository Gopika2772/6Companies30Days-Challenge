package Google;

class scores {
    public long sumScores(String s) {
        char []a = s.toCharArray();
        int []z= zarray(a);
        long count=0;
        for (int i:z)
        count+=i;
        return count;
    }
    public int[] zarray(char[] a)
    {
        int []z = new int[a.length];
        z[0]=a.length;
        int left =0;
        int right=0;
        for(int k=1;k<a.length;k++)
        {
            if (k>right)
            {
                left=right=k;
                while (right<a.length && a[right]==a[right-left])
                right++;
                z[k]=right-left;
                right--;
            }
            else 
            {
                int k1= k-left;
                if (z[k1] < right-k+1)
                z[k]=z[k1];
                else 
                {
                    left=k;
                    while (right<a.length && a[right]==a[right-left])
                    right++;
                    z[k]=right-left;
                    right--;
                }
            }
        }
        return z;
    }
}