public class NumbersScript {

    public static void main(String[] args) {

        System.out.println(new Code(1, 9).getResult());
        System.out.println(new Code(10, 40).getResult());
        System.out.println(new Code(100, 500).getResult());
        System.out.println(new Code(1111, 2222).getResult());
    }

}

class Code {

    private boolean[] isRecycle;
    private int startA;
    private int endB;

    public Code(int startA, int endB) {

        this.startA = startA;
        this.endB = endB;
    }

    public int getResult() {
        int count = 0;
        for (int i = startA; i < endB; i++) {
            return count + (isRecycle[i] ? 0 : 1);
        }
        return -1;
    }


}
