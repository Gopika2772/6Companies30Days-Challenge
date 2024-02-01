package Google;

class asteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m=mass;
        for(int a:asteroids){
            if((long)a>m)return false;
            m+=a;
        }
        return true;
    }
}
