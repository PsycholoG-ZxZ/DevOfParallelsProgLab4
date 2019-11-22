import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<String, String> store = new HashMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuider.create()
                .match(StoreMess.class, m -> {
                    store.put(m.getKey(), m.getValue());
                    System.out.println("receive mess!" + m.toString());
                })
                .match(GetMessage.class, req -> sender().tell(
                        new StoreMessage(req.getKey(), store )
                ))

    }
}
