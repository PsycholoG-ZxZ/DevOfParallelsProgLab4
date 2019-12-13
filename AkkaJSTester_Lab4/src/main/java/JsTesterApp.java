import akka.NotUsed;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import java.io.IOException;
import java.util.concurrent.Future;
import akka.pattern.Patterns;

import static akka.http.javadsl.server.Directives.*;

public class JsTesterApp {
    public static void main(String[] args ) throws IOException {
        ActorSystem system = ActorSystem.create("test");
        ActorRef storeActor = system.actorOf(
                Props.create(StoreActor.class)
        );
        ActorRef routerActor = system.actorOf(
                Props.create(RouterActor.class)
        );

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        JsTesterApp app = new JsTesterApp();

        final Flow<HttpRequest, HttpResponse, NotUsed> directFlow = app
    }

    public Route routeCreater(){
        return route(
                get(
                        () -> parameter("packageId", packId ->{
                            Future<Object> futureRes = Patterns.ask(
                                    
                                    , new GetMessage(packId),5000);
                            return completeOKWithFuture(futureRes, Jackson.marshaller());
                            )
                        })
                )
        )
    }
}
