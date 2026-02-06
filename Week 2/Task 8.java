
class UserMainCode {
    public int totalHillWeight(int input1, int input2, int input3) {
        int total = 0;
        for(int level = 1; level <= input1; level++){
            int weight = input2 + (level - 1) * input3;
            total += level * weight;
        }
        return total;
    }
}