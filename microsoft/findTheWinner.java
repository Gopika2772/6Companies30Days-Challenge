import java.util.*;

class findTheWinner {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> participants=new LinkedList<>();
        for(int i=1;i<=n;i++){
            participants.add(i);
        }
        int lastkilled=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<k-1;j++){
                participants.add(participants.poll());
            }
            lastkilled=participants.poll();
        }
        return lastkilled;
    }
}