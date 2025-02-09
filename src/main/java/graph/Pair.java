package graph;

public class Pair<T, S> {
    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    private T first;
    private S second;

    public Pair(T pair1, S pair2) {
        this.first = pair1;
        this.second = pair2;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}