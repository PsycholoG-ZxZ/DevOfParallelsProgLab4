import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<String, ArrayList<String>> store = new HashMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(StoreMessage.class, m -> {
                    store.put(m.getPackageId(), m.getValue());
                    System.out.println("receive mess!" + m.toString());
                })
                .match(GetMessage.class, req -> sender().tell(
                        new ResultsMessages(req.getPackageId(), store.get(req.getPackageId())),self())
                ).build();
    }
}
