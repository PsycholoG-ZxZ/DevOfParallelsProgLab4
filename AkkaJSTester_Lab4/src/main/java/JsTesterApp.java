import akka.NotUsed;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import java.io.IOException;
import java.util.concurrent.CompletionStage;

import akka.pattern.Patterns;
import scala.concurrent.Future;

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

        final Flow<HttpRequest, HttpResponse, NotUsed> directFlow = app.routeCreater(routerActor).flow(system, materializer);
        final CompletionStage<ServerBinding> bind = http.bindAndHandle( directFlow, ConnectHttp.toHost("localhost", 8008),
                materializer);
        System.out.println("Server online at localhost");
    }

    public Route routeCreater(ActorRef routerActor){
        return route(
                get(
                        () -> parameter("packageId", packId ->{
                            Future<Object> futureRes = Patterns.ask(
                                    routerActor,
                                    new GetMessage(packId),5000);
                            return completeOKWithFuture(futureRes, Jackson.marshaller());
                        })
                ),
                post(
                        () -> entity(Jackson.unmarshaller(JsRequestMessage.class), x ->{
                            routerActor.tell(x, ActorRef.noSender());
                            System.out.println("Post done");
                            return complete("Test started!");
                        })
                )
        );
    }
}
