import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class JsTesterApp {
    public v
    ActorSystem system = ActorSystem.create("test");
    ActorRef storeActor = system.actorOf(
            Props.create(StoreActor.class)
    );
}
