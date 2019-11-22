import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class RouterActor extends AbstractActor {
    @Override
    public AbstractActor.Receive createReceive() {
        private ActorRef StoreActor = getContext().actorOf(
                Props.create(StoreActor::new)
        )


    }
}
