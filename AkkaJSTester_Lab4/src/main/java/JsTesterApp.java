import akka.NotUsed;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

import static akka.http.javadsl.server.Directives.get;
import static akka.http.javadsl.server.Directives.route;

public class JsTesterApp {
    public static void main(String[] args ) throws IOException {
        ActorSystem system = ActorSystem.create("test");
        ActorRef storeActor = system.actorOf(
                Props.create(StoreActor.class)
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
                            Future<Object> futureRes = Pattern.ask(
                                    RouterActor, 
                            )
                        })
                )
        )
    }
}
