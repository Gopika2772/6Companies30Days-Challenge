class checkOverlap {
    public boolean checkOverlap(int radius, int xcenter, int ycenter, int x1, int y1, int x2, int y2) {
        int nearestx=Math.max(x1,Math.min(x2,xcenter));
        int nearesty=Math.max(y1,Math.min(y2,ycenter));

        int distx=xcenter-nearestx;
        int disty=ycenter-nearesty;

        return distx*distx + disty*disty <=radius*radius;
        
    }
}