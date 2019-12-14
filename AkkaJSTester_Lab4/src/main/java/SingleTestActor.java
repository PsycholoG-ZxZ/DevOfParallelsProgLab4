import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class SingleTestActor extends AbstractActor{
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(ClassForTest.class, m -> {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(m.getJsScript());
                    Invocable invocable = (Invocable) engine;
                    StoreMessage msg = new StoreMessage(m.getPackageId(), invocable.invokeFunction(m.functionName, m.tests).toString());
                    m.setStatus(m.getTests().getExResult() == msg.getValue());
                    System.out.println("Сказал!");
                    sender().tell(m, ActorRef.noSender());

                })
                .build();
    }

}
