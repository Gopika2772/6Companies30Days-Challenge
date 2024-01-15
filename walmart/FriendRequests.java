class friendRequests {
    public int numFriendRequests(int[] ages) {
        int[] countAges = new int[121];
        int requests = 0;

        for (int age : ages) {
            countAges[age]++;
        }

        for (int age = 0; age <= 120; age++) {
            for (int friend = (int)(0.5 * age) + 8; friend <= age; friend ++) {
                requests += countAges[age] * countAges[friend];

                if (age == friend) requests -= countAges[age];
            }
        }

        return requests;
    }
}