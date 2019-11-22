import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.ScriptEngine;

public class SingleTestActor extends AbstractActor{
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(ClassForTest.class, m -> {
                    ScriptEngine engine = new ScriptEngine engine = new;

                })
                .match(GetMessage.class, req -> sender().tell(
                        new StoreMessage(req.getKey(), store.get(req.getKey())), self())
                ).build();
    }

}
