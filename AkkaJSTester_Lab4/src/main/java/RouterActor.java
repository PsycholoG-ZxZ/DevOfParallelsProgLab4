import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class RouterActor extends AbstractActor {
    private ActorRef StoreActor = getContext().actorOf(
            Props.create(StoreActor.class), "Storage"
    );
    
    @Override
    public AbstractActor.Receive createReceive() {



    }
}
