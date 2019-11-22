import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

import java.util.Iterator;

public class RouterActor extends AbstractActor {
    private ActorRef StoreActor = getContext().actorOf(
            Props.create(StoreActor.class), "Storage"
    );
    private ActorRef TesterActor;
    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(StoreMessage.class, sm ->StoreActor.tell(sm, self()))
                .match(GetMessage.class, gm ->StoreActor.tell(gm, sender()))
                .match(JsRequestMessage.class, jrm ->{
                    Iterator<Object[]> iter = jrm.tests.iterator();

                })


    }
}
