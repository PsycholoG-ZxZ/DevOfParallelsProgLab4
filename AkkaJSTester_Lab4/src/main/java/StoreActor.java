import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<String, JsRequestMessage> store = new HashMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(ClassForTest.class, m -> {
                    if (this.store.containsKey(m.getPackageId())) {
                        this.store.get(m.getPackageId()).tests.add(m.getTests());
                    }else{
                        JsRequestMessage jsReqM = new JsRequestMessage(m);
                        this.store.put(m.getPackageId(), jsReqM);
                    }
                })
                .match(GetMessage.class, req -> sender().tell(
                        new ResultsMessages(req.getPackageId(), this.store.get(req.getPackageId()).getTests()),self())
                ).build();
    }
}
