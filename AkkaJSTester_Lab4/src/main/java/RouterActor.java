import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

import java.util.Iterator;
import java.util.stream.Stream;

public class RouterActor extends AbstractActor {
    private ActorRef StoreActor = getContext().actorOf(
            Props.create(StoreActor.class), "Storage"
    );
    private ActorRef RouterAct = getContext().actorOf(
            new RoundRobinPool(3).props(Props.create(SingleTestActor.class))
    , "Router");
    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(StoreMessage.class, sm ->StoreActor.tell(sm, self()))
                .match(JsRequestMessage.class, this:: streamMessageReq
                ).build();
    }

    private void streamMessageReq(JsRequestMessage req){
        Stream.of(req.getTests()).map((t -> new ClassForTest(req.getPackId(), req.getFunctionName(), req.getJsScript(), t))).forEach(tt ->
                this.RouterAct.tell(tt, this.StoreActor));
    }
}
