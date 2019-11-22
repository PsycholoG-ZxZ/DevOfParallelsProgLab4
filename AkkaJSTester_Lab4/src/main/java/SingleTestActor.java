import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class SingleTestActor extends AbstractActor{
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(ClassForTest.class, m -> {
                    store.put(m.getKey(), m.getValue());
                    System.out.println("receive message! "+m.toString());
                })
                .match(GetMessage.class, req -> sender().tell(
                        new StoreMessage(req.getKey(), store.get(req.getKey())), self())
                ).build();
    }

}
