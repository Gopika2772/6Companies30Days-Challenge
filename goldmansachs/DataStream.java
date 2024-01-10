class DataStream {

    int val,condition,count;
    public DataStream(int value, int k) {
        val=value;
        condition=k;
        count=0;
        
    }
    
    public boolean consec(int num) {
        if(num==val){
            count++;
        }
        else{
            count=0;
        }
        return count>=condition;
    }
}


