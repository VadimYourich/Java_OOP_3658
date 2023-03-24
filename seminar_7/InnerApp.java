package seminar_7;

import java.util.Objects;

public class InnerApp {
    IInterface v;

    public InnerApp(IInterface v){
        this.v = Objects.requireNonNullElseGet(v, NullInterface::new);
    }
    
    void write() {
        v.print();
    }
}
