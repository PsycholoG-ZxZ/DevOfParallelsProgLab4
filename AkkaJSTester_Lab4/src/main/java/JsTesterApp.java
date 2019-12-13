import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.stream.ActorMaterializer;
import scala.App;

import java.io.IOException;

public class JsTesterApp {
    public static void main(String[] args ) throws IOException {
        ActorSystem system = ActorSystem.create("test");
        ActorRef storeActor = system.actorOf(
                Props.create(StoreActor.class)
        );

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        JsTesterApp app = new JsTesterApp();
        JsTesterApp inst = new JsTesterApp();
    }
}
