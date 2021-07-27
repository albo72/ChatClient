package client.albo.server.interaction;

public class CountOfMessages {
    private int count;

    public CountOfMessages(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    public void enlargeCount(){
        count++;
    }
}
