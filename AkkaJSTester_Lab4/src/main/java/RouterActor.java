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
                .match(ClassForTest.class, sm ->StoreActor.tell(sm, self()))
                .match(JsRequestMessage.class, this:: streamMessageReq
                ).build();
    }



    private void streamMessageReq(JsRequestMessage req){
        for (int i = 0 ; i < req.getTests().size(); i++){
            System.out.println("test" + i);
            ActorRef singeTestActor = getContext().actorOf(Props.create(SingleTestActor.class), "TestActor"+i);
            //singeTestActor.tell(new JsRequestMessage(req.getPackId(),req.getJsScript(),req.getFunctionName(),req.getTests()),sender());
            singeTestActor.tell(new ClassForTest(req.getPackId(),req.getFunctionName(),req.getJsScript(), req.getTests().get(i)),sender());

        }
    }
}
